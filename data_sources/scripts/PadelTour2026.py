import csv

# Données 2026 extraites directement de l'image du calendrier
events = [
    {"calendar_year": 2026, "event_name": "RIYADH SEASON P1",     "event_level": "P1",  "city": "Riyadh",              "country": "Saudi Arabia",       "start_date": "2026-02-09", "end_date": "2026-02-14"},
    {"calendar_year": 2026, "event_name": "GIJON P2",              "event_level": "P2",  "city": "Gijón",               "country": "Spain",              "start_date": "2026-03-02", "end_date": "2026-03-08"},
    {"calendar_year": 2026, "event_name": "CANCUN P2",             "event_level": "P2",  "city": "Cancún",              "country": "Mexico",             "start_date": "2026-03-16", "end_date": "2026-03-22"},
    {"calendar_year": 2026, "event_name": "MIAMI P1",              "event_level": "P1",  "city": "Miami",               "country": "United States",      "start_date": "2026-03-23", "end_date": "2026-03-29"},
    {"calendar_year": 2026, "event_name": "QATAR MAJOR",           "event_level": "Major","city": "Doha",                "country": "Qatar",              "start_date": "2026-04-06", "end_date": "2026-04-11"},
    {"calendar_year": 2026, "event_name": "NEWGIZA P2",            "event_level": "P2",  "city": "New Giza",            "country": "Egypt",              "start_date": "2026-04-13", "end_date": "2026-04-18"},
    {"calendar_year": 2026, "event_name": "BRUSSELS P2",           "event_level": "P2",  "city": "Brussels",            "country": "Belgium",            "start_date": "2026-04-20", "end_date": "2026-04-26"},
    {"calendar_year": 2026, "event_name": "BUENOS AIRES P1",       "event_level": "P1",  "city": "Buenos Aires",        "country": "Argentina",          "start_date": "2026-05-11", "end_date": "2026-05-17"},
    {"calendar_year": 2026, "event_name": "ASUNCION P2",           "event_level": "P2",  "city": "Asunción",            "country": "Paraguay",           "start_date": "2026-05-18", "end_date": "2026-05-24"},
    {"calendar_year": 2026, "event_name": "ITALY MAJOR",           "event_level": "Major","city": "Rome",                "country": "Italy",              "start_date": "2026-06-01", "end_date": "2026-06-07"},
    {"calendar_year": 2026, "event_name": "VALENCIA P1",           "event_level": "P1",  "city": "Valencia",            "country": "Spain",              "start_date": "2026-06-08", "end_date": "2026-06-14"},
    {"calendar_year": 2026, "event_name": "VALLADOLID P2",         "event_level": "P2",  "city": "Valladolid",          "country": "Spain",              "start_date": "2026-06-22", "end_date": "2026-06-28"},
    {"calendar_year": 2026, "event_name": "BORDEAUX P2",           "event_level": "P2",  "city": "Bordeaux",            "country": "France",             "start_date": "2026-06-29", "end_date": "2026-07-05"},
    {"calendar_year": 2026, "event_name": "MALAGA P1",             "event_level": "P1",  "city": "Málaga",              "country": "Spain",              "start_date": "2026-07-13", "end_date": "2026-07-19"},
    {"calendar_year": 2026, "event_name": "PRETORIA P2",           "event_level": "P2",  "city": "Pretoria",            "country": "South Africa",       "start_date": "2026-07-27", "end_date": "2026-08-02"},
    {"calendar_year": 2026, "event_name": "LONDON P1",             "event_level": "P1",  "city": "London",              "country": "United Kingdom",     "start_date": "2026-08-03", "end_date": "2026-08-09"},
    {"calendar_year": 2026, "event_name": "MADRID P1",             "event_level": "P1",  "city": "Madrid",              "country": "Spain",              "start_date": "2026-08-31", "end_date": "2026-09-06"},
    {"calendar_year": 2026, "event_name": "PARIS MAJOR",           "event_level": "Major","city": "Paris",               "country": "France",             "start_date": "2026-09-07", "end_date": "2026-09-13"},
    {"calendar_year": 2026, "event_name": "EUROPE P2 (TBC)",       "event_level": "P2",  "city": "TBC",                 "country": "Europe",             "start_date": "2026-09-14", "end_date": "2026-09-20"},
    {"calendar_year": 2026, "event_name": "ROTTERDAM P2",          "event_level": "P2",  "city": "Rotterdam",           "country": "Netherlands",        "start_date": "2026-09-28", "end_date": "2026-10-04"},
    {"calendar_year": 2026, "event_name": "GERMANY P2",            "event_level": "P2",  "city": "TBC",                 "country": "Germany",            "start_date": "2026-10-05", "end_date": "2026-10-11"},
    {"calendar_year": 2026, "event_name": "MILANO P1",             "event_level": "P1",  "city": "Milano",              "country": "Italy",              "start_date": "2026-10-12", "end_date": "2026-10-18"},
    {"calendar_year": 2026, "event_name": "KUWAIT P1",             "event_level": "P1",  "city": "Kuwait City",         "country": "Kuwait",             "start_date": "2026-10-26", "end_date": "2026-10-31"},
    {"calendar_year": 2026, "event_name": "DUBAI P1",              "event_level": "P1",  "city": "Dubai",               "country": "United Arab Emirates","start_date": "2026-11-09", "end_date": "2026-11-15"},
    {"calendar_year": 2026, "event_name": "MEXICO MAJOR",          "event_level": "Major","city": "TBC",                 "country": "Mexico",             "start_date": "2026-11-23", "end_date": "2026-11-29"},
    {"calendar_year": 2026, "event_name": "BARCELONA FINALS",      "event_level": "Finals","city": "Barcelona",           "country": "Spain",              "start_date": "2026-12-07", "end_date": "2026-12-13"},
]

# Création du fichier CSV
with open('calendar_2026.csv', 'w', newline='', encoding='utf-8') as f:
    fieldnames = ['calendar_year', 'event_name', 'event_level', 'city', 'country', 'start_date', 'end_date']
    writer = csv.DictWriter(f, fieldnames=fieldnames)
    
    writer.writeheader()
    for event in events:
        writer.writerow(event)

print("Fichier calendar_2026.csv créé avec succès ✓")