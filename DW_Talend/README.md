# DW_Talend Jobs – Data Warehouse (DW) - Sport Padel BI

This folder contains all Talend jobs for the **Data Warehouse (DW)** of the Sport Padel project.  
Each job includes `.item` and `.properties` files, with optional `.screenshot` files for documentation.

---

## Jobs List and Description

| Job | Description |
| --- | ----------- |
| **DW_MASTER_LOAD** | Main orchestration job: executes all DW jobs in sequence to integrate SA data into the DW. |
| **DW_Load_DIM_TEMPS** | Loads time dimension into the DW (`DIM_TEMPS`). |
| **DW_Load_DIM_JOUEUR** | Loads player dimension into the DW (`DIM_JOUEUR`). |
| **DW_Load_DIM_TOURNOI** | Loads tournament dimension into the DW (`DIM_TOURNOI`). |
| **DW_Load_DIM_RAQUETTE** | Loads racket dimension into the DW (`DIM_RAQUETTE`). |
| **DW_Load_FACT_PLAYER_RANKING** | Loads player ranking fact table (`FACT_PLAYER_RANKING`). |
| **DW_Load_FACT_TOURNAMENT_AUDIENCE** | Loads tournament audience fact table (`FACT_TOURNAMENT_AUDIENCE`). |
| **DW_Load_FACT_MATCH_PERFORMANCE** | Loads match performance fact table (`FACT_MATCH_PERFORMANCE`). |

---

## Data Model

### Dimensions

**DIM_TEMPS**

| Column | Description |
| --- | ----------- |
| `id_temps` | Surrogate key for time |
| `date` | Full date |
| `annee` | Year |
| `mois` | Month number |
| `nom_mois` | Month name |
| `trimestre` | Quarter |
| `semaine` | Week number |
| `saison` | Season |

**DIM_JOUEUR**

| Column | Description |
| --- | ----------- |
| `id_joueur` | Player ID |
| `nom` | Player full name |
| `genre` | Gender |
| `nationalite` | Nationality |
| `statut` | Player status |

**DIM_TOURNOI**

| Column | Description |
| --- | ----------- |
| `id_tournoi` | Tournament ID |
| `nom` | Tournament name |
| `categorie` | Tournament category |
| `ville` | City |
| `pays` | Country |
| `surface` | Playing surface |

**DIM_RAQUETTE**

| Column | Description |
| --- | ----------- |
| `id_raquette` | Racket ID |
| `sku` | Racket SKU |
| `prix` | Price |
| `annee` | Year |
| `marque` | Brand |
| `modele` | Model |
| `categorie_prix` | Price category |

### Fact Tables

**FACT_PLAYER_RANKING**

| Column | Description |
| --- | ----------- |
| `id_joueur` | Player ID |
| `id_temps` | Time ID |
| `points` | Ranking points |
| `classement_position` | Ranking position |
| `ranking_move` | Movement in ranking |

**FACT_TOURNAMENT_AUDIENCE**

| Column | Description |
| --- | ----------- |
| `id_tournoi` | Tournament ID |
| `id_temps` | Time ID |
| `media_mentions` | Media mentions count |
| `total_attendance` | Total audience attendance |

**FACT_MATCH_PERFORMANCE**

| Column | Description |
| --- | ----------- |
| `id_joueur` | Player ID |
| `id_tournoi` | Tournament ID |
| `id_temps` | Time ID |
| `id_raquette` | Racket ID |
| `matches_played` | Matches played |
| `matches_won` | Matches won |
| `points_gagnes` | Points won |
| `prize_money_gagne` | Prize money won |

---

## Talend Job File Structure

Each Talend job typically includes:

- `.item` → The Talend job itself (mandatory)  
- `.properties` → Job parameters and configurations  
- `.screenshot` → Optional screenshot for documentation  

Example for `DW_Load_FACT_PLAYER_RANKING`:
# DW_Talend Jobs – Data Warehouse (DW) - Sport Padel BI

This folder contains all Talend jobs for the **Data Warehouse (DW)** of the Sport Padel project.  
Each job includes `.item` and `.properties` files, with optional `.screenshot` files for documentation.

---

## Jobs List and Description

| Job | Description |
| --- | ----------- |
| **DW_MASTER_LOAD** | Main orchestration job: executes all DW jobs in sequence to integrate SA data into the DW. |
| **DW_Load_DIM_TEMPS** | Loads time dimension into the DW (`DIM_TEMPS`). |
| **DW_Load_DIM_JOUEUR** | Loads player dimension into the DW (`DIM_JOUEUR`). |
| **DW_Load_DIM_TOURNOI** | Loads tournament dimension into the DW (`DIM_TOURNOI`). |
| **DW_Load_DIM_RAQUETTE** | Loads racket dimension into the DW (`DIM_RAQUETTE`). |
| **DW_Load_FACT_PLAYER_RANKING** | Loads player ranking fact table (`FACT_PLAYER_RANKING`). |
| **DW_Load_FACT_TOURNAMENT_AUDIENCE** | Loads tournament audience fact table (`FACT_TOURNAMENT_AUDIENCE`). |
| **DW_Load_FACT_MATCH_PERFORMANCE** | Loads match performance fact table (`FACT_MATCH_PERFORMANCE`). |

---

## Data Model

### Dimensions

**DIM_TEMPS**

| Column | Description |
| --- | ----------- |
| `id_temps` | Surrogate key for time |
| `date` | Full date |
| `annee` | Year |
| `mois` | Month number |
| `nom_mois` | Month name |
| `trimestre` | Quarter |
| `semaine` | Week number |
| `saison` | Season |

**DIM_JOUEUR**

| Column | Description |
| --- | ----------- |
| `id_joueur` | Player ID |
| `nom` | Player full name |
| `genre` | Gender |
| `nationalite` | Nationality |
| `statut` | Player status |

**DIM_TOURNOI**

| Column | Description |
| --- | ----------- |
| `id_tournoi` | Tournament ID |
| `nom` | Tournament name |
| `categorie` | Tournament category |
| `ville` | City |
| `pays` | Country |
| `surface` | Playing surface |

**DIM_RAQUETTE**

| Column | Description |
| --- | ----------- |
| `id_raquette` | Racket ID |
| `sku` | Racket SKU |
| `prix` | Price |
| `annee` | Year |
| `marque` | Brand |
| `modele` | Model |
| `categorie_prix` | Price category |

### Fact Tables

**FACT_PLAYER_RANKING**

| Column | Description |
| --- | ----------- |
| `id_joueur` | Player ID |
| `id_temps` | Time ID |
| `points` | Ranking points |
| `classement_position` | Ranking position |
| `ranking_move` | Movement in ranking |

**FACT_TOURNAMENT_AUDIENCE**

| Column | Description |
| --- | ----------- |
| `id_tournoi` | Tournament ID |
| `id_temps` | Time ID |
| `media_mentions` | Media mentions count |
| `total_attendance` | Total audience attendance |

**FACT_MATCH_PERFORMANCE**

| Column | Description |
| --- | ----------- |
| `id_joueur` | Player ID |
| `id_tournoi` | Tournament ID |
| `id_temps` | Time ID |
| `id_raquette` | Racket ID |
| `matches_played` | Matches played |
| `matches_won` | Matches won |
| `points_gagnes` | Points won |
| `prize_money_gagne` | Prize money won |

---

## Talend Job File Structure

Each Talend job typically includes:

- `.item` → The Talend job itself (mandatory)  
- `.properties` → Job parameters and configurations  
- `.screenshot` → Optional screenshot for documentation  

Example for `DW_Load_FACT_PLAYER_RANKING`:
    - DW_Load_FACT_PLAYER_RANKING_0.1.item
    - DW_Load_FACT_PLAYER_RANKING_0.1.properties
    - DW_Load_FACT_PLAYER_RANKING_0.1.screenshot

---

## Execution Instructions

1. Open **Talend Open Studio**.  
2. Import the `.item` files for the jobs you want to execute.  
3. Run jobs in the following **specific order** to maintain data integrity:
       - DW_MASTER_LOAD
       - DW_Load_DIM_TEMPS
       - DW_Load_DIM_JOUEUR
       - DW_Load_DIM_TOURNOI
       - DW_Load_DIM_RAQUETTE
       - DW_Load_FACT_PLAYER_RANKING
       - DW_Load_FACT_TOURNAMENT_AUDIENCE
       - DW_Load_FACT_MATCH_PERFORMANCE

4. Verify that the data is correctly loaded and integrated in the **PostgreSQL Data Warehouse**.

---

## Notes and Recommendations

- `.properties` files allow adjusting **source/target paths**, database connections, and other job parameters.  
- `.screenshot` files are for documentation only; they do **not** affect execution.  
- The **Talend project file (`talend.project`)** is required for Talend Studio to recognize the project.  
- Avoid manual edits to `.item` files outside Talend Studio unless necessary.  
- Always **version control this folder on GitHub** to track changes.

---

## Best Practices

1. Commit `.item` and `.properties` files to GitHub.  
2. Optionally exclude `.screenshot` files to reduce repository size.  
3. Document any modifications clearly in the README.  
4. Test jobs locally before pushing new versions.  
5. Strictly follow the execution order to prevent data inconsistencies.  
6. Ensure all team members use the **same Talend Studio version**.

---

## Folder Structure Recommendation

4. Verify that the data is correctly loaded and integrated in the **PostgreSQL Data Warehouse**.

---

## Notes and Recommendations

- `.properties` files allow adjusting **source/target paths**, database connections, and other job parameters.  
- `.screenshot` files are for documentation only; they do **not** affect execution.  
- The **Talend project file (`talend.project`)** is required for Talend Studio to recognize the project.  
- Avoid manual edits to `.item` files outside Talend Studio unless necessary.  
- Always **version control this folder on GitHub** to track changes.

---

## Best Practices

1. Commit `.item` and `.properties` files to GitHub.  
2. Optionally exclude `.screenshot` files to reduce repository size.  
3. Document any modifications clearly in the README.  
4. Test jobs locally before pushing new versions.  
5. Strictly follow the execution order to prevent data inconsistencies.  
6. Ensure all team members use the **same Talend Studio version**.

---

## Folder Structure Recommendation
     DW_Talend/
         ├── DW_MASTER_LOAD_0.1.*
         ├── DW_Load_DIM_TEMPS_0.1.*
         ├── DW_Load_DIM_JOUEUR_0.1.*
         ├── DW_Load_DIM_TOURNOI_0.1.*
         ├── DW_Load_DIM_RAQUETTE_0.1.*
         ├── DW_Load_FACT_PLAYER_RANKING_0.1.*
         ├── DW_Load_FACT_TOURNAMENT_AUDIENCE_0.1.*
         ├── DW_Load_FACT_MATCH_PERFORMANCE_0.1.*
         └── talend.project

- Each job folder contains `.item`, `.properties`, and optionally `.screenshot`.  
- `talend.project` is required for Talend Studio project recognition.

---

**This folder is a critical component of the Sport Padel BI project and must remain synchronized with the GitHub repository.**
