import pdfplumber
import csv
import os
from datetime import datetime

pdf_path = r"C:\Users\ASUS\Downloads\Sports\Sports\calendar-2023.pdf"
csv_path = r"C:\Users\ASUS\Downloads\Sports\Sports\calendar\calendar_2023.csv"

MONTHS = {
    "JANUARY": "01", "FEBRUARY": "02", "MARCH": "03", "APRIL": "04",
    "MAY": "05", "JUNE": "06", "JULY": "07", "AUGUST": "08",
    "SEPTEMBER": "09", "OCTOBER": "10", "NOVEMBER": "11", "DECEMBER": "12"
}

CATEGORIES = [
    "FIP CHAMPIONSHIP",
    "PREMIER PADEL MAJOR",
    "PREMIER PADEL P1",
    "FIP TOUR",
    "FIP PROMISES"
]

print("Existe ?", os.path.exists(pdf_path))

rows = []
current_month = None

with pdfplumber.open(pdf_path) as pdf:
    for page in pdf.pages:
        text = page.extract_text()
        if not text:
            continue

        for line in text.split("\n"):
            line = line.strip()

            # Detect month
            for m in MONTHS:
                if m in line.upper():
                    current_month = m
                    break

            # Detect events
            for cat in CATEGORIES:
                if line.startswith(cat):
                    rows.append([
                        2023,
                        current_month,
                        line,
                        cat,
                        "FIP" if "FIP" in cat else "PREMIER PADEL",
                        None,
                        None,
                        os.path.basename(pdf_path),
                        datetime.now().date()
                    ])

# Write CSV
os.makedirs(os.path.dirname(csv_path), exist_ok=True)

with open(csv_path, "w", newline="", encoding="utf-8") as f:
    writer = csv.writer(f, delimiter=";")
    writer.writerow([
        "calendar_year", "calendar_month", "event_name",
        "event_category", "circuit", "city", "country",
        "source_file", "load_date"
    ])
    writer.writerows(rows)

print(f"✅ CSV généré : {csv_path}")
print(f"➡️ {len(rows)} événements extraits")
