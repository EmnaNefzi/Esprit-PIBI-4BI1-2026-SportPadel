# Database – Sport Padel BI Data Warehouse

This folder contains all SQL scripts used to create the database structure of the **Sport Padel BI** project.  
It is organized into two main layers:

- **SA (Staging Area)** → Raw and intermediate data tables
- **DW (Data Warehouse)** → Analytical schema (Dimensions & Facts)

The scripts are designed for ** PostgreSQL**.

---

# Folder Structure
    Database/
       ├── SA/
       │ ├── create_sa_calendar_2023.sql
       │ ├── create_sa_calendar_2024.sql
       │ ├── create_sa_calendar_2026.sql
       │ ├── create_sa_padel_rackets.sql
       │ ├── create_sa_players_men.sql
       │ ├── create_sa_players_women.sql
       │ ├── create_sa_tournament_jul.sql
       │ └── tables_tournament_All_Like_jul.sql
       ├── DW/
       │ ├── create_dim_joueur.sql
       │ ├── create_dim_raquette.sql
       │ ├── create_dim_temps.sql
       │ ├── create_dim_tournoi.sql
       │ ├── create_fact_match_performance.sql
       │ ├── create_fact_player_ranking.sql
       │ └── create_fact_tournament_audience.sql

---

# 1. Staging Area (SA)

The **Staging Area (SA)** stores raw data extracted from external sources before transformation.
Schema used: `sa`
## SA Tables Description
### Tournament Tables (Monthly)
- `sa_tournament_jul` → Base structure for tournament matches
- `tables_tournament_All_Like_jul.sql` → Creates all monthly tournament tables (jan, feb, mar, apr, etc.)

These tables contain:
- Player names and nationalities
- Match results and scores
- Tournament metadata (date, location, prize money, points)

### Calendar Tables
- `sa_calendar_2023` → Calendar events for 2023
- `sa_calendar_2024` → Calendar events for 2024
- `sa_calendar_2026` → Padel Tour 2026 calendar

These tables store:
- Event name
- Category / level
- City and country
- Start and end dates

### Players Tables
- `sa_players_men` → Male players ranking data
- `sa_players_women` → Female players ranking data

These tables include:
- Player name
- Country
- Ranking position
- Points
- Ranking movement

### Equipment Table
- `sa_padel_rackets` → Raw racket data scraped from external sources  
Contains product attributes such as:
- SKU
- Price
- Brand
- Weight
- Shape
- Surface
- Professional player

---

# 2. Data Warehouse (DW)

The **DW (Data Warehouse)** contains the analytical model used for BI, dashboards, and reporting (Power BI).

Schema used: `dw`

The DW  design with:
- Dimension tables
- Fact tables
## Dimension Tables
### dim_joueur
Stores player information:
- id_joueur (PK)
- nom
- genre
- nationalite
- statut
### dim_temps
Time dimension for analysis:
- id_temps (PK)
- date
- annee
- mois
- nom_mois
- trimestre
- semaine
- saison
### dim_tournoi
Tournament dimension:
- id_tournoi (PK)
- nom
- categorie
- ville
- pays
- surface
### dim_raquette
Equipment dimension:
- id_raquette (PK)
- sku
- prix
- annee
- marque
- modele
- categorie_prix

## Fact Tables

### fact_player_ranking
Stores player ranking evolution:
- id_joueur (FK)
- id_temps (FK)
- points
- classement
- position_ranking
- move
### fact_tournament_audience
Stores tournament popularity metrics:
- id_tournoi (FK)
- id_temps (FK)
- media_mentions
- total_attendance
### fact_match_performance
Stores player match performance:
- id_joueur (FK)
- id_tournoi (FK)
- id_temps (FK)
- id_raquette (FK)
- matches_played
- matches_won
- points_gagnes
- prize_money_gagne
---
# Execution Order (Important)
## Step 1 – Create Schemas (PostgreSQL)
    `sql
      CREATE SCHEMA IF NOT EXISTS sa;
      CREATE SCHEMA IF NOT EXISTS dw;
## Step 2– Execute SA Scripts (First)
    Path:
        Database/SA/
## Step 3– Execute DW Scripts (After SA)
    Path:
        Database/DW/
  Dimension tables must be created before Fact tables to maintain referential integrity
  
  ---
  
# Best Practices

- Use PostgreSQL as the primary DBMS for consistency and reliability
- Keep SA and DW schemas strictly separated to respect the ETL architecture
- Never load raw data directly into DW tables (load into SA first)
- Version control all SQL scripts using GitHub
- Execute SQL scripts in the correct order (SA → DW)
- Document any schema or structural modification in this README

---

## Notes

- SA tables store raw data extracted from CSV, PDF, and external data sources
- DW tables store cleaned, transformed, and analytical data (Star Schema)
- This database structure is designed to work with Talend ETL pipelines (SA_Talend → DW_Talend)
- The Data Warehouse is optimized for Business Intelligence tools such as Power BI dashboards

This Database folder represents the core data foundation of the Sport Padel BI project and must remain synchronized with:
- data_sources (raw files)
- SA_Talend (staging ETL jobs)
- DW_Talend (warehouse ETL jobs)


