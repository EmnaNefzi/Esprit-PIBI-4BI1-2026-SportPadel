import pdfplumber
import pandas as pd
import re
from datetime import datetime

PDF_PATH = r"C:/Users/ASUS/Downloads/Sports/Sports/calendar/calendar-2024.pdf"
OUTPUT_CSV = r"C:/Users/ASUS/Downloads/Sports/Sports/calendar/calendar_2024_staging.csv"

MONTH_MAP = {
    "JAN": "01", "FEB": "02", "MAR": "03", "APR": "04",
    "MAY": "05", "JUN": "06", "JUL": "07", "AUG": "08",
    "SEP": "09", "OCT": "10", "NOV": "11", "DEC": "12"
}

COUNTRY_MAP = {
    "RIYADH": "Saudi Arabia",
    "QATAR": "Qatar",
    "ACAPULCO": "Mexico",
    "BORDEAUX": "France",
    "PARIS": "France",
    "MADRID": "Spain",
    "BARCELONA": "Spain",
    "MILANO": "Italy",
    "ROTTERDAM": "Netherlands",
    "BRUSSELS": "Belgium",
    "DUBAI": "UAE",
    "KUWAIT": "Kuwait"
}

def parse_date_range(text):
    """
    Extrait '26 FEB - 02 MAR' ou '26 FEB–02 MAR'
    """
    m = re.search(
        r"(\d{1,2})\s([A-Z]{3})\s*[–\-\/]\s*(\d{1,2})\s([A-Z]{3})",
        text
    )
    if not m:
        return None, None

    d1, m1, d2, m2 = m.groups()

    start = datetime.strptime(f"2024-{MONTH_MAP[m1]}-{d1.zfill(2)}", "%Y-%m-%d").date()
    end   = datetime.strptime(f"2024-{MONTH_MAP[m2]}-{d2.zfill(2)}", "%Y-%m-%d").date()

    return start, end

def extract_category(name):
    u = name.upper()
    if "P1" in u: return "P1"
    if "P2" in u: return "P2"
    if "MAJOR" in u: return "MAJOR"
    if "FINALS" in u: return "FINALS"
    return "OTHER"

def extract_city_country(name):
    u = name.upper()
    for city, country in COUNTRY_MAP.items():
        if city in u:
            return city.title(), country
    return None, None

rows = []

with pdfplumber.open(PDF_PATH) as pdf:
    for page in pdf.pages:
        text = page.extract_text()
        if not text:
            continue

        for line in text.split("\n"):
            line = line.strip()
            if not line:
                continue

            start_date, end_date = parse_date_range(line)
            if start_date and end_date:
                city, country = extract_city_country(line)

                rows.append({
                    "calendar_year": 2024,
                    "event_name": re.sub(r"\d.*", "", line).strip(),
                    "event_category": extract_category(line),
                    "city": city,
                    "country": country,
                    "start_date": start_date,
                    "end_date": end_date
                })

# 🔎 DEBUG SÉCURITÉ
if not rows:
    raise ValueError("❌ AUCUN événement extrait – vérifier le format du PDF")

df = pd.DataFrame(rows)

df = df[
    [
        "calendar_year",
        "event_name",
        "event_category",
        "city",
        "country",
        "start_date",
        "end_date"
    ]
]

df.drop_duplicates(inplace=True)
df.sort_values("start_date", inplace=True)

df.to_csv(OUTPUT_CSV, index=False, encoding="utf-8")

print("✅ CSV 2024 généré avec succès")
print(f"📄 {OUTPUT_CSV}")
print(f"📊 {len(df)} événements")
