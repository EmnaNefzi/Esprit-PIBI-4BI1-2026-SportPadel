import pdfplumber
import pandas as pd
import re
from datetime import date

PDF_PATH = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/Tournament-apr.pdf"
OUTPUT_CSV = "C:/Users/ASUS/Downloads/Sports/Sports/script_tournois/tournament_apr.csv"

TOURNAMENT_NAME = "OOREDOO QATAR MAJOR"
TOURNAMENT_PLACE = "Doha, Qatar"
TOURNAMENT_DATE = date(2025, 4, 19)

ROWS = []

ROUND_KEYWORDS = {
    "FINAL": "Final",
    "SEMIFINAL": "Semifinal",
    "SEMI-FINAL": "Semifinal",
    "QUARTERFINAL": "Quarterfinal",
    "ROUND OF 16": "Round of 16"
}

def detect_round(line):
    for k, v in ROUND_KEYWORDS.items():
        if k in line.upper():
            return v
    return None

def parse_players(line):
    # Exemple: GALAN / LEBRON (ESP) vs COELLO / TAPIA (ARG)
    m = re.match(
        r"(.+?)\s+vs\s+(.+?)\s*\((\w+)\)",
        line,
        re.IGNORECASE
    )
    if not m:
        return None

    team1, team2, nat = m.groups()

    j1_nom, j1_prenom = team1.split("/")[0].strip(), team1.split("/")[1].strip()
    j2_nom, j2_prenom = team2.split("/")[0].strip(), team2.split("/")[1].strip()

    return j1_nom, j1_prenom, nat, j2_nom, j2_prenom, nat

def parse_score(score):
    sets = re.findall(r"(\d+)\s*-\s*(\d+)", score)
    if not sets:
        return "UNKNOWN", "UNKNOWN"

    win_sets = sum(1 for a, b in sets if int(a) > int(b))
    loss_sets = len(sets) - win_sets

    return ("WIN", "LOSS") if win_sets > loss_sets else ("LOSS", "WIN")

current_round = None

with pdfplumber.open(PDF_PATH) as pdf:
    for page in pdf.pages:
        text = page.extract_text()
        if not text:
            continue

        lines = [l.strip() for l in text.split("\n") if l.strip()]

        for line in lines:
            detected_round = detect_round(line)
            if detected_round:
                current_round = detected_round
                continue

            score_match = re.search(r"\d+\s*-\s*\d+", line)
            if not score_match:
                continue

            score = score_match.group()
            players = parse_players(line)
            if not players:
                continue

            j1_nom, j1_prenom, nat1, j2_nom, j2_prenom, nat2 = players
            res1, res2 = parse_score(line)

            ROWS.append({
                "joueur1_nom": j1_nom,
                "joueur1_prenom": j1_prenom,
                "joueur1_nationalite": nat1,
                "joueur2_nom": j2_nom,
                "joueur2_prenom": j2_prenom,
                "joueur2_nationalite": nat2,
                "seed": None,
                "round": current_round,
                "score": score,
                "resultat": res1,
                "date_tournoi": TOURNAMENT_DATE,
                "nom_tournoi": TOURNAMENT_NAME,
                "lieu_tournoi": TOURNAMENT_PLACE,
                "prize_money": 0,
                "points": 0
            })

df = pd.DataFrame(ROWS)

df.to_csv(OUTPUT_CSV, index=False, encoding="utf-8")

print("✅ CSV APR généré avec remplissage maximal")
print(f"📄 {OUTPUT_CSV}")
print(f"📊 {len(df)} matchs")
