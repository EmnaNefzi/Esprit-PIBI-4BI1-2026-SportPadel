# SA_Talend Jobs – Staging Area (SA) - Sport Padel BI

This folder contains all Talend jobs for the **Staging Area (SA)** of the Sport Padel Data Warehouse project.  
Each job includes its `.item` and `.properties` files, with `.screenshot` files for documentation.

---

## Jobs List and Description

| Job | Description |
| --- | ----------- |
| **SA_MASTER_LOAD** | Main job orchestrating the full loading of all SA data into the Data Warehouse. |
| **SA_Load_Calender2023** | Loads tournament calendar data for 2023. |
| **SA_Load_Calender2024** | Loads tournament calendar data for 2024. |
| **SA_Load_PadelTour_2026** | Loads tournament data for the year 2026. |
| **SA_Load_Padel_Rackets_SA** | Loads equipment data (rackets) into the SA. |
| **SA_Load_Players_Men** | Loads male player data. |
| **SA_Load_Players_Women** | Loads female player data. |
| **SA_Load_Tournois_apr_a_sep** | Loads tournaments from April to September into the SA. |

---

## Talend Job File Structure

Each Talend job typically includes:

- `.item` → The Talend job itself (mandatory)  
- `.properties` → Job parameters and configurations  
- `.screenshot` → Documentation screenshot (optional, does not affect execution)  

---

## Execution Instructions

1. Open **Talend Open Studio**.  
2. Import the `.item` files corresponding to each job.  
3. Execute the jobs in the following order for proper loading..
