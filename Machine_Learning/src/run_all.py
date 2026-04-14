"""
run_all.py - Lanceur principal du projet ML Padel
==================================================
Exécute dans l'ordre :
  1. main.py        → Clustering + Régression + Classification (sections A, C, D, E)
  2. time_series.py → Time Series Forecasting (section F)

Usage : python src/run_all.py
"""

import subprocess
import sys
import os

SCRIPTS = [
    ("src/main.py",        "A, C, D, E — Clustering + Régression + Classification"),
    ("src/time_series.py", "F           — Time Series / Forecasting"),
]

def run_script(path, description):
    print("\n" + "=" * 65)
    print(f"  LANCEMENT : {description}")
    print(f"  Fichier   : {path}")
    print("=" * 65)
    result = subprocess.run(
        [sys.executable, path],
        capture_output=False,
        text=True,
    )
    if result.returncode != 0:
        print(f"\n[ERREUR] {path} a échoué (code {result.returncode})")
        return False
    print(f"\n[OK] {path} terminé avec succès.")
    return True


if __name__ == "__main__":
    os.chdir(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
    print("\n" + "★" * 65)
    print("  PADEL ANALYTICS — Pipeline ML complet (Sections A–F)")
    print("★" * 65)

    success = True
    for script_path, desc in SCRIPTS:
        ok = run_script(script_path, desc)
        if not ok:
            success = False
            print(f"[WARN] Poursuite malgré l'erreur dans {script_path}...")

    print("\n" + "★" * 65)
    print("  RÉSUMÉ FINAL")
    print("★" * 65)
    print(f"  Statut global : {'✓ SUCCÈS' if success else '⚠ PARTIEL (voir erreurs ci-dessus)'}")
    print("\n  Fichiers générés :")
    outputs = [
        "models/kmeans_model.pkl",
        "models/best_rf_regressor.pkl",
        "models/best_rf_classifier.pkl",
        "ts_overview.png",
        "ts_decomposition.png",
        "ts_arima_residuals.png",
        "ts_forecasts_comparison.png",
    ]
    for f in outputs:
        status = "✓" if os.path.exists(f) else "✗"
        print(f"    {status}  {f}")
    print()
