import pdfplumber
import csv
import sys
import os

pdf_path = sys.argv[1]
csv_path = sys.argv[2]

with pdfplumber.open(pdf_path) as pdf, open(csv_path, mode='w', newline='', encoding='utf-8') as csvfile:
    writer = csv.writer(csvfile, delimiter=';')
    writer.writerow(['nome', 'country', 'points', 'position', 'move', 'page_no'])

    for page_no, page in enumerate(pdf.pages, start=1):
        table = page.extract_table()
        if table:
            for row in table[1:]:
                if len(row) >= 5:
                    writer.writerow(row[:5] + [page_no])
