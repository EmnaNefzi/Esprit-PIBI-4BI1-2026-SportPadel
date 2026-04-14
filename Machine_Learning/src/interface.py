import os
import sys
import joblib
import pandas as pd
import gradio as gr
import plotly.graph_objects as go
from sqlalchemy import create_engine

sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from config import (
    DATABASE_URL,
    KMEANS_MODEL_PATH,
    KMEANS_SCALER_PATH,
    RF_REG_MODEL_PATH,
    RF_CLF_MODEL_PATH,
    RIDGE_MODEL_PATH,
    LOG_MODEL_PATH,
)

# =========================================================
# CHARGEMENT DES MODÈLES
# =========================================================
print("[INFO] Chargement des modèles...")
try:
    ridge_regressor = joblib.load(RIDGE_MODEL_PATH)
    rf_regressor = joblib.load(RF_REG_MODEL_PATH)

    log_classifier = joblib.load(LOG_MODEL_PATH)
    rf_classifier = joblib.load(RF_CLF_MODEL_PATH)

    kmeans = joblib.load(KMEANS_MODEL_PATH)
    kmeans_scaler = joblib.load(KMEANS_SCALER_PATH)

    print("[OK] Modèles chargés avec succès.")
except FileNotFoundError as e:
    print(f"[ERREUR] Modèle introuvable : {e}")
    print("[HINT] Lance d'abord : python src/main.py")
    sys.exit(1)

# =========================================================
# CHARGEMENT DES VALEURS DEPUIS LA BDD
# =========================================================
print("[INFO] Chargement des valeurs depuis la base de données...")
try:
    engine = create_engine(DATABASE_URL)

    query_players = """
    SELECT DISTINCT
        COALESCE(dp.player_name, 'Unknown') AS player_name
    FROM dw.fact_player_stats fps
    LEFT JOIN dw.dim_player dp
        ON fps.player_key = dp.player_key
    WHERE dp.player_name IS NOT NULL
    ORDER BY player_name
    """

    query_meta = """
    SELECT DISTINCT
        COALESCE(dp.country, 'Unknown') AS country,
        COALESCE(dp.gender, 'Unknown') AS gender
    FROM dw.fact_player_stats fps
    LEFT JOIN dw.dim_player dp
        ON fps.player_key = dp.player_key
    """

    df_players = pd.read_sql(query_players, engine)
    df_meta = pd.read_sql(query_meta, engine)

    player_names = sorted([p for p in df_players["player_name"].dropna().unique() if p != "Unknown"])
    if "Unknown" not in player_names:
        player_names.append("Unknown")

    countries = sorted([c for c in df_meta["country"].dropna().unique() if c != "Unknown"])
    if "Unknown" not in countries:
        countries.append("Unknown")

    genders = sorted([g for g in df_meta["gender"].dropna().unique() if g != "Unknown"])
    if "Unknown" not in genders:
        genders.append("Unknown")

    print(f"[OK] Joueurs chargés : {len(player_names)}")
    print(f"[OK] Pays chargés    : {len(countries)}")
    print(f"[OK] Genres chargés  : {len(genders)}")

except Exception as e:
    print(f"[WARN] Impossible de charger depuis la BDD : {e}")
    player_names = ["Test Player", "Unknown"]
    countries = ["ARG", "ESP", "FRA", "BRA", "Unknown"]
    genders = ["m", "w", "Unknown"]

# =========================================================
# FEATURES
# =========================================================
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
def estimate_tournaments_played(matches_played: float) -> float:
    matches_played = max(float(matches_played), 0.0)
    if matches_played == 0:
        return 0.0
    estimated = round(matches_played / 5.0)
    return max(1.0, float(estimated))


def create_gauge_chart(value, max_value, title):
    """Barre de progression horizontale avec zones colorées"""
    pct = min(value / max_value, 1.0)

    if pct < 0.33:
        color, niveau = "#e17055", "Faible"
    elif pct < 0.66:
        color, niveau = "#fdcb6e", "Moyen"
    else:
        color, niveau = "#00b894", "Élevé"

    fig = go.Figure()

    # Fond gris
    fig.add_trace(go.Bar(
        x=[max_value], y=["Points"],
        orientation="h",
        marker_color="#dfe6e9",
        showlegend=False,
        hoverinfo="skip",
    ))
    # Valeur réelle
    fig.add_trace(go.Bar(
        x=[value], y=["Points"],
        orientation="h",
        marker_color=color,
        showlegend=False,
        text=f"  {value:.0f} pts — Niveau : {niveau}",
        textposition="inside",
        insidetextanchor="start",
        textfont=dict(size=16, color="white"),
    ))

    fig.update_layout(
        title=dict(text=title, font=dict(size=16, color="#2d3436")),
        barmode="overlay",
        height=120,
        margin=dict(l=10, r=10, t=40, b=10),
        paper_bgcolor="white",
        plot_bgcolor="white",
        xaxis=dict(range=[0, max_value], showticklabels=True, tickfont=dict(size=12)),
        yaxis=dict(showticklabels=False),
    )
    return fig


def create_performance_radar(win_rate, activity, matches_played=0, matches_won=0):
    """Bar chart horizontal des métriques clés — plus lisible qu'un radar à 2 axes"""
    metrics = ["Taux de victoire", "Niveau d'activité", "Matchs gagnés (%)"]
    values  = [
        round(win_rate * 100, 1),
        round(min(activity * 10, 100), 1),
        round((matches_won / matches_played * 100) if matches_played > 0 else 0, 1),
    ]
    colors = ["#0984e3", "#6c5ce7", "#00b894"]

    fig = go.Figure(go.Bar(
        x=values,
        y=metrics,
        orientation="h",
        marker_color=colors,
        text=[f"{v:.1f}%" for v in values],
        textposition="outside",
        textfont=dict(size=13),
    ))
    fig.update_layout(
        title=dict(text="📊 Métriques du joueur", font=dict(size=16, color="#2d3436")),
        height=220,
        margin=dict(l=10, r=60, t=45, b=10),
        paper_bgcolor="white",
        plot_bgcolor="#f8f9fa",
        xaxis=dict(range=[0, 110], showgrid=True, gridcolor="#dfe6e9"),
        yaxis=dict(tickfont=dict(size=13)),
    )
    return fig


def build_base_features(matches_played, matches_won, avg_points, avg_ranking, avg_equipment_price, country, gender):
    matches_played = float(matches_played)
    matches_won = float(matches_won)
    avg_points = float(avg_points)
    avg_ranking = float(avg_ranking)
    avg_equipment_price = float(avg_equipment_price)

    tournaments_played = estimate_tournaments_played(matches_played)
    win_rate = matches_won / matches_played if matches_played > 0 else 0.0
    activity_level = matches_played / (tournaments_played + 1)
    points_per_match = avg_points / matches_played if matches_played > 0 else 0.0

    return {
        "matches_played": matches_played,
        "matches_won": matches_won,
        "tournaments_played": tournaments_played,
        "avg_points": avg_points,
        "avg_ranking": avg_ranking,
        "avg_equipment_price": avg_equipment_price,
        "country": str(country),
        "gender": str(gender),
        "win_rate": win_rate,
        "activity_level": activity_level,
        "points_per_match": points_per_match,
    }


# =========================================================
# PREDICTIONS PRINCIPALES
# =========================================================
def predict_points(player_name, matches_played, matches_won, avg_equipment_price, country, gender):
    try:
        avg_points_seed = 1000.0
        avg_ranking_seed = 100.0

        data = build_base_features(
            matches_played=matches_played,
            matches_won=matches_won,
            avg_points=avg_points_seed,
            avg_ranking=avg_ranking_seed,
            avg_equipment_price=avg_equipment_price,
            country=country,
            gender=gender,
        )

        df_input = pd.DataFrame([{col: data[col] for col in REGRESSION_FEATURES}])
        predicted_points = rf_regressor.predict(df_input)[0]
        gauge = create_gauge_chart(predicted_points, 4500, "Points moyens prédits")

        result_text = f"""
<div style="background: linear-gradient(135deg, #00b894 0%, #00cec9 100%); padding: 2rem; border-radius: 10px; color: white;">
    <h2 style="margin-top: 0;">🎯 Résultat de la Prédiction</h2>
    <h3 style="margin: 0.5rem 0;">Joueur : {player_name}</h3>
    <h1 style="font-size: 3rem; margin: 1rem 0;">{predicted_points:.0f} POINTS</h1>
</div>
"""
        return result_text, gauge
    except Exception as e:
        return f"❌ Erreur : {str(e)}", None


def predict_performance(player_name, matches_played, matches_won, avg_equipment_price, country, gender):
    try:
        avg_points_dummy = 0.0
        avg_ranking_dummy = 9999.0

        data = build_base_features(
            matches_played=matches_played,
            matches_won=matches_won,
            avg_points=avg_points_dummy,
            avg_ranking=avg_ranking_dummy,
            avg_equipment_price=avg_equipment_price,
            country=country,
            gender=gender,
        )

        df_input = pd.DataFrame([{col: data[col] for col in CLASSIFICATION_FEATURES}])
        prediction = int(rf_classifier.predict(df_input)[0])
        probability = float(rf_classifier.predict_proba(df_input)[0][1])

        radar = create_performance_radar(data["win_rate"], data["activity_level"], matches_played, matches_won)

        label = "🏆 Bon joueur" if prediction == 1 else "📊 Joueur standard"
        color = "#00b894" if prediction == 1 else "#0984e3"

        result_text = f"""
<div style="background: linear-gradient(135deg, {color} 0%, #2d3436 100%); padding: 2rem; border-radius: 10px; color: white;">
    <h2 style="margin-top: 0;">{label}</h2>
    <h3 style="margin: 0.5rem 0;">Joueur : {player_name}</h3>
    <h1 style="font-size: 2.5rem; margin: 1rem 0;">{probability:.1%}</h1>
    <p style="font-size: 1.2rem;">Probabilité d'être un bon joueur</p>
    <p>Taux de victoire : <strong>{data["win_rate"]:.1%}</strong></p>
    <p>Tournois estimés : <strong>{data["tournaments_played"]:.0f}</strong></p>
</div>
"""
        return result_text, radar

    except Exception as e:
        return f"❌ Erreur : {str(e)}", None


def predict_cluster(player_name, avg_ranking, avg_points, matches_played, avg_equipment_price):
    try:
        matches_played = float(matches_played)
        avg_points = float(avg_points)
        avg_ranking = float(avg_ranking)
        avg_equipment_price = float(avg_equipment_price)

        tournaments_played = estimate_tournaments_played(matches_played)
        points_per_match = avg_points / matches_played if matches_played > 0 else 0.0

        cluster_data = {
            "avg_ranking": avg_ranking,
            "avg_points": avg_points,
            "matches_played": matches_played,
            "tournaments_played": tournaments_played,
            "points_per_match": points_per_match,
            "avg_equipment_price": avg_equipment_price,
        }

        df_input = pd.DataFrame([{col: cluster_data[col] for col in CLUSTER_FEATURES}])
        X_scaled = kmeans_scaler.transform(df_input)
        cluster = int(kmeans.predict(X_scaled)[0])

        fig = go.Figure()
        fig.add_trace(go.Bar(
            x=["Ranking moyen", "Points moyens", "Matchs joués", "Prix équipement"],
            y=[avg_ranking, avg_points, matches_played, avg_equipment_price],
            text=[f"{avg_ranking:.0f}", f"{avg_points:.0f}", f"{matches_played:.0f}", f"{avg_equipment_price:.0f}"],
            textposition="auto",
        ))
        fig.update_layout(title=f"Profil du Joueur - {player_name}", height=320, showlegend=False)

        result_text = f"""
<div style="background: linear-gradient(135deg, #6c5ce7 0%, #0984e3 100%); padding: 2rem; border-radius: 10px; color: white;">
    <h2 style="margin-top: 0;">🧠 Profil {cluster}</h2>
    <h3 style="margin: 0.5rem 0;">Joueur : {player_name}</h3>
    <p>Tournois estimés : <strong>{tournaments_played:.0f}</strong></p>
    <p>Points par match : <strong>{points_per_match:.2f}</strong></p>
</div>
"""
        return result_text, fig
    except Exception as e:
        return f"❌ Erreur : {str(e)}", None


def predict_all(player_name, matches_played, matches_won, avg_ranking, avg_points, avg_equipment_price, country, gender):
    try:
        data = build_base_features(
            matches_played=matches_played,
            matches_won=matches_won,
            avg_points=avg_points,
            avg_ranking=avg_ranking,
            avg_equipment_price=avg_equipment_price,
            country=country,
            gender=gender,
        )

        reg_input = pd.DataFrame([{col: data[col] for col in REGRESSION_FEATURES}])
        clf_input = pd.DataFrame([{col: data[col] for col in CLASSIFICATION_FEATURES}])
        cluster_input = pd.DataFrame([{col: data[col] for col in CLUSTER_FEATURES}])

        predicted_points = rf_regressor.predict(reg_input)[0]
        prediction = int(rf_classifier.predict(clf_input)[0])
        probability = float(rf_classifier.predict_proba(clf_input)[0][1])
        X_scaled = kmeans_scaler.transform(cluster_input)
        cluster = int(kmeans.predict(X_scaled)[0])

        perf_label = "Bon joueur 🌟" if prediction == 1 else "Joueur standard 📊"

        dashboard_text = f"""
<div style="background: linear-gradient(135deg, #00b894 0%, #00cec9 50%, #0984e3 100%); padding: 2.5rem; border-radius: 15px; color: white; margin-bottom: 2rem;">
    <h1 style="margin-top: 0; font-size: 2.5rem;">🎾 Analyse Complète</h1>
    <h2 style="margin: 0.5rem 0; font-size: 2rem;">{player_name}</h2>
</div>

<div style="display: grid; grid-template-columns: repeat(3, 1fr); gap: 1rem; margin: 2rem 0;">
    <div style="background: #00b894; padding: 1.5rem; border-radius: 10px; color: white; text-align: center;">
        <h3 style="margin: 0;">🎯 Points Prédits</h3>
        <p style="font-size: 2.5rem; font-weight: bold; margin: 0.5rem 0;">{predicted_points:.0f}</p>
    </div>
    <div style="background: #0984e3; padding: 1.5rem; border-radius: 10px; color: white; text-align: center;">
        <h3 style="margin: 0;">🏆 Classification</h3>
        <p style="font-size: 1.5rem; font-weight: bold; margin: 0.5rem 0;">{perf_label}</p>
        <p style="font-size: 1.2rem; margin: 0;">{probability:.1%}</p>
    </div>
    <div style="background: #6c5ce7; padding: 1.5rem; border-radius: 10px; color: white; text-align: center;">
        <h3 style="margin: 0;">🧠 Profil</h3>
        <p style="font-size: 1.5rem; font-weight: bold; margin: 0.5rem 0;">Profil {cluster}</p>
    </div>
</div>
"""
        gauge = create_gauge_chart(predicted_points, 4500, "Points moyens prédits")
        radar = create_performance_radar(data["win_rate"], data["activity_level"], matches_played, matches_won)
        return dashboard_text, gauge, radar
    except Exception as e:
        return f"❌ Erreur : {str(e)}", None, None


# =========================================================
# COMPARAISON DES MODÈLES
# =========================================================
def compare_regression_models(player_name, matches_played, matches_won, avg_equipment_price, country, gender):
    try:
        avg_points_seed = 1000.0
        avg_ranking_seed = 100.0

        data = build_base_features(
            matches_played=matches_played,
            matches_won=matches_won,
            avg_points=avg_points_seed,
            avg_ranking=avg_ranking_seed,
            avg_equipment_price=avg_equipment_price,
            country=country,
            gender=gender,
        )

        df_input = pd.DataFrame([{col: data[col] for col in REGRESSION_FEATURES}])

        ridge_pred = float(ridge_regressor.predict(df_input)[0])
        rf_pred = float(rf_regressor.predict(df_input)[0])

        fig = go.Figure()
        fig.add_trace(go.Bar(
            x=["Ridge", "Random Forest"],
            y=[ridge_pred, rf_pred],
            text=[f"{ridge_pred:.0f}", f"{rf_pred:.0f}"],
            textposition="auto",
        ))
        fig.update_layout(title=f"Comparaison Régression - {player_name}", height=350)

        html = f"""
<div style="background: white; padding: 1.5rem; border-radius: 10px;">
    <h3>📊 Comparaison des modèles de régression</h3>
    <p><strong>Ridge :</strong> {ridge_pred:.2f}</p>
    <p><strong>Random Forest Regressor :</strong> {rf_pred:.2f}</p>
    <p><strong>Modèle retenu :</strong> Random Forest Regressor</p>
</div>
"""
        return html, fig
    except Exception as e:
        return f"❌ Erreur : {str(e)}", None


def compare_classification_models(player_name, matches_played, matches_won, avg_equipment_price, country, gender):
    try:
        avg_points_seed = 1000.0
        avg_ranking_seed = 100.0

        data = build_base_features(
            matches_played=matches_played,
            matches_won=matches_won,
            avg_points=avg_points_seed,
            avg_ranking=avg_ranking_seed,
            avg_equipment_price=avg_equipment_price,
            country=country,
            gender=gender,
        )

        df_input = pd.DataFrame([{col: data[col] for col in CLASSIFICATION_FEATURES}])

        log_proba = float(log_classifier.predict_proba(df_input)[0][1])
        rf_proba = float(rf_classifier.predict_proba(df_input)[0][1])

        fig = go.Figure()
        fig.add_trace(go.Bar(
            x=["Logistic Regression", "Random Forest"],
            y=[log_proba, rf_proba],
            text=[f"{log_proba:.2%}", f"{rf_proba:.2%}"],
            textposition="auto",
        ))
        fig.update_layout(title=f"Comparaison Classification - {player_name}", height=350)

        html = f"""
<div style="background: white; padding: 1.5rem; border-radius: 10px;">
    <h3>🏆 Comparaison des modèles de classification</h3>
    <p><strong>Logistic Regression :</strong> {log_proba:.2%}</p>
    <p><strong>Random Forest Classifier :</strong> {rf_proba:.2%}</p>
    <p><strong>Modèle retenu :</strong> Random Forest Classifier</p>
</div>
"""
        return html, fig
    except Exception as e:
        return f"❌ Erreur : {str(e)}", None


# =========================================================
# INTERFACE
# =========================================================
with gr.Blocks(title="Padel ML - Analyse Prédictive", theme=gr.themes.Soft()) as demo:
    gr.Markdown("""
<div style="text-align: center; background: linear-gradient(135deg, #00b894 0%, #00cec9 50%, #0984e3 100%); padding: 3rem 2rem; border-radius: 15px; color: white; margin-bottom: 2rem;">
    <h1 style="font-size: 3.5rem; font-weight: 800; margin-bottom: 0.5rem;">🎾 PADEL ML</h1>
    <p style="font-size: 1.3rem;">🚀 Analyse Prédictive et Performance pour le Padel</p>
</div>
""")

    with gr.Tab("🚀 Dashboard Complet"):
        with gr.Row():
            with gr.Column():
                player_name = gr.Dropdown(choices=player_names, label="Nom du joueur", value=player_names[0] if player_names else "Unknown")
                matches_played = gr.Number(label="Matchs joués", value=50)
                matches_won = gr.Number(label="Matchs gagnés", value=30)
            with gr.Column():
                avg_ranking = gr.Number(label="Ranking moyen", value=100)
                avg_points = gr.Number(label="Points moyens actuels", value=1500)
                avg_equipment_price = gr.Number(label="Prix moyen équipement (€)", value=250)
            with gr.Column():
                country = gr.Dropdown(choices=countries, label="Pays", value=countries[0] if countries else "Unknown")
                gender = gr.Dropdown(choices=genders, label="Genre", value=genders[0] if genders else "Unknown")

        btn_all = gr.Button("🚀 Prédire Tout", variant="primary")
        html_all = gr.HTML()
        plot_gauge = gr.Plot(label="Points prédits")
        plot_radar = gr.Plot(label="Radar performance")

        btn_all.click(
            fn=predict_all,
            inputs=[player_name, matches_played, matches_won, avg_ranking, avg_points, avg_equipment_price, country, gender],
            outputs=[html_all, plot_gauge, plot_radar]
        )

    with gr.Tab("🎯 Prédiction Points"):
        with gr.Row():
            reg_player_name = gr.Dropdown(choices=player_names, label="Nom du joueur", value=player_names[0] if player_names else "Unknown")
            reg_matches_played = gr.Number(label="Matchs joués", value=50)
            reg_matches_won = gr.Number(label="Matchs gagnés", value=30)
            reg_price = gr.Number(label="Prix moyen équipement (€)", value=250)
            reg_country = gr.Dropdown(choices=countries, label="Pays", value=countries[0] if countries else "Unknown")
            reg_gender = gr.Dropdown(choices=genders, label="Genre", value=genders[0] if genders else "Unknown")

        btn_reg = gr.Button("🎯 Prédire les points", variant="primary")
        html_reg = gr.HTML()
        plot_reg = gr.Plot()

        btn_reg.click(
            fn=predict_points,
            inputs=[reg_player_name, reg_matches_played, reg_matches_won, reg_price, reg_country, reg_gender],
            outputs=[html_reg, plot_reg]
        )

    with gr.Tab("🏆 Classification"):
        with gr.Row():
            clf_player_name = gr.Dropdown(choices=player_names, label="Nom du joueur", value=player_names[0] if player_names else "Unknown")
            clf_matches_played = gr.Number(label="Matchs joués", value=50)
            clf_matches_won = gr.Number(label="Matchs gagnés", value=30)
            clf_price = gr.Number(label="Prix moyen équipement (€)", value=250)
            clf_country = gr.Dropdown(choices=countries, label="Pays", value=countries[0] if countries else "Unknown")
            clf_gender = gr.Dropdown(choices=genders, label="Genre", value=genders[0] if genders else "Unknown")

        btn_clf = gr.Button("🏆 Classifier", variant="primary")
        html_clf = gr.HTML()
        plot_clf = gr.Plot()

        btn_clf.click(
            fn=predict_performance,
            inputs=[clf_player_name, clf_matches_played, clf_matches_won, clf_price, clf_country, clf_gender],
            outputs=[html_clf, plot_clf]
        )

    with gr.Tab("🧠 Clustering"):
        with gr.Row():
            cl_player_name = gr.Dropdown(choices=player_names, label="Nom du joueur", value=player_names[0] if player_names else "Unknown")
            cl_ranking = gr.Number(label="Ranking moyen", value=50)
            cl_points = gr.Number(label="Points moyens", value=1500)
            cl_matches = gr.Number(label="Matchs joués (total)", value=80)
            cl_price = gr.Number(label="Prix moyen équipement (€)", value=250)

        btn_cluster = gr.Button("🧠 Identifier le cluster", variant="primary")
        html_cluster = gr.HTML()
        plot_cluster = gr.Plot(label="Graphique")

        btn_cluster.click(
            fn=predict_cluster,
            inputs=[cl_player_name, cl_ranking, cl_points, cl_matches, cl_price],
            outputs=[html_cluster, plot_cluster]
        )

    with gr.Tab("📊 Comparaison des modèles"):
        gr.Markdown("### Régression et Classification : comparaison des 2 modèles minimum")

        with gr.Row():
            with gr.Column():
                cmp_player_name = gr.Dropdown(choices=player_names, label="Nom du joueur", value=player_names[0] if player_names else "Unknown")
                cmp_matches_played = gr.Number(label="Matchs joués", value=50)
                cmp_matches_won = gr.Number(label="Matchs gagnés", value=30)
            with gr.Column():
                cmp_price = gr.Number(label="Prix moyen équipement (€)", value=250)
                cmp_country = gr.Dropdown(choices=countries, label="Pays", value=countries[0] if countries else "Unknown")
                cmp_gender = gr.Dropdown(choices=genders, label="Genre", value=genders[0] if genders else "Unknown")

        with gr.Row():
            btn_cmp_reg = gr.Button("Comparer Régression")
            btn_cmp_clf = gr.Button("Comparer Classification")

        with gr.Row():
            with gr.Column():
                cmp_reg_html = gr.HTML()
                cmp_reg_plot = gr.Plot()
            with gr.Column():
                cmp_clf_html = gr.HTML()
                cmp_clf_plot = gr.Plot()

        btn_cmp_reg.click(
            fn=compare_regression_models,
            inputs=[cmp_player_name, cmp_matches_played, cmp_matches_won, cmp_price, cmp_country, cmp_gender],
            outputs=[cmp_reg_html, cmp_reg_plot]
        )

        btn_cmp_clf.click(
            fn=compare_classification_models,
            inputs=[cmp_player_name, cmp_matches_played, cmp_matches_won, cmp_price, cmp_country, cmp_gender],
            outputs=[cmp_clf_html, cmp_clf_plot]
        )

    gr.Markdown("""
<div style="text-align: center; padding: 2rem; background: linear-gradient(135deg, #dfe6e9 0%, #b2bec3 100%); border-radius: 10px; margin-top: 2rem;">
    <h3 style="color: #2d3436;">💡 Astuce</h3>
    <p style="color: #2d3436;">Cette interface montre la prédiction finale et la comparaison des deux modèles minimum demandés.</p>
</div>
""")


if __name__ == "__main__":
    print("\n" + "=" * 60)
    print("🎾 PADEL ML - Interface d'Analyse Prédictive")
    print("=" * 60)
    print("[INFO] Ouvrez votre navigateur sur : http://localhost:7860")
    print("=" * 60 + "\n")

    demo.launch(
        server_name="0.0.0.0",
        server_port=7860,
        share=True,
    )