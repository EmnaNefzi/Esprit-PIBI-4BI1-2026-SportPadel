CREATE TABLE sa.sa_calendar_2026_padeltour (
    calendar_year      INTEGER NOT NULL,
    event_name         VARCHAR(255),
    event_level        VARCHAR(50),    -- P1 / Major / Finals
    city               VARCHAR(100),
    country            VARCHAR(100),
    start_date         DATE,
    end_date           DATE,
    source_file        VARCHAR(255) NOT NULL,
    load_date          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
