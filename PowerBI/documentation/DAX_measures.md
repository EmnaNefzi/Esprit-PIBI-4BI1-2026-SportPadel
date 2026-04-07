# DAX Measures Documentation — Padel BI Analytics

> Complete documentation of all DAX measures used in the Power BI report.

---

## Table: dw_fact_player_stats

### Base Measures

```dax
Total Matches =
SUM(dw_fact_player_stats[matches_played])
```

```dax
Total Wins =
SUM(dw_fact_player_stats[matches_won])
```

```dax
Total Losses =
SUM(dw_fact_player_stats[matches_lost])
```

---

## KPIs Joueurs

### Win Rate %
Calculates the overall win rate across all matches.

```dax
Win Rate % =
DIVIDE(
    SUM(dw_fact_player_stats[matches_won]),
    SUM(dw_fact_player_stats[matches_played]),
    0
) * 100
```

### Male Win Rate
Filtered win rate for male players only.

```dax
Male Win Rate =
CALCULATE(
    [Win Rate %],
    dw_dim_player[gender] = "M"
)
```

### Female Win Rate
Filtered win rate for female players only.

```dax
Female Win Rate =
CALCULATE(
    [Win Rate %],
    dw_dim_player[gender] = "W"
)
```

### Avg Ranking
Average ranking position across all active players.

```dax
Avg Ranking =
AVERAGE(dw_fact_player_stats[rank])
```

### Classement Moyen Global
```dax
Classement Moyen Global =
AVERAGE(dw_fact_player_stats[rank])
```

### Joueurs Actifs
Count of distinct active players.

```dax
Joueurs Actifs =
DISTINCTCOUNT(dw_fact_player_stats[player_key])
```

### Male Players
Count of distinct male players.

```dax
Male Players =
CALCULATE(
    DISTINCTCOUNT(dw_dim_player[player_key]),
    dw_dim_player[gender] = "M"
)
```

### Female Players
Count of distinct female players.

```dax
Female Players =
CALCULATE(
    DISTINCTCOUNT(dw_dim_player[player_key]),
    dw_dim_player[gender] = "W"
)
```

### Croissance Joueurs %
Year-over-year growth in number of active players.

```dax
Croissance Joueurs % =
VAR n = DISTINCTCOUNT(dw_fact_player_stats[player_key])
VAR p = CALCULATE(
    DISTINCTCOUNT(dw_fact_player_stats[player_key]),
    PREVIOUSYEAR(dw_dim_time[full_date])
)
RETURN DIVIDE(n - p, p, 0) * 100
```

### Ranking Move (Month-over-Month)
Tracks ranking evolution month by month.

```dax
Ranking Move =
VAR rang_actuel = SUM(dw_fact_player_stats[rank])
VAR rang_prec = CALCULATE(
    SUM(dw_fact_player_stats[rank]),
    DATEADD(dw_dim_time[full_date], -1, MONTH)
)
RETURN rang_prec - rang_actuel
```

### Points Par Match
Efficiency indicator — points scored per match played.

```dax
Points Par Match =
DIVIDE(
    SUM(dw_fact_player_stats[points]),
    SUM(dw_fact_player_stats[matches_played]),
    0
)
```

### Avg Movement
Average ranking movement (positive = improving).

```dax
Avg Movement =
AVERAGE(dw_fact_player_stats[movement])
```

---

## KPIs Sponsors

### Sponsoring Score
Composite score (0–100) combining win rate, ranking, progression, and activity.

```dax
Sponsoring_Score =
VAR WinRateScore = [Win Rate %] * 0.4
VAR RankingScore =
    SWITCH(
        TRUE(),
        [Avg Ranking] <= 5,  30,
        [Avg Ranking] <= 10, 25,
        [Avg Ranking] <= 20, 20,
        [Avg Ranking] <= 50, 15,
        10
    )
VAR ProgressionScore =
    IF([Ranking Move] > 5, 20,
    IF([Ranking Move] > 0, 15, 10))
VAR ActivityScore =
    IF(SUM(dw_fact_player_stats[matches_played]) > 50, 10, 5)
RETURN
    WinRateScore + RankingScore + ProgressionScore + ActivityScore
```

### Indice Popularite Joueur
Player popularity index based on matches, points, and ranking.

```dax
Indice_Popularite_Joueur =
SUM(dw_fact_player_stats[points]) *
DIVIDE(1, [Avg Ranking], 0)
```

### Nb Joueurs Par Marque
Number of players using each racket brand.

```dax
Nb_Joueurs_Par_Marque =
DISTINCTCOUNT(dw_fact_player_stats[player_key])
```

### Taux Victoire Par Brand
Win rate grouped by equipment brand.

```dax
Taux_Victoire_Par_Brand =
CALCULATE([Win Rate %], ALLEXCEPT(dw_dim_equipment, dw_dim_equipment[brand]))
```

### Prix Moyen Raquette
Average racket price across catalog.

```dax
Prix_Moyen_Raquette =
AVERAGE(dw_dim_equipment[price])
```

### Marques Actives
Count of distinct active brands.

```dax
Marques_Actives =
DISTINCTCOUNT(dw_dim_equipment[brand])
```

---

## KPIs Tournois

### Total Audience
Total cumulative audience across all tournaments.

```dax
Total Audience =
SUM(dw_fact_tournament_audie[audience_value])
```

### Avg Audience
Average audience per tournament.

```dax
Avg Audience =
AVERAGE(dw_fact_tournament_audie[audience_value])
```

### Player Retention Rate
Percentage of players who participate in more than one tournament.

```dax
Player Retention Rate =
DIVIDE(
    CALCULATE(
        DISTINCTCOUNT(dw_fact_player_stats[player_key]),
        FILTER(
            dw_fact_player_stats,
            dw_fact_player_stats[matches_played] > 1
        )
    ),
    DISTINCTCOUNT(dw_fact_player_stats[player_key]),
    0
) * 100
```

### Match Density (Overuse Detection)
Detects players with excessive match loads.

```dax
Match_Density =
DIVIDE(
    SUM(dw_fact_player_stats[matches_played]),
    DISTINCTCOUNT(dw_dim_time[full_date]),
    0
)
```

### Ratio Femmes
Female participation ratio — SDG 5 benchmark (target: 40%).

```dax
Ratio_Femmes =
DIVIDE(
    [Female Players],
    [Joueurs Actifs],
    0
) * 100
```

### Fidelite Joueurs
Average number of tournaments attended per player.

```dax
Fidelite_Joueurs =
DIVIDE(
    DISTINCTCOUNT(dw_fact_match_stats[tournament_key]),
    DISTINCTCOUNT(dw_dim_player[player_key]),
    0
)
```

---

## Notes
- All percentage measures return values between 0 and 100 (not 0 to 1)
- Ranking measures: lower value = better rank (rank 1 = world #1)
- Ranking Move: positive value = player improved (moved up in ranking)
- All measures created in table `dw_fact_player_stats` unless noted
