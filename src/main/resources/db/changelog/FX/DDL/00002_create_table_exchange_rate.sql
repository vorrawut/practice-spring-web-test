--liquibase formatted sql
--changeset liquibase:create_exchange_rate_table
CREATE TABLE IF NOT EXISTS exchange_rate
(
    currency VARCHAR(10) PRIMARY KEY,
    sell_rate DOUBLE PRECISION NOT NULL,
    buy_rate DOUBLE PRECISION NOT NULL
);
