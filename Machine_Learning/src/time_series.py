import warnings
import sys
import os

warnings.filterwarnings("ignore")

sys.path.append(os.path.dirname(os.path.abspath(__file__)))

import numpy as np
import pandas as pd
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

from sqlalchemy import create_engine
from statsmodels.tsa.stattools import adfuller, kpss
from statsmodels.tsa.seasonal import seasonal_decompose
from statsmodels.tsa.arima.model import ARIMA
from statsmodels.tsa.statespace.sarimax import SARIMAX
from statsmodels.tsa.holtwinters import ExponentialSmoothing
from sklearn.metrics import mean_squared_error, mean_absolute_error

try:
    from prophet import Prophet
    PROPHET_AVAILABLE = True
    print("[INFO] Prophet disponible.")
except ImportError:
    PROPHET_AVAILABLE = False
    print("[WARN] Prophet non installé — ExponentialSmoothing sera utilisé à la place.")
    print("[HINT] Pour installer : pip install prophet")

from config import DATABASE_URL

# =========================================================
# 0. CONNEXION & EXTRACTION
# =========================================================
print("=" * 60)
print("  TIME SERIES ANALYSIS — Padel Player Performance")
print("=" * 60)

engine = create_engine(DATABASE_URL)

QUERY_TS = """
SELECT
    dt.year,
    dt.month,
    dt.full_date,
    AVG(fps.points)          AS avg_points,
    AVG(fps.rank)            AS avg_rank,
    SUM(fps.matches_played)  AS total_matches,
    COUNT(fps.player_key)    AS active_players,
    AVG(fps.matches_won::float / NULLIF(fps.matches_played, 0)) AS avg_win_rate
FROM dw.fact_player_stats fps
LEFT JOIN dw.dim_time dt ON fps.date_key = dt.date_key
WHERE dt.full_date IS NOT NULL
GROUP BY dt.year, dt.month, dt.full_date
ORDER BY dt.full_date ASC
"""

try:
    df_raw = pd.read_sql(QUERY_TS, engine)
    print(f"[OK] Données extraites : {len(df_raw)} périodes.")
except Exception as e:
    print(f"[WARN] Requête avec dim_time échouée ({e}).")
    print("[INFO] Génération de données synthétiques pour démonstration...")
    np.random.seed(42)
    n = 36
    dates = pd.date_range("2022-01-01", periods=n, freq="MS")
    trend = np.linspace(800, 1200, n)
    seasonal = 80 * np.sin(2 * np.pi * np.arange(n) / 12)
    noise = np.random.normal(0, 30, n)
    df_raw = pd.DataFrame({
        "full_date": dates,
        "avg_points": trend + seasonal + noise,
        "avg_rank": np.linspace(150, 80, n) + np.random.normal(0, 5, n),
        "total_matches": np.random.randint(100, 400, n),
        "active_players": np.random.randint(50, 120, n),
        "avg_win_rate": np.clip(0.45 + 0.005 * np.arange(n) + np.random.normal(0, 0.03, n), 0, 1),
    })
    print(f"[OK] Données synthétiques générées : {len(df_raw)} périodes mensuelles.")


# =========================================================
# 1. PRÉPARATION DE LA SÉRIE TEMPORELLE
# =========================================================
df_ts = df_raw.copy()
df_ts["ds"] = pd.to_datetime(df_ts["full_date"])
df_ts = df_ts.sort_values("ds").reset_index(drop=True)
df_ts = df_ts.dropna(subset=["avg_points"])

ts = df_ts.set_index("ds")["avg_points"].asfreq("MS")
ts = ts.interpolate(method="time")

print(f"\n[INFO] Série temporelle :")
print(f"  Début    : {ts.index.min().date()}")
print(f"  Fin      : {ts.index.max().date()}")
print(f"  N points : {len(ts)}")
print(f"  Moyenne  : {ts.mean():.2f}")
print(f"  Std      : {ts.std():.2f}")


# =========================================================
# 2. VISUALISATION DE LA SÉRIE BRUTE
# =========================================================
fig, axes = plt.subplots(3, 1, figsize=(12, 10))
fig.suptitle("Analyse Temporelle — Points Moyens des Joueurs", fontsize=14)

axes[0].plot(ts.index, ts.values, color="#2196F3", linewidth=2)
axes[0].set_title("Série temporelle brute")
axes[0].set_ylabel("Points moyens")
axes[0].grid(True, alpha=0.3)

rolling_mean = ts.rolling(window=3).mean()
rolling_std = ts.rolling(window=3).std()
axes[1].plot(ts.index, ts.values, alpha=0.5, color="#90CAF9", label="Brut")
axes[1].plot(ts.index, rolling_mean, color="#1565C0", linewidth=2, label="Moyenne mobile (3)")
axes[1].fill_between(
    ts.index,
    rolling_mean - rolling_std,
    rolling_mean + rolling_std,
    alpha=0.2,
    color="#1565C0",
    label="±1 std",
)
axes[1].set_title("Moyenne mobile (fenêtre = 3 périodes)")
axes[1].set_ylabel("Points moyens")
axes[1].legend(fontsize=8)
axes[1].grid(True, alpha=0.3)

axes[2].bar(
    ts.index,
    ts.diff().fillna(0),
    color=["#4CAF50" if v >= 0 else "#F44336" for v in ts.diff().fillna(0)]
)
axes[2].axhline(y=0, color="black", linewidth=0.8)
axes[2].set_title("Variation période-à-période (Δ points)")
axes[2].set_ylabel("Δ Points")
axes[2].grid(True, alpha=0.3)

plt.tight_layout()
plt.savefig("ts_overview.png", dpi=100, bbox_inches="tight")
plt.close()
print("[OK] Graphique sauvegardé : ts_overview.png")


# =========================================================
# 3. TESTS DE STATIONNARITÉ
# =========================================================
print("\n" + "=" * 50)
print("  TESTS DE STATIONNARITÉ")
print("=" * 50)


def adf_test(series, name="Série"):
    """Augmented Dickey-Fuller Test — H0 : non-stationnaire."""
    result = adfuller(series.dropna(), autolag="AIC")
    is_stationary = result[1] <= 0.05
    print(f"\n  [ADF] {name}")
    print(f"    Statistique   : {result[0]:.4f}")
    print(f"    p-value       : {result[1]:.4f}")
    print(f"    Valeurs crit. : {result[4]}")
    print(f"    Stationnaire  : {'OUI ✓' if is_stationary else 'NON ✗'}")
    return is_stationary


def kpss_test(series, name="Série"):
    """KPSS Test — H0 : stationnaire."""
    result = kpss(series.dropna(), regression="c", nlags="auto")
    is_stationary = result[1] > 0.05
    print(f"\n  [KPSS] {name}")
    print(f"    Statistique   : {result[0]:.4f}")
    print(f"    p-value       : {result[1]:.4f}")
    print(f"    Stationnaire  : {'OUI ✓' if is_stationary else 'NON ✗'}")
    return is_stationary


adf_stationary = adf_test(ts, "Points moyens (brut)")
kpss_stationary = kpss_test(ts, "Points moyens (brut)")

ts_diff = ts.diff().dropna()
print("\n  → Après différenciation d'ordre 1 :")
adf_stationary_d1 = adf_test(ts_diff, "Points moyens (Δ1)")
kpss_stationary_d1 = kpss_test(ts_diff, "Points moyens (Δ1)")

d_order = 0 if (adf_stationary and kpss_stationary) else 1
print(f"\n  [INFO] Ordre de différenciation retenu : d={d_order}")


# =========================================================
# 4. DÉCOMPOSITION SAISONNIÈRE
# =========================================================
print("\n[INFO] Décomposition saisonnière...")

if len(ts) >= 24:
    decomp = seasonal_decompose(ts, model="additive", period=12)
    fig, axes = plt.subplots(4, 1, figsize=(12, 10))
    fig.suptitle("Décomposition Saisonnière (Additive, période=12)", fontsize=13)

    titles = ["Observé", "Tendance", "Saisonnalité", "Résidus"]
    colors = ["#1E88E5", "#43A047", "#FB8C00", "#E53935"]
    series_list = [decomp.observed, decomp.trend, decomp.seasonal, decomp.resid]

    for ax, data, title, color in zip(axes, series_list, titles, colors):
        ax.plot(data.index, data.values, linewidth=1.5, color=color)
        ax.set_title(title, fontsize=11)
        ax.grid(True, alpha=0.3)

    plt.tight_layout()
    plt.savefig("ts_decomposition.png", dpi=100, bbox_inches="tight")
    plt.close()
    print("[OK] Décomposition sauvegardée : ts_decomposition.png")
else:
    print(f"[WARN] Trop peu de points ({len(ts)}) pour décomposition saisonnière.")


# =========================================================
# 5. SPLIT TRAIN / TEST (80% / 20%)
# =========================================================
split = int(len(ts) * 0.8)
ts_train = ts.iloc[:split]
ts_test = ts.iloc[split:]
horizon = len(ts_test)

print(f"\n[INFO] Train : {len(ts_train)} pts | Test : {len(ts_test)} pts | Horizon : {horizon}")


# =========================================================
# HELPERS : métriques et visualisation
# =========================================================
def mape(y_true, y_pred):
    """Mean Absolute Percentage Error."""
    y_true, y_pred = np.array(y_true), np.array(y_pred)
    mask = y_true != 0
    return np.mean(np.abs((y_true[mask] - y_pred[mask]) / y_true[mask])) * 100


def evaluate(y_true, y_pred, model_name):
    """Calculer et afficher RMSE, MAE, MAPE."""
    rmse = np.sqrt(mean_squared_error(y_true, y_pred))
    mae = mean_absolute_error(y_true, y_pred)
    m = mape(y_true, y_pred)
    print(f"\n  [{model_name}]")
    print(f"    RMSE : {rmse:.4f}")
    print(f"    MAE  : {mae:.4f}")
    print(f"    MAPE : {m:.2f}%")
    return {"Model": model_name, "RMSE": rmse, "MAE": mae, "MAPE": m}


results_ts = []
forecasts = {}


# =========================================================
# 6. MODÈLE 1 : ARIMA
# =========================================================
print("\n" + "=" * 50)
print("  MODÈLE 1 : ARIMA")
print("=" * 50)

try:
    best_aic = np.inf
    best_order = (1, d_order, 1)

    for p in range(0, 4):
        for q in range(0, 3):
            try:
                m = ARIMA(ts_train, order=(p, d_order, q)).fit()
                if m.aic < best_aic:
                    best_aic = m.aic
                    best_order = (p, d_order, q)
            except Exception:
                pass

    print(f"  Meilleur ordre ARIMA : {best_order} (AIC={best_aic:.2f})")

    arima_model = ARIMA(ts_train, order=best_order).fit()
    arima_fc = arima_model.forecast(steps=horizon)
    arima_fc.index = ts_test.index

    forecasts["ARIMA"] = arima_fc
    results_ts.append(evaluate(ts_test.values, arima_fc.values, "ARIMA"))

    arima_residuals = arima_model.resid
    fig, axes = plt.subplots(1, 2, figsize=(12, 4))
    axes[0].plot(arima_residuals, color="#1E88E5")
    axes[0].axhline(0, linestyle="--", color="red", linewidth=0.8)
    axes[0].set_title("Résidus ARIMA")
    axes[0].set_ylabel("Résidu")
    axes[0].grid(True, alpha=0.3)

    axes[1].hist(arima_residuals, bins=15, edgecolor="white", color="#1E88E5")
    axes[1].set_title("Distribution des résidus ARIMA")
    axes[1].set_xlabel("Résidu")

    plt.tight_layout()
    plt.savefig("ts_arima_residuals.png", dpi=100, bbox_inches="tight")
    plt.close()
    print("[OK] Résidus ARIMA sauvegardés.")

except Exception as e:
    print(f"[ERREUR] ARIMA : {e}")


# =========================================================
# 7. MODÈLE 2 : SARIMA
# =========================================================
print("\n" + "=" * 50)
print("  MODÈLE 2 : SARIMA")
print("=" * 50)

try:
    seasonal_period = 12 if len(ts_train) >= 24 else 6
    sarima_model = SARIMAX(
        ts_train,
        order=(1, d_order, 1),
        seasonal_order=(1, 1, 1, seasonal_period),
        enforce_stationarity=False,
        enforce_invertibility=False,
    ).fit(disp=False)

    sarima_fc = sarima_model.forecast(steps=horizon)
    sarima_fc.index = ts_test.index

    forecasts["SARIMA"] = sarima_fc
    results_ts.append(evaluate(ts_test.values, sarima_fc.values, "SARIMA"))

except Exception as e:
    print(f"[ERREUR] SARIMA : {e}")


# =========================================================
# 8. MODÈLE 3 : Prophet OU ExponentialSmoothing
# =========================================================
print("\n" + "=" * 50)

if PROPHET_AVAILABLE:
    print("  MODÈLE 3 : Prophet")
    print("=" * 50)

    try:
        df_prophet_train = pd.DataFrame({
            "ds": ts_train.index,
            "y": ts_train.values
        })

        prophet_model = Prophet(
            yearly_seasonality=True,
            weekly_seasonality=False,
            daily_seasonality=False,
            changepoint_prior_scale=0.1,
        )
        prophet_model.fit(df_prophet_train)

        future = prophet_model.make_future_dataframe(periods=horizon, freq="MS")
        prophet_forecast = prophet_model.predict(future)

        prophet_fc_vals = prophet_forecast[
            prophet_forecast["ds"].isin(ts_test.index)
        ]["yhat"].values

        prophet_fc = pd.Series(prophet_fc_vals, index=ts_test.index)
        forecasts["Prophet"] = prophet_fc
        results_ts.append(evaluate(ts_test.values, prophet_fc_vals, "Prophet"))

        fig = prophet_model.plot_components(prophet_forecast)
        fig.savefig("ts_prophet_components.png", dpi=100, bbox_inches="tight")
        plt.close()
        print("[OK] Composantes Prophet sauvegardées.")

    except Exception as e:
        print(f"[ERREUR] Prophet : {e}")
        PROPHET_AVAILABLE = False

if not PROPHET_AVAILABLE:
    print("  MODÈLE 3 : Holt-Winters ExponentialSmoothing")
    print("=" * 50)

    try:
        hw_model = ExponentialSmoothing(
            ts_train,
            trend="add",
            seasonal="add" if len(ts_train) >= 24 else None,
            seasonal_periods=12 if len(ts_train) >= 24 else None,
        ).fit(optimized=True)

        hw_fc = hw_model.forecast(horizon)
        hw_fc.index = ts_test.index

        forecasts["HoltWinters"] = hw_fc
        results_ts.append(evaluate(ts_test.values, hw_fc.values, "HoltWinters"))

    except Exception as e:
        print(f"[ERREUR] Holt-Winters : {e}")


# =========================================================
# 9. COMPARAISON GRAPHIQUE DES PRÉDICTIONS
# =========================================================
print("\n[INFO] Génération des graphiques de comparaison...")

if forecasts:
    fig, axes = plt.subplots(len(forecasts), 1, figsize=(13, 4 * len(forecasts)))
    if len(forecasts) == 1:
        axes = [axes]

    colors = {
        "ARIMA": "#1E88E5",
        "SARIMA": "#43A047",
        "Prophet": "#FB8C00",
        "HoltWinters": "#8E24AA",
    }

    for ax, (model_name, fc) in zip(axes, forecasts.items()):
        ax.plot(ts_train.index, ts_train.values, color="gray", linewidth=1.5, label="Train", alpha=0.7)
        ax.plot(ts_test.index, ts_test.values, color="black", linewidth=2, label="Test (réel)", linestyle="--")
        ax.plot(fc.index, fc.values, color=colors.get(model_name, "#E53935"), linewidth=2, label=f"Prévision {model_name}")
        ax.axvline(x=ts_test.index[0], color="red", linestyle=":", linewidth=0.8, alpha=0.5)
        ax.set_title(f"Prévision — {model_name}", fontsize=12)
        ax.set_ylabel("Points moyens")
        ax.legend(fontsize=9)
        ax.grid(True, alpha=0.3)

    plt.tight_layout()
    plt.savefig("ts_forecasts_comparison.png", dpi=100, bbox_inches="tight")
    plt.close()
    print("[OK] Graphique comparatif sauvegardé : ts_forecasts_comparison.png")


# =========================================================
# 10. TABLEAU RÉCAPITULATIF DES MÉTRIQUES
# =========================================================
print("\n" + "=" * 50)
print("  COMPARAISON DES MODÈLES TIME SERIES")
print("=" * 50)

results_df = pd.DataFrame(results_ts)

if not results_df.empty:
    results_df = results_df.sort_values("RMSE")
    print(results_df.to_string(index=False))

    best_model = results_df.iloc[0]["Model"]
    print(f"\n  [WINNER] Meilleur modèle : {best_model}")
    print(f"  RMSE : {results_df.iloc[0]['RMSE']:.4f}")
    print(f"  MAE  : {results_df.iloc[0]['MAE']:.4f}")
    print(f"  MAPE : {results_df.iloc[0]['MAPE']:.2f}%")


# =========================================================
# 11. VISUALISATION MULTI-SÉRIES
# =========================================================
print("\n[INFO] Analyse des autres séries temporelles...")

for col, label in [("avg_rank", "Classement moyen"), ("avg_win_rate", "Taux de victoire moyen")]:
    if col not in df_ts.columns or df_ts[col].isna().all():
        continue

    ts_col = df_ts.set_index("ds")[col].asfreq("MS").interpolate(method="time")
    if len(ts_col.dropna()) < 6:
        continue

    split_c = int(len(ts_col) * 0.8)
    train_c = ts_col.iloc[:split_c]
    test_c = ts_col.iloc[split_c:]

    if len(test_c) == 0:
        continue

    try:
        model_c = ARIMA(train_c, order=(1, 1, 1)).fit()
        fc_c = model_c.forecast(steps=len(test_c))
        fc_c.index = test_c.index

        fig, ax = plt.subplots(figsize=(12, 4))
        ax.plot(train_c.index, train_c.values, color="gray", linewidth=1.5, label="Train", alpha=0.7)
        ax.plot(test_c.index, test_c.values, color="black", linewidth=2, label="Test (réel)", linestyle="--")
        ax.plot(fc_c.index, fc_c.values, color="#E53935", linewidth=2, label="Prévision ARIMA")
        ax.set_title(f"Prévision ARIMA — {label}")
        ax.set_ylabel(label)
        ax.legend()
        ax.grid(True, alpha=0.3)
        plt.tight_layout()

        fname = f"ts_{col}_forecast.png"
        plt.savefig(fname, dpi=100, bbox_inches="tight")
        plt.close()
        print(f"[OK] {label} sauvegardé : {fname}")

        r = evaluate(test_c.values, fc_c.values, f"ARIMA ({label})")
        results_ts.append(r)

    except Exception as e:
        print(f"[WARN] {label} : {e}")


# =========================================================
# 12. EXPORT RÉSULTATS VERS POSTGRESQL
# =========================================================
print("\n[INFO] Export des prévisions vers PostgreSQL...")

try:
    all_forecasts = []
    for model_name, fc in forecasts.items():
        for date, val in fc.items():
            all_forecasts.append({
                "model": model_name,
                "ds": date,
                "predicted_avg_points": round(float(val), 4),
            })

    if all_forecasts:
        df_export = pd.DataFrame(all_forecasts)
        df_export.to_sql(
            "ml_timeseries_forecasts",
            engine,
            schema="public",
            if_exists="replace",
            index=False,
        )
        print("[OK] Table public.ml_timeseries_forecasts créée.")
except Exception as e:
    print(f"[WARN] Export PostgreSQL : {e}")

print("\n[DONE] Time Series Analysis terminée avec succès.")
print("Fichiers générés :")
for f in [
    "ts_overview.png",
    "ts_decomposition.png",
    "ts_arima_residuals.png",
    "ts_forecasts_comparison.png",
]:
    print(f"  → {f}")