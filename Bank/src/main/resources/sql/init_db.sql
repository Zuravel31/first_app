-- Удаление таблиц, если они существуют
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS currency;

-- Создание таблицы currency
CREATE TABLE currency
(
    id       SERIAL PRIMARY KEY,
    currency VARCHAR(3) NOT NULL
);

-- Создание таблицы transactions
CREATE TABLE transactions
(
    id          SERIAL PRIMARY KEY,
    receiver    VARCHAR(255)   NOT NULL,
    sender      VARCHAR(255)   NOT NULL,
    amount      NUMERIC(10, 2) NOT NULL,
    description TEXT,
    status      VARCHAR(50)    NOT NULL,
    balance     NUMERIC(10, 2) NOT NULL,
    currency_id INTEGER NOT NULL REFERENCES currency (id)
);