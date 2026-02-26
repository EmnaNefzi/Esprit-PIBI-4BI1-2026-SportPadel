# SA_Talend Jobs – Staging Area (SA) - Sport Padel BI

This folder contains all Talend jobs for the **Staging Area (SA)** of the Sport Padel Data Warehouse project.  
Each job includes its `.item` and `.properties` files, with optional `.screenshot` files for documentation.

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

Example for `SA_Load_Calender2023`:
  - SA_Load_Calender2023_0.1.item
  - SA_Load_Calender2023_0.1.properties
  - SA_Load_Calender2023_0.1.screenshot


## Execution Instructions
1. Open **Talend Open Studio**.  
2. Import each `.item` file corresponding to the job you want to execute.  
3. Run jobs in the following order to maintain data integrity:
    - SA_MASTER_LOAD
    - SA_Load_Calender2023
    - SA_Load_Calender2024
    - SA_Load_PadelTour_2026
    - SA_Load_Padel_Rackets_SA
    - SA_Load_Players_Men
    - SA_Load_Players_Women
    - SA_Load_Tournois_apr_a_sep

4. Verify the loaded data in the **PostgreSQL Data Warehouse**.  

---

## Notes

- `.properties` files allow you to adjust **source/target paths**, database connections, and other job parameters.  
- `.screenshot` files are for documentation only; they do **not** affect execution.  
- The **Talend project file (`talend.project`)** is required for Talend Studio to recognize the project.  
- Avoid manual edits to `.item` files outside Talend Studio unless absolutely necessary.  
- Always **version control** this folder on GitHub to track changes in jobs and configurations.  

---

## Best Practices

1. Commit `.item` and `.properties` files to GitHub.  
2. Optionally, exclude `.screenshot` files if repository size is a concern.  
3. Document any modifications clearly in the README to keep the team aligned.  
4. Test jobs locally before pushing new versions.  
5. Strictly follow the execution order to prevent data inconsistencies.  
6. Ensure all team members use the **same Talend Studio version**.  

---

## Folder Structure Recommendation

4. Verify the loaded data in the **PostgreSQL Data Warehouse**.  

---

## Notes

- `.properties` files allow you to adjust **source/target paths**, database connections, and other job parameters.  
- `.screenshot` files are for documentation only; they do **not** affect execution.  
- The **Talend project file (`talend.project`)** is required for Talend Studio to recognize the project.  
- Avoid manual edits to `.item` files outside Talend Studio unless absolutely necessary.  
- Always **version control** this folder on GitHub to track changes in jobs and configurations.  

---

## Best Practices

1. Commit `.item` and `.properties` files to GitHub.  
2. Optionally, exclude `.screenshot` files if repository size is a concern.  
3. Document any modifications clearly in the README to keep the team aligned.  
4. Test jobs locally before pushing new versions.  
5. Strictly follow the execution order to prevent data inconsistencies.  
6. Ensure all team members use the **same Talend Studio version**.  

---

## Folder Structure Recommendation
    SA_Talend/
           ├── SA_MASTER_LOAD_0.1.*
           ├── SA_Load_Calender2023_0.1.*
           ├── SA_Load_Calender2024_0.1.*
           ├── SA_Load_PadelTour_2026_0.1.*
           ├── SA_Load_Padel_Rackets_SA_0.1.*
           ├── SA_Load_Players_Men_0.1.*
           ├── SA_Load_Players_Women_0.1.*
           ├── SA_Load_Tournois_apr_a_sep_0.1.*
           └── talend.project

- Each job folder contains `.item`, `.properties`, and optionally `.screenshot`.  
- `talend.project` is required for Talend Studio project recognition.

---

**This folder is a critical component of the Sport Padel BI project and must remain synchronized with the GitHub repository.**
