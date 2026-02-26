import pdfplumber
import pandas as pd
import re
from datetime import date

# =============================================================================
# PATHS
# =============================================================================

PDF_PATH = r"C:/Users/ASUS/Downloads/Sports/Sports/calendar/calendar-2023.pdf"
OUTPUT_CSV = r"C:/Users/ASUS/Downloads/Sports/Sports/calendar/calendar_2023_staging.csv"

rows = []

# =============================================================================
# MONTHS (EN + ES)
# =============================================================================

MONTHS = {
    "JANUARY": "January", "ENERO": "January",
    "FEBRUARY": "February", "FEBRERO": "February",
    "MARCH": "March", "MARZO": "March",
    "APRIL": "April", "ABRIL": "April",
    "MAY": "May", "MAYO": "May",
    "JUNE": "June", "JUNIO": "June",
    "JULY": "July", "JULIO": "July",
    "AUGUST": "August", "AGOSTO": "August",
    "SEPTEMBER": "September", "SEPTIEMBRE": "September",
    "OCTOBER": "October", "OCTUBRE": "October",
    "NOVEMBER": "November", "NOVIEMBRE": "November",
    "DECEMBER": "December", "DICIEMBRE": "December"
}

# =============================================================================
# REFERENCE CITY → COUNTRY (CAS SÛRS SEULEMENT)
# =============================================================================

CITY_COUNTRY_MAP = {
    "CIUDAD DE JAEN": ("Jaen", "Spain"),
    "JAEN": ("Jaen", "Spain"),
    "VIÑA DEL MAR": ("Vina del Mar", "Chile"),
    "VINA DEL MAR": ("Vina del Mar", "Chile"),
    "KAUNAS": ("Kaunas", "Lithuania"),
    "BORDEAUX": ("Bordeaux", "France"),
    "NEW CAIRO": ("New Cairo", "Egypt"),
    "MENDOZA": ("Mendoza", "Argentina"),
    "MILAN": ("Milan", "Italy")
}

COUNTRY_ONLY_MAP = {
    "QATAR": "Qatar",
    "ITALY": "Italy",
    "SPAIN": "Spain",
    "FRANCE": "France",
    "CHILE": "Chile",
    "EGYPT": "Egypt"
}

# =============================================================================
# FUNCTIONS
# =============================================================================

def week_to_dates(year, week):
    return (
        date.fromisocalendar(year, week, 1),
        date.fromisocalendar(year, week, 7)
    )

def guess_event_type(name):
    n = name.upper()
    if "MAJOR" in n: return "Major"
    if "P1" in n: return "P1"
    if "PROMISE" in n: return "Promises"
    if "RISE" in n: return "Rise"
    if "STAR" in n: return "Star"
    return "Other"

def get_event_scope(name):
    n = name.upper()
    if "PROMISE" in n:
        return "FIP_PROMISES"
    if "P1" in n:
        return "PREMIER_PADEL_P1"
    if "MAJOR" in n or n == "OREEDOO":
        return "PREMIER_PADEL_MAJOR"
    if "CHAMPIONSHIP" in n:
        return "FIP_CHAMPIONSHIPS"
    if "FIP" in n:
        return "FIP_TOUR"
    return "UNKNOWN_SCOPE"

def extract_city_country(event_name):
    name = event_name.upper()

    # 1️⃣ City + Country explicites
    for key, (city, country) in CITY_COUNTRY_MAP.items():
        if key in name:
            return city, country

    # 2️⃣ Country seul explicite
    for key, country in COUNTRY_ONLY_MAP.items():
        if key in name:
            return None, country

    # 3️⃣ Rien de fiable
    return None, None

# =============================================================================
# EXTRACTION
# =============================================================================

with pdfplumber.open(PDF_PATH) as pdf:
    current_month = None
    current_week = None

    for page in pdf.pages:
        text = page.extract_text()
        if not text:
            continue

        for line in [l.strip() for l in text.split("\n") if l.strip()]:

            # Detect month
            for m in MONTHS:
                if m in line.upper():
                    current_month = MONTHS[m]
                    break

            # Detect week
            w = re.search(r"(?:SEMANA\s*/\s*WEEK|S/W)\s*(\d+)", line.upper())
            if w:
                current_week = int(w.group(1))
                continue

            # Detect event
            if (
                current_month
                and current_week
                and any(k in line.upper() for k in ["FIP", "MAJOR", "P1", "PROMISE", "OREEDOO"])
            ):
                start_date, end_date = week_to_dates(2023, current_week)
                city, country = extract_city_country(line)

                rows.append({
                    "calendar_year": 2023,
                    "calendar_month": current_month,
                    "event_name": line,
                    "event_type": guess_event_type(line),
                    "event_scope": get_event_scope(line),
                    "circuit": "FIP",
                    "city": city,
                    "country": country,
                    "start_date": start_date,
                    "end_date": end_date
                })

# =============================================================================
# EXPORT
# =============================================================================

df = pd.DataFrame(rows)

df = df[
    [
        "calendar_year",
        "calendar_month",
        "event_name",
        "event_type",
        "event_scope",
        "circuit",
        "city",
        "country",
        "start_date",
        "end_date"
    ]
]

df.drop_duplicates(inplace=True)
df = df.sort_values(["start_date", "event_name"]).reset_index(drop=True)

df.to_csv(OUTPUT_CSV, index=False, encoding="utf-8")

print("✅ CSV STAGING GÉNÉRÉ (city/country traités quand explicites)")
print(f"📄 {OUTPUT_CSV}")
print(f"📊 {len(df)} événements")
