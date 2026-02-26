import pdfplumber
import csv
import sys

pdf_path = sys.argv[1]
csv_path = sys.argv[2]

with pdfplumber.open(pdf_path) as pdf, open(csv_path, 'w', newline='', encoding='utf-8') as csvfile:
    writer = csv.writer(csvfile, delimiter=';')

    # Header (ajuste les noms si besoin)
    writer.writerow(['name', 'country', 'points', 'rank', 'movement', 'page_no'])

    for page_no, page in enumerate(pdf.pages, start=1):
        table = page.extract_table()

        if table:
            for row in table[1:]:  # skip header
                row = [cell.strip() if cell else '' for cell in row]

                if len(row) >= 5:
                    writer.writerow(row[:5] + [page_no])
