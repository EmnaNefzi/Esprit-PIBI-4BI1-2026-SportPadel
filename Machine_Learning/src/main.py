"""
main.py - Pipeline ML complet aligné avec les captures du projet Padel

Objectifs :
- Classification : bon joueur ou non (good_player basé sur avg_ranking)
- Régression     : prédire avg_points
- Clustering     : segmenter les joueurs
- Export         : résultats + modèles sauvegardés

Lance avec :
    python src/main.py
"""

import os
import sys
import warnings
import joblib
import numpy as np
import pandas as pd
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

from sqlalchemy import create_engine, text

from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
from sklearn.impute import SimpleImputer

from sklearn.linear_model import LogisticRegression, Ridge
from sklearn.ensemble import RandomForestClassifier, RandomForestRegressor
from sklearn.cluster import KMeans, DBSCAN
from sklearn.decomposition import PCA

from sklearn.metrics import (
    accuracy_score,
    precision_score,
    recall_score,
    f1_score,
    roc_auc_score,
    mean_squared_error,
    mean_absolute_error,
    r2_score,
    silhouette_score,
    davies_bouldin_score,
    confusion_matrix,
    classification_report,
    ConfusionMatrixDisplay,
    RocCurveDisplay,
)

sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from config import (
    DATABASE_URL,
    MODELS_DIR,
    KMEANS_MODEL_PATH,
    KMEANS_SCALER_PATH,
    RF_REG_MODEL_PATH,
    RF_CLF_MODEL_PATH,
    RIDGE_MODEL_PATH,
    LOG_MODEL_PATH,
)

warnings.filterwarnings("ignore")
os.makedirs(MODELS_DIR, exist_ok=True)


# =========================================================
# CONFIG
# =========================================================
RANDOM_STATE = 42

REGRESSION_FEATURES = [
    "matches_played",
    "matches_won",
    "tournaments_played",
    "win_rate",
    "activity_level",
    "avg_equipment_price",
    "gender",
    "country",
]

CLASSIFICATION_FEATURES = [
    "matches_played",
    "matches_won",
    "tournaments_played",
    "win_rate",
    "activity_level",
    "avg_equipment_price",
    "gender",
    "country",
]

CLUSTER_FEATURES = [
    "avg_ranking",
    "avg_points",
    "matches_played",
    "tournaments_played",
    "points_per_match",
    "avg_equipment_price",
]


# =========================================================
# HELPERS
# =========================================================
def cap_outliers_iqr(df: pd.DataFrame, columns: list[str]) -> pd.DataFrame:
    """Cap outliers using the IQR rule."""
    out = df.copy()
    for col in columns:
        if col not in out.columns:
            continue
        q1 = out[col].quantile(0.25)
        q3 = out[col].quantile(0.75)
        iqr = q3 - q1
        lower = q1 - 1.5 * iqr
        upper = q3 + 1.5 * iqr
        out[col] = out[col].clip(lower, upper)
    return out


def try_load_player_dataset(engine) -> pd.DataFrame:
    """
    Charge un dataset agrégé par joueur.
    Essaie d'abord une requête enrichie avec fact_match_stats,
    puis fallback si cette table ou ses colonnes ne sont pas disponibles.
    """
    query_rich = """
    SELECT
        fps.player_key,
        COALESCE(dp.player_name, 'Unknown') AS player_name,
        COALESCE(dp.country, 'Unknown') AS country,
        COALESCE(dp.gender, 'Unknown') AS gender,
        AVG(COALESCE(fps.rank, dp.position, 9999)) AS avg_ranking,
        AVG(COALESCE(fps.points, 0)) AS avg_points,
        SUM(COALESCE(fps.matches_played, 0)) AS matches_played,
        SUM(COALESCE(fps.matches_won, 0)) AS matches_won,
        SUM(COALESCE(fps.matches_lost, 0)) AS matches_lost,
        COUNT(DISTINCT fms.tournament_key) AS tournaments_played,
        AVG(COALESCE(de.price, 0)) AS avg_equipment_price
    FROM dw.fact_player_stats fps
    LEFT JOIN dw.dim_player dp
        ON fps.player_key = dp.player_key
    LEFT JOIN dw.dim_equipment de
        ON fps.equipment_key = de.equipment_key
    LEFT JOIN dw.fact_match_stats fms
        ON fps.player_key = fms.player_key
    GROUP BY
        fps.player_key,
        dp.player_name,
        dp.country,
        dp.gender
    """

    query_fallback = """
    SELECT
        fps.player_key,
        COALESCE(dp.player_name, 'Unknown') AS player_name,
        COALESCE(dp.country, 'Unknown') AS country,
        COALESCE(dp.gender, 'Unknown') AS gender,
        AVG(COALESCE(fps.rank, dp.position, 9999)) AS avg_ranking,
        AVG(COALESCE(fps.points, 0)) AS avg_points,
        SUM(COALESCE(fps.matches_played, 0)) AS matches_played,
        SUM(COALESCE(fps.matches_won, 0)) AS matches_won,
        SUM(COALESCE(fps.matches_lost, 0)) AS matches_lost,
        COUNT(DISTINCT fps.fact_player_stats_key) AS tournaments_played,
        AVG(COALESCE(de.price, 0)) AS avg_equipment_price
    FROM dw.fact_player_stats fps
    LEFT JOIN dw.dim_player dp
        ON fps.player_key = dp.player_key
    LEFT JOIN dw.dim_equipment de
        ON fps.equipment_key = de.equipment_key
    GROUP BY
        fps.player_key,
        dp.player_name,
        dp.country,
        dp.gender
    """

    try:
        df = pd.read_sql(query_rich, engine)
        print("[OK] Dataset joueur enrichi chargé avec fact_match_stats.")
        return df
    except Exception as e:
        print(f"[WARN] Requête enrichie indisponible : {e}")
        print("[INFO] Utilisation de la requête fallback.")
        df = pd.read_sql(query_fallback, engine)
        print("[OK] Dataset joueur fallback chargé.")
        return df


def save_feature_importance_from_rf_pipeline(model_pipeline, feature_names, out_path, title):
    rf_model = model_pipeline.named_steps["model"]
    importances = pd.DataFrame({
        "feature": feature_names,
        "importance": rf_model.feature_importances_,
    }).sort_values("importance", ascending=False).head(15)

    print(f"\n[INFO] Top features - {title}")
    print(importances)

    plt.figure(figsize=(9, 6))
    plt.barh(importances["feature"], importances["importance"])
    plt.gca().invert_yaxis()
    plt.title(title)
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()


def get_transformed_feature_names(preprocessor, num_cols, cat_cols):
    cat_names = []
    if len(cat_cols) > 0:
        ohe = preprocessor.named_transformers_["cat"].named_steps["onehot"]
        cat_names = ohe.get_feature_names_out(cat_cols).tolist()
    return list(num_cols) + cat_names


# =========================================================
# 1. CONNEXION
# =========================================================
print("=" * 70)
print("   PADEL ML PIPELINE - VERSION ALIGNÉE AVEC LES CAPTURES")
print("=" * 70)

engine = create_engine(DATABASE_URL)

try:
    with engine.connect() as conn:
        conn.execute(text("SELECT 1"))
    print("[OK] Connexion PostgreSQL réussie.")
except Exception as e:
    print(f"[ERREUR] Connexion PostgreSQL : {e}")
    raise


# =========================================================
# 2. EXTRACTION + DATA PREPARATION
# =========================================================
df = try_load_player_dataset(engine)
print(f"[OK] Dataset brut : {df.shape[0]} lignes, {df.shape[1]} colonnes.")

df = df.drop_duplicates()

numeric_cols = [
    "avg_ranking",
    "avg_points",
    "matches_played",
    "matches_won",
    "matches_lost",
    "tournaments_played",
    "avg_equipment_price",
]
for col in numeric_cols:
    if col in df.columns:
        df[col] = pd.to_numeric(df[col], errors="coerce")

for col in numeric_cols:
    if col in df.columns:
        df[col] = df[col].fillna(df[col].median())

for col in ["player_name", "country", "gender"]:
    if col in df.columns:
        df[col] = df[col].fillna("Unknown")

df = df[df["matches_played"] > 0].copy()

# Outliers
df = cap_outliers_iqr(df, numeric_cols)

print(f"[OK] Après nettoyage : {df.shape[0]} joueurs.")


# =========================================================
# 3. FEATURE ENGINEERING
# =========================================================
df["win_rate"] = np.where(
    df["matches_played"] > 0,
    df["matches_won"] / df["matches_played"],
    0.0,
)

df["activity_level"] = df["matches_played"] / (df["tournaments_played"] + 1)
df["points_per_match"] = df["avg_points"] / df["matches_played"].replace(0, np.nan)
df["points_per_match"] = df["points_per_match"].replace([np.inf, -np.inf], np.nan).fillna(0)

# Classification target : basé sur la médiane du ranking (équilibré)
median_ranking = df["avg_ranking"].median()
df["player_level"] = (df["avg_ranking"] <= median_ranking).astype(int)

print("[OK] Feature engineering terminé.")
print("     - win_rate")
print("     - activity_level")
print("     - points_per_match")
print(f"     - player_level = (avg_ranking <= {median_ranking:.1f} [médiane])")
print(f"     - Distribution : {df['player_level'].value_counts().to_dict()}")


# =========================================================
# 4. CLUSTERING
# =========================================================
print("\n[INFO] Entraînement Clustering...")

cluster_df = df[CLUSTER_FEATURES].copy()
cluster_df = cluster_df.fillna(cluster_df.median(numeric_only=True))

scaler_cluster = StandardScaler()
X_cluster = scaler_cluster.fit_transform(cluster_df)

k_range = range(2, 9)
sil_scores = []
inertias = []

for k in k_range:
    km = KMeans(n_clusters=k, random_state=RANDOM_STATE, n_init=10)
    labels = km.fit_predict(X_cluster)
    sil_scores.append(silhouette_score(X_cluster, labels))
    inertias.append(km.inertia_)

best_k = list(k_range)[int(np.argmax(sil_scores))]
print(f"[OK] Meilleur k (silhouette) = {best_k}")

kmeans_model = KMeans(n_clusters=best_k, random_state=RANDOM_STATE, n_init=10)
cluster_labels = kmeans_model.fit_predict(X_cluster)

df["cluster_kmeans"] = cluster_labels

kmeans_sil = silhouette_score(X_cluster, cluster_labels)
kmeans_db = davies_bouldin_score(X_cluster, cluster_labels)

print(f"KMeans Silhouette     : {kmeans_sil:.4f}")
print(f"KMeans Davies-Bouldin : {kmeans_db:.4f}")

dbscan_model = DBSCAN(eps=1.2, min_samples=5)
dbscan_labels = dbscan_model.fit_predict(X_cluster)
df["cluster_dbscan"] = dbscan_labels

valid_mask = dbscan_labels != -1
if valid_mask.sum() > 1 and len(set(dbscan_labels[valid_mask])) > 1:
    dbscan_sil = silhouette_score(X_cluster[valid_mask], dbscan_labels[valid_mask])
    dbscan_db = davies_bouldin_score(X_cluster[valid_mask], dbscan_labels[valid_mask])
    print(f"DBSCAN Silhouette     : {dbscan_sil:.4f}")
    print(f"DBSCAN Davies-Bouldin : {dbscan_db:.4f}")
else:
    print("DBSCAN : pas assez de clusters exploitables pour silhouette/DB.")

cluster_profile = df.groupby("cluster_kmeans")[CLUSTER_FEATURES].mean(numeric_only=True)
print("\n[INFO] Profil des clusters :")
print(cluster_profile)

# PCA
pca = PCA(n_components=2, random_state=RANDOM_STATE)
X_pca = pca.fit_transform(X_cluster)

plt.figure(figsize=(8, 6))
for c in sorted(pd.Series(cluster_labels).unique()):
    subset = X_pca[cluster_labels == c]
    plt.scatter(subset[:, 0], subset[:, 1], label=f"Cluster {int(c)}", alpha=0.7)
plt.title("PCA 2D - KMeans Clusters")
plt.xlabel("PC1")
plt.ylabel("PC2")
plt.legend()
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "kmeans_pca.png"))
plt.close()

plt.figure(figsize=(8, 5))
plt.plot(list(k_range), inertias, marker="o")
plt.title("Elbow Method - KMeans")
plt.xlabel("k")
plt.ylabel("Inertia")
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "kmeans_elbow.png"))
plt.close()

plt.figure(figsize=(8, 5))
plt.plot(list(k_range), sil_scores, marker="o")
plt.title("Silhouette Score - KMeans")
plt.xlabel("k")
plt.ylabel("Silhouette")
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "kmeans_silhouette.png"))
plt.close()


# =========================================================
# 5. RÉGRESSION
# =========================================================
print("\n[INFO] Entraînement Régression...")

target_reg = "avg_points"
X_reg = df[REGRESSION_FEATURES].copy()
y_reg = df[target_reg].copy()

num_cols_reg = X_reg.select_dtypes(include=["int64", "float64"]).columns.tolist()
cat_cols_reg = X_reg.select_dtypes(include=["object"]).columns.tolist()

numeric_transformer = Pipeline([
    ("imputer", SimpleImputer(strategy="median")),
    ("scaler", StandardScaler()),
])

categorical_transformer = Pipeline([
    ("imputer", SimpleImputer(strategy="most_frequent")),
    ("onehot", OneHotEncoder(handle_unknown="ignore")),
])

preprocessor_reg = ColumnTransformer([
    ("num", numeric_transformer, num_cols_reg),
    ("cat", categorical_transformer, cat_cols_reg),
])

X_train_reg, X_test_reg, y_train_reg, y_test_reg = train_test_split(
    X_reg, y_reg, test_size=0.2, random_state=RANDOM_STATE
)

ridge_pipeline = Pipeline([
    ("preprocessor", preprocessor_reg),
    ("model", Ridge()),
])

ridge_params = {
    "model__alpha": [0.1, 1.0, 10.0, 50.0]
}

ridge_grid = GridSearchCV(
    ridge_pipeline,
    ridge_params,
    cv=5,
    scoring="r2",
    n_jobs=-1,
)
ridge_grid.fit(X_train_reg, y_train_reg)
best_ridge = ridge_grid.best_estimator_
ridge_pred = best_ridge.predict(X_test_reg)

ridge_mse = mean_squared_error(y_test_reg, ridge_pred)
ridge_rmse = np.sqrt(ridge_mse)
ridge_mae = mean_absolute_error(y_test_reg, ridge_pred)
ridge_r2 = r2_score(y_test_reg, ridge_pred)

print(f"Ridge best params : {ridge_grid.best_params_}")
print(f"Ridge RMSE        : {ridge_rmse:.4f}")
print(f"Ridge MAE         : {ridge_mae:.4f}")
print(f"Ridge R²          : {ridge_r2:.4f}")

rf_reg_pipeline = Pipeline([
    ("preprocessor", preprocessor_reg),
    ("model", RandomForestRegressor(random_state=RANDOM_STATE)),
])

rf_reg_params = {
    "model__n_estimators": [100, 200],
    "model__max_depth": [None, 5, 10],
    "model__min_samples_split": [2, 5],
}

rf_reg_grid = GridSearchCV(
    rf_reg_pipeline,
    rf_reg_params,
    cv=5,
    scoring="r2",
    n_jobs=-1,
)
rf_reg_grid.fit(X_train_reg, y_train_reg)
best_rf_reg = rf_reg_grid.best_estimator_
rf_reg_pred = best_rf_reg.predict(X_test_reg)

rf_mse = mean_squared_error(y_test_reg, rf_reg_pred)
rf_rmse = np.sqrt(rf_mse)
rf_mae = mean_absolute_error(y_test_reg, rf_reg_pred)
rf_r2 = r2_score(y_test_reg, rf_reg_pred)

print(f"RF best params    : {rf_reg_grid.best_params_}")
print(f"RF RMSE           : {rf_rmse:.4f}")
print(f"RF MAE            : {rf_mae:.4f}")
print(f"RF R²             : {rf_r2:.4f}")

results_reg = pd.DataFrame({
    "Model": ["Ridge", "RandomForestRegressor"],
    "MSE": [ridge_mse, rf_mse],
    "RMSE": [ridge_rmse, rf_rmse],
    "MAE": [ridge_mae, rf_mae],
    "R2": [ridge_r2, rf_r2],
})
print("\n[INFO] Comparaison Régression :")
print(results_reg)

plt.figure(figsize=(7, 5))
plt.scatter(y_test_reg, rf_reg_pred, alpha=0.7)
plt.xlabel("Actual avg_points")
plt.ylabel("Predicted avg_points")
plt.title("Actual vs Predicted - RF Regressor")
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "rf_reg_actual_vs_pred.png"))
plt.close()

residuals = y_test_reg - rf_reg_pred
plt.figure(figsize=(7, 5))
plt.scatter(rf_reg_pred, residuals, alpha=0.7)
plt.axhline(y=0, linestyle="--")
plt.xlabel("Predicted")
plt.ylabel("Residuals")
plt.title("Residual Plot - RF Regressor")
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "rf_reg_residuals.png"))
plt.close()

reg_feature_names = get_transformed_feature_names(
    best_rf_reg.named_steps["preprocessor"],
    num_cols_reg,
    cat_cols_reg,
)
save_feature_importance_from_rf_pipeline(
    best_rf_reg,
    reg_feature_names,
    os.path.join(MODELS_DIR, "rf_reg_feature_importance.png"),
    "Top 15 Feature Importance - RF Regressor",
)


# =========================================================
# 6. CLASSIFICATION
# =========================================================
print("\n[INFO] Entraînement Classification...")

target_clf = "player_level"
X_clf = df[CLASSIFICATION_FEATURES].copy()
y_clf = df[target_clf].copy()

num_cols_clf = X_clf.select_dtypes(include=["int64", "float64"]).columns.tolist()
cat_cols_clf = X_clf.select_dtypes(include=["object"]).columns.tolist()

preprocessor_clf = ColumnTransformer([
    ("num", numeric_transformer, num_cols_clf),
    ("cat", categorical_transformer, cat_cols_clf),
])

X_train_clf, X_test_clf, y_train_clf, y_test_clf = train_test_split(
    X_clf,
    y_clf,
    test_size=0.2,
    random_state=RANDOM_STATE,
    stratify=y_clf,
)

log_pipeline = Pipeline([
    ("preprocessor", preprocessor_clf),
    ("model", LogisticRegression(max_iter=2000)),
])

log_params = {"model__C": [0.1, 1, 10]}

log_grid = GridSearchCV(log_pipeline, log_params, cv=5, scoring="f1", n_jobs=-1)
log_grid.fit(X_train_clf, y_train_clf)
best_log = log_grid.best_estimator_
log_pred  = best_log.predict(X_test_clf)
log_proba = best_log.predict_proba(X_test_clf)[:, 1]

log_acc  = accuracy_score(y_test_clf, log_pred)
log_prec = precision_score(y_test_clf, log_pred, zero_division=0)
log_rec  = recall_score(y_test_clf, log_pred, zero_division=0)
log_f1   = f1_score(y_test_clf, log_pred, zero_division=0)
log_auc  = roc_auc_score(y_test_clf, log_proba)

print(f"Logistic best params : {log_grid.best_params_}")
print(f"Logistic Accuracy    : {log_acc:.4f}")
print(f"Logistic Precision   : {log_prec:.4f}")
print(f"Logistic Recall      : {log_rec:.4f}")
print(f"Logistic F1          : {log_f1:.4f}")
print(f"Logistic ROC-AUC     : {log_auc:.4f}")

rf_clf_pipeline = Pipeline([
    ("preprocessor", preprocessor_clf),
    ("model", RandomForestClassifier(random_state=RANDOM_STATE)),
])

rf_clf_params = {
    "model__n_estimators": [100, 200],
    "model__max_depth": [None, 5, 10],
    "model__min_samples_split": [2, 5],
}

rf_clf_grid = GridSearchCV(rf_clf_pipeline, rf_clf_params, cv=5, scoring="f1", n_jobs=-1)
rf_clf_grid.fit(X_train_clf, y_train_clf)
best_rf_clf  = rf_clf_grid.best_estimator_
rf_clf_pred  = best_rf_clf.predict(X_test_clf)
rf_clf_proba = best_rf_clf.predict_proba(X_test_clf)[:, 1]

rf_acc  = accuracy_score(y_test_clf, rf_clf_pred)
rf_prec = precision_score(y_test_clf, rf_clf_pred, zero_division=0)
rf_rec  = recall_score(y_test_clf, rf_clf_pred, zero_division=0)
rf_f1   = f1_score(y_test_clf, rf_clf_pred, zero_division=0)
rf_auc  = roc_auc_score(y_test_clf, rf_clf_proba)

print(f"RF best params       : {rf_clf_grid.best_params_}")
print(f"RF Accuracy          : {rf_acc:.4f}")
print(f"RF Precision         : {rf_prec:.4f}")
print(f"RF Recall            : {rf_rec:.4f}")
print(f"RF F1                : {rf_f1:.4f}")
print(f"RF ROC-AUC           : {rf_auc:.4f}")

results_clf = pd.DataFrame({
    "Model":     ["LogisticRegression", "RandomForestClassifier"],
    "Accuracy":  [log_acc,  rf_acc],
    "Precision": [log_prec, rf_prec],
    "Recall":    [log_rec,  rf_rec],
    "F1":        [log_f1,   rf_f1],
    "ROC_AUC":   [log_auc,  rf_auc],
})
print("\n[INFO] Comparaison Classification :")
print(results_clf)

print("\n[INFO] Confusion Matrix RF :")
print(confusion_matrix(y_test_clf, rf_clf_pred))

print("\n[INFO] Classification Report RF :")
print(classification_report(y_test_clf, rf_clf_pred, zero_division=0))

ConfusionMatrixDisplay.from_predictions(y_test_clf, rf_clf_pred)
plt.title("Confusion Matrix - RF Classifier")
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "rf_clf_confusion_matrix.png"))
plt.close()

RocCurveDisplay.from_predictions(y_test_clf, rf_clf_proba)
plt.title("ROC Curve - RF Classifier")
plt.tight_layout()
plt.savefig(os.path.join(MODELS_DIR, "rf_clf_roc_curve.png"))
plt.close()

clf_feature_names = get_transformed_feature_names(
    best_rf_clf.named_steps["preprocessor"],
    num_cols_clf,
    cat_cols_clf,
)
save_feature_importance_from_rf_pipeline(
    best_rf_clf,
    clf_feature_names,
    os.path.join(MODELS_DIR, "rf_clf_feature_importance.png"),
    "Top 15 Feature Importance - RF Classifier",
)


# =========================================================
# 7. SAUVEGARDE DES MODÈLES
# =========================================================
joblib.dump(kmeans_model,  KMEANS_MODEL_PATH)
joblib.dump(scaler_cluster, KMEANS_SCALER_PATH)
joblib.dump(best_rf_reg,   RF_REG_MODEL_PATH)
joblib.dump(best_rf_clf,   RF_CLF_MODEL_PATH)
joblib.dump(best_ridge,    RIDGE_MODEL_PATH)
joblib.dump(best_log,      LOG_MODEL_PATH)

print(f"\n[OK] Modèles sauvegardés dans : {MODELS_DIR}")
print(f" - {KMEANS_MODEL_PATH}")
print(f" - {KMEANS_SCALER_PATH}")
print(f" - {RF_REG_MODEL_PATH}")
print(f" - {RF_CLF_MODEL_PATH}")


# =========================================================
# 8. EXPORT DES RÉSULTATS VERS POSTGRESQL
# =========================================================
df["predicted_avg_points_rf"] = best_rf_reg.predict(X_reg)
df["predicted_good_player_rf"] = best_rf_clf.predict(X_clf)

cluster_input_full = df[CLUSTER_FEATURES].copy()
cluster_scaled_full = scaler_cluster.transform(cluster_input_full)
df["predicted_cluster_kmeans"] = kmeans_model.predict(cluster_scaled_full)

df.to_sql(
    "ml_player_results",
    engine,
    schema="public",
    if_exists="replace",
    index=False,
)

print("[OK] Table public.ml_player_results créée dans PostgreSQL.")
print("\n[DONE] Pipeline ML terminé avec succès.")