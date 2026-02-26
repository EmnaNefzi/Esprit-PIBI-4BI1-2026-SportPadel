CREATE TABLE sa.sa_calendar_2024 (
    calendar_year      INTEGER NOT NULL,
    event_name         VARCHAR(255),
    event_category     VARCHAR(50),   -- P1 / P2 / Major
    city               VARCHAR(100),
    country            VARCHAR(100),
    start_date         DATE,
    end_date           DATE
);
