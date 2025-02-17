--liquibase formatted sql
--changeset liquibase:create_fx_account_table
CREATE TABLE IF NOT EXISTS fx_account
(
    account_id VARCHAR(50) PRIMARY KEY,
    balance DOUBLE PRECISION NOT NULL,
    currency VARCHAR(10) NOT NULL
);
