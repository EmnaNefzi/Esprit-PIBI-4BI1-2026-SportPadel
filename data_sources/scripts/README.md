# Python Scripts - Sport Padel BI

This folder contains Python scripts used to process PDF and CSV files for the Sport Padel BI project.  
All scripts should be executed from this folder or with appropriate paths to the `../pdf/` and `../csv/` folders.

## Scripts Overview

### PDF to CSV Conversion
- `pdf_calendar_to_csv.py` → Converts calendar PDFs into CSV format.
- `pdf_players_to_csv.py` → Converts male player PDFs into CSV.
- `pdf_players-women_to_csv.py` → Converts female player PDFs into CSV.
- `PadelTour2026.py` → Converts PadelTour 2026 PDF into CSV.
- `calender2023.py` → Converts 2023 calendar PDF into CSV.
- `calender2024.py` → Converts 2024 calendar PDF into CSV.

### Tournament Scripts
- `tournois-apr.py` → Processes tournament data for April.
- Other scripts (`aug`, `dec`, `feb`, `juin`, `jul`, `mai`, `mar`, `nov`, `octo`, `sep`, `test`) process tournament data per month or test datasets.

## Usage
1. Ensure PDFs are in `../pdf/`.
2. Ensure CSV outputs will go to `../csv/`.
3. Run each script in order depending on your ETL workflow.
