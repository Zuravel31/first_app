CREATE TABLE transactions
(
    id               SERIAL PRIMARY KEY,
    receiver         VARCHAR(255)   NOT NULL,
    sender           VARCHAR(255)   NOT NULL,
    amount           NUMERIC(10, 2) NOT NULL,
    description      TEXT,
    status           VARCHAR(50)    NOT NULL,
    balance          NUMERIC(10, 2) NOT NULL,
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Создание функции для обновления поля updated_at
CREATE OR REPLACE FUNCTION update_updated_at_column()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Создание триггера для автоматического обновления поля updated_at
CREATE TRIGGER update_transactions_updated_at
    BEFORE UPDATE
    ON Transactions
    FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

