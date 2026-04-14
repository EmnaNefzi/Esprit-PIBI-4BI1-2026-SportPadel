import os
import sys
import joblib
import pandas as pd

from flask import Flask, request, jsonify
from flask_cors import CORS

sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from config import (
    FLASK_PORT,
    SECRET_KEY,
    RF_REG_MODEL_PATH,
    RF_CLF_MODEL_PATH,
    KMEANS_MODEL_PATH,
    KMEANS_SCALER_PATH,
)

app = Flask(__name__)
app.config["SECRET_KEY"] = SECRET_KEY
CORS(app)

print("[INFO] Chargement des modèles...")

try:
    rf_regressor = joblib.load(RF_REG_MODEL_PATH)
    rf_classifier = joblib.load(RF_CLF_MODEL_PATH)
    kmeans = joblib.load(KMEANS_MODEL_PATH)
    kmeans_scaler = joblib.load(KMEANS_SCALER_PATH)
    print("[OK] Modèles chargés avec succès.")
except FileNotFoundError as e:
    print(f"[ERREUR] Modèle introuvable : {e}")
    print("[HINT] Lance d'abord : python src/main.py")
    rf_regressor = None
    rf_classifier = None
    kmeans = None
    kmeans_scaler = None

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


def validate_models():
    if any(m is None for m in [rf_regressor, rf_classifier, kmeans, kmeans_scaler]):
        return False, {"error": "Modèles non chargés. Lance d'abord python src/main.py"}
    return True, None


def safe_float(value, default=0.0):
    try:
        if value is None or value == "":
            return default
        return float(value)
    except Exception:
        return default


def safe_str(value, default="Unknown"):
    if value is None or value == "":
        return default
    return str(value)


def estimate_tournaments_played(matches_played: float) -> float:
    matches_played = max(float(matches_played), 0.0)
    if matches_played == 0:
        return 0.0
    estimated = round(matches_played / 5.0)
    return max(1.0, float(estimated))


def build_base_features(data: dict) -> dict:
    matches_played = safe_float(data.get("matches_played", 0))
    matches_won = safe_float(data.get("matches_won", 0))

    raw_tournaments = data.get("tournaments_played", None)
    if raw_tournaments is None or raw_tournaments == "":
        tournaments_played = estimate_tournaments_played(matches_played)
    else:
        tournaments_played = safe_float(raw_tournaments, 0)

    avg_equipment_price = safe_float(data.get("avg_equipment_price", data.get("price", 0)))
    avg_points = safe_float(data.get("avg_points", data.get("points", 0)))
    avg_ranking = safe_float(data.get("avg_ranking", data.get("ranking", 9999)))

    country = safe_str(data.get("country", "Unknown"))
    gender = safe_str(data.get("gender", "Unknown"))

    win_rate = matches_won / matches_played if matches_played > 0 else 0.0
    activity_level = matches_played / (tournaments_played + 1)
    points_per_match = avg_points / matches_played if matches_played > 0 else 0.0

    return {
        "matches_played": matches_played,
        "matches_won": matches_won,
        "tournaments_played": tournaments_played,
        "win_rate": win_rate,
        "activity_level": activity_level,
        "avg_equipment_price": avg_equipment_price,
        "gender": gender,
        "country": country,
        "avg_points": avg_points,
        "avg_ranking": avg_ranking,
        "points_per_match": points_per_match,
    }


def build_regression_input(data: dict) -> pd.DataFrame:
    features = build_base_features(data)
    return pd.DataFrame([{col: features[col] for col in REGRESSION_FEATURES}])


def build_classification_input(data: dict) -> pd.DataFrame:
    features = build_base_features(data)
    return pd.DataFrame([{col: features[col] for col in CLASSIFICATION_FEATURES}])


def build_cluster_input(data: dict) -> pd.DataFrame:
    features = build_base_features(data)
    return pd.DataFrame([{col: features[col] for col in CLUSTER_FEATURES}])


def cluster_label(cluster_id: int) -> str:
    labels = {
        0: "Profil 0",
        1: "Profil 1",
        2: "Profil 2",
    }
    return labels.get(cluster_id, f"Cluster {cluster_id}")


@app.route("/", methods=["GET"])
def home():
    return jsonify({
        "message": "Padel ML API is running",
        "routes": [
            "/health",
            "/predict/points",
            "/predict/performance",
            "/predict/cluster",
            "/predict/all",
        ],
    })


@app.route("/health", methods=["GET"])
def health():
    models_ok = all(m is not None for m in [rf_regressor, rf_classifier, kmeans, kmeans_scaler])
    return jsonify({
        "status": "ok" if models_ok else "degraded",
        "models_loaded": models_ok,
    }), 200 if models_ok else 503


@app.route("/predict/points", methods=["POST"])
def predict_points():
    ok, err = validate_models()
    if not ok:
        return jsonify(err), 503

    data = request.get_json(force=True)
    if not data:
        return jsonify({"error": "Body JSON requis"}), 400

    try:
        df_input = build_regression_input(data)
        predicted_points = rf_regressor.predict(df_input)[0]
        return jsonify({
            "predicted_avg_points": round(float(predicted_points), 2),
            "model": "RandomForestRegressor"
        })
    except Exception as e:
        return jsonify({"error": str(e)}), 500


@app.route("/predict/performance", methods=["POST"])
def predict_performance():
    ok, err = validate_models()
    if not ok:
        return jsonify(err), 503

    data = request.get_json(force=True)
    if not data:
        return jsonify({"error": "Body JSON requis"}), 400

    try:
        df_input = build_classification_input(data)
        prediction = int(rf_classifier.predict(df_input)[0])
        probability = float(rf_classifier.predict_proba(df_input)[0][1])
        return jsonify({
            "good_player": prediction,
            "label": "Bon joueur" if prediction == 1 else "Joueur standard",
            "probability": round(probability, 4),
            "model": "RandomForestClassifier"
        })
    except Exception as e:
        return jsonify({"error": str(e)}), 500


@app.route("/predict/cluster", methods=["POST"])
def predict_cluster():
    ok, err = validate_models()
    if not ok:
        return jsonify(err), 503

    data = request.get_json(force=True)
    if not data:
        return jsonify({"error": "Body JSON requis"}), 400

    try:
        cluster_input = build_cluster_input(data)
        cluster_scaled = kmeans_scaler.transform(cluster_input)
        cluster = int(kmeans.predict(cluster_scaled)[0])
        return jsonify({
            "cluster": cluster,
            "cluster_label": cluster_label(cluster),
            "model": "KMeans"
        })
    except Exception as e:
        return jsonify({"error": str(e)}), 500


@app.route("/predict/all", methods=["POST"])
def predict_all():
    ok, err = validate_models()
    if not ok:
        return jsonify(err), 503

    data = request.get_json(force=True)
    if not data:
        return jsonify({"error": "Body JSON requis"}), 400

    try:
        reg_input = build_regression_input(data)
        clf_input = build_classification_input(data)
        cluster_input = build_cluster_input(data)

        predicted_points = round(float(rf_regressor.predict(reg_input)[0]), 2)
        perf_pred = int(rf_classifier.predict(clf_input)[0])
        perf_proba = round(float(rf_classifier.predict_proba(clf_input)[0][1]), 4)

        cluster_scaled = kmeans_scaler.transform(cluster_input)
        cluster = int(kmeans.predict(cluster_scaled)[0])

        return jsonify({
            "regression": {
                "predicted_avg_points": predicted_points,
                "model": "RandomForestRegressor"
            },
            "classification": {
                "good_player": perf_pred,
                "label": "Bon joueur" if perf_pred == 1 else "Joueur standard",
                "probability": perf_proba,
                "model": "RandomForestClassifier"
            },
            "clustering": {
                "cluster": cluster,
                "cluster_label": cluster_label(cluster),
                "model": "KMeans"
            }
        })
    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == "__main__":
    print(f"[INFO] API démarrée sur http://0.0.0.0:{FLASK_PORT}")
    app.run(host="0.0.0.0", port=FLASK_PORT, debug=False)
