--liquibase formatted sql
--changeset liquibase:insert_fx_account
INSERT INTO fx_account (account_id, balance, currency) VALUES ('A123', 100.0, 'USD');
INSERT INTO fx_account (account_id, balance, currency) VALUES ('B456', 200.0, 'EUR');
INSERT INTO fx_account (account_id, balance, currency) VALUES ('C789', 500.0, 'JPY');