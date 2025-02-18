CREATE TABLE transactions
(
    id               SERIAL PRIMARY KEY,
    receiver         VARCHAR(255)   NOT NULL,
    sender           VARCHAR(255)   NOT NULL,
    amount           NUMERIC(10, 2) NOT NULL,
    description      TEXT,
    status           VARCHAR(50)    NOT NULL,
    balance NUMERIC(10, 2) NOT NULL
);
