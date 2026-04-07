# Data Warehouse Schema — Padel BI Analytics

## Architecture: Constellation Schema (Galaxy Schema)

5 Dimensions · 4 Fact Tables · PostgreSQL

---

## Dimensions

### Dim_Player (dw_dim_player)
Business key: `(full_name, gender)`

| Column | Type | Description |
|--------|------|-------------|
| player_key | INT (PK) | Surrogate key |
| player_id_business | VARCHAR | Business identifier |
| full_name | VARCHAR | Player full name |
| gender | VARCHAR(1) | M / W |
| nationality | VARCHAR | Country code (ISO) |
| country | VARCHAR | Full country name |
| status | VARCHAR | Active / Inactive / Retired |

---

### Dim_Time (dw_dim_time)
Business key: `full_date`

| Column | Type | Description |
|--------|------|-------------|
| time_key | INT (PK) | Surrogate key |
| date_key | INT | YYYYMMDD integer |
| full_date | DATE | Full date |
| year | INT | Year (2023, 2024, 2025) |
| month | INT | Month number (1–12) |
| month_name | VARCHAR | Month name |
| quarter | INT | Quarter (1–4) |
| week | INT | Week number |
| season | VARCHAR | Season label |

---

### Dim_Tournament (dw_dim_tournament)
Business key: `(tournament_name, year, start_date)`

| Column | Type | Description |
|--------|------|-------------|
| tournament_key | INT (PK) | Surrogate key |
| tournament_name | VARCHAR | Full tournament name |
| category | VARCHAR | P1, P2, Major, FIP |
| city | VARCHAR | Host city |
| country | VARCHAR | Host country |
| surface | VARCHAR | Clay / Indoor / Grass |
| prize_money | DECIMAL | Total prize money |
| start_date | DATE | Tournament start |
| end_date | DATE | Tournament end |
| year | INT | Edition year |

---

### Dim_Round (dw_dim_round)
Business key: `round_name`

| Column | Type | Description |
|--------|------|-------------|
| round_key | INT (PK) | Surrogate key |
| round_name | VARCHAR | Final / Semi-Final / QF / R16... |
| round_order | INT | 1=Final, 2=Semi, 3=QF... |
| is_final_stage | BOOLEAN | True if Final |

---

### Dim_Racket / Dim_Equipment (dw_dim_equipment)
Business key: `sku`

| Column | Type | Description |
|--------|------|-------------|
| equipment_key | INT (PK) | Surrogate key |
| sku | VARCHAR | Stock Keeping Unit (unique) |
| model | VARCHAR | Racket model name |
| brand | VARCHAR | Brand name |
| price | DECIMAL | Retail price |
| category | VARCHAR | Bas de gamme / Moyen / Haut de gamme |
| type | VARCHAR | Racket type |
| weight | VARCHAR | Weight range |
| shape | VARCHAR | Round / Diamond / Teardrop |
| level | VARCHAR | Beginner / Intermediate / Pro |
| gender_target | VARCHAR | M / W / Unisex |

---

## Fact Tables

### Fact_Match_Player (dw_fact_match_stats / dw_fact_player_stats)
**Grain:** 1 player × 1 match

| Column | Type | Description |
|--------|------|-------------|
| fact_player_stats_key | INT (PK) | Surrogate key |
| id_match | VARCHAR | Match identifier (degenerate key) |
| player_key | INT (FK) | → Dim_Player |
| tournament_key | INT (FK) | → Dim_Tournament |
| time_key | INT (FK) | → Dim_Time |
| round_key | INT (FK) | → Dim_Round |
| equipment_key | INT (FK) | → Dim_Racket (-1 if unknown) |
| matches_played | INT | 1 per row |
| matches_won | INT | 1 if win, 0 if loss |
| matches_lost | INT | 0 if win, 1 if loss |
| points | INT | Points scored |
| rank | INT | Player ranking at time of match |
| titles | INT | Titles won |
| movement | INT | Ranking movement |

---

### Fact_Player_Ranking (dw_fact_player_stats)
**Grain:** 1 player × 1 date snapshot

| Column | Type | Description |
|--------|------|-------------|
| ranking_key | INT (PK) | Surrogate key |
| player_key | INT (FK) | → Dim_Player |
| time_key | INT (FK) | → Dim_Time |
| date_snapshot | DATE | Exact snapshot date |
| ranking_position | INT | Rank (1 = world #1) |
| ranking_points | INT | Points in ranking |
| ranking_move | INT | Position change vs previous |

---

### Fact_Player_Season_Performance
**Grain:** 1 player × 1 season

| Column | Type | Description |
|--------|------|-------------|
| season_perf_key | INT (PK) | Surrogate key |
| player_key | INT (FK) | → Dim_Player |
| time_key | INT (FK) | → Dim_Time (season level) |
| matches_played | INT | Total season matches |
| matches_won | INT | Total wins |
| matches_lost | INT | Total losses |
| win_rate | DECIMAL | Win rate (0–1) |
| tournaments_played | INT | Distinct tournaments |
| titles | INT | Titles won |
| ranking | INT | End-of-season rank |

---

### Fact_Tournament_Visibility (dw_fact_tournament_audie)
**Grain:** 1 tournament × 1 season

| Column | Type | Description |
|--------|------|-------------|
| visibility_key | INT (PK) | Surrogate key |
| tournament_key | INT (FK) | → Dim_Tournament |
| time_key | INT (FK) | → Dim_Time |
| audience_value | DECIMAL | Total audience |
| audience_unit | VARCHAR | TV / Streaming / Other |
| media_mentions | INT | Number of media mentions |

---

## Relationships

```
Dim_Player          ──< Fact_Match_Player
Dim_Time            ──< Fact_Match_Player
Dim_Tournament      ──< Fact_Match_Player
Dim_Round           ──< Fact_Match_Player
Dim_Racket          ──< Fact_Match_Player

Dim_Player          ──< Fact_Player_Ranking
Dim_Time            ──< Fact_Player_Ranking

Dim_Player          ──< Fact_Player_Season_Performance
Dim_Time            ──< Fact_Player_Season_Performance

Dim_Tournament      ──< Fact_Tournament_Visibility
Dim_Time            ──< Fact_Tournament_Visibility
```

All relationships: **One-to-Many (1:N)** — dimension to fact.

---

## Missing Values Strategy

| Situation | Solution |
|-----------|----------|
| Unknown racket | equipment_key = -1 (row "Inconnu" in Dim_Racket) |
| Missing surface | surface = 'Non renseigné' |
| Partial year data (2025–2026) | Filter visuals to completed seasons |
| UNKNOWN gender | Excluded via slicer filter |
