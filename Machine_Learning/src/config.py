import os
from dotenv import load_dotenv
from sqlalchemy.engine import URL

load_dotenv()

# =========================================================
# BASE DE DONNÉES
# =========================================================
DB_USER = os.getenv("DB_USER", "postgres")
DB_PASSWORD = os.getenv("DB_PASSWORD", "projet_pi")
DB_HOST = os.getenv("DB_HOST", "localhost")
DB_PORT = int(os.getenv("DB_PORT", 5432))
DB_NAME = os.getenv("DB_NAME", "padel_DWH")

# Version robuste pour éviter les problèmes de caractères spéciaux
DATABASE_URL = URL.create(
    "postgresql+psycopg2",
    username=DB_USER,
    password=DB_PASSWORD,
    host=DB_HOST,
    port=DB_PORT,
    database=DB_NAME,
)

# =========================================================
# CHEMINS DES MODÈLES
# =========================================================
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
MODELS_DIR = os.getenv("MODELS_DIR", os.path.join(BASE_DIR, "models"))

KMEANS_MODEL_PATH  = os.path.join(MODELS_DIR, "kmeans_model.pkl")
KMEANS_SCALER_PATH = os.path.join(MODELS_DIR, "kmeans_scaler.pkl")
RF_REG_MODEL_PATH  = os.path.join(MODELS_DIR, "best_rf_regressor.pkl")
RF_CLF_MODEL_PATH  = os.path.join(MODELS_DIR, "best_rf_classifier.pkl")
RIDGE_MODEL_PATH   = os.path.join(MODELS_DIR, "best_ridge_regressor.pkl")
LOG_MODEL_PATH     = os.path.join(MODELS_DIR, "best_log_classifier.pkl")

# =========================================================
# API FLASK
# =========================================================
FLASK_PORT = int(os.getenv("FLASK_PORT", 5000))
FLASK_ENV = os.getenv("FLASK_ENV", "development")
SECRET_KEY = os.getenv("SECRET_KEY", "dev-secret-key")