--liquibase formatted sql
--changeset liquibase:insert_exchange_rate
INSERT INTO exchange_rate (currency, sell_rate, buy_rate)
VALUES ('USD', 35.0, 34.5),
       ('EUR', 40.0, 39.5),
    ('JPY', 0.3, 0.29);