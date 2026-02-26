CREATE TABLE sa.sa_calendar_2023 (
    calendar_year      INTEGER NOT NULL,
    calendar_month     VARCHAR(20),
    event_name         VARCHAR(255),
    event_type         VARCHAR(100),
    circuit            VARCHAR(100),
    city               VARCHAR(100),
    country            VARCHAR(100),
    start_date         DATE,
    end_date           DATE
    
);
