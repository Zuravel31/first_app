INSERT INTO currency (currency)
VALUES
    ('USD'),
    ('EUR'),
    ('GBP'),
    ('JPY'),
    ('CAD'),
    ('AUD'),
    ('CHF'),
    ('CNY'),
    ('INR'),
    ('RUB');

INSERT INTO transactions (receiver, sender, amount, description, status, balance, currency)
VALUES
    ('Alice Johnson', 'Bob Smith', 100.00, 'Payment for services', 'COMPLETED', 500.00, 'USD'),
    ('Charlie Brown', 'David Wilson', 200.00, 'Product purchase', 'FAILED', 300.00, 'EUR'),
    ('Eve Davis', 'Frank Lee', 150.00, 'Subscription fee', 'PROCESSING', 450.00, 'GBP'),
    ('Grace Clark', 'Hannah Moore', 50.00, 'Donation', 'COMPLETED', 250.00, 'JPY'),
    ('Ian King', 'Julia White', 300.00, 'Investment', 'FAILED', 600.00, 'CAD'),
    ('Kevin Hall', 'Linda Green', 75.00, 'Gift', 'PROCESSING', 175.00, 'AUD'),
    ('Michael Young', 'Nancy Adams', 250.00, 'Loan repayment', 'COMPLETED', 550.00, 'CHF'),
    ('Olivia Scott', 'Paul Turner', 400.00, 'Rent payment', 'FAILED', 800.00, 'CNY'),
    ('Quinn Harris', 'Rachel Walker', 90.00, 'Charity', 'PROCESSING', 290.00, 'INR'),
    ('Samuel Lewis', 'Tina Martin', 120.00, 'Freelance work', 'COMPLETED', 320.00, 'RUB'),
    ('Ursula Hill', 'Victor Baker', 80.00, 'Grocery shopping', 'FAILED', 180.00, 'USD'),
    ('William Carter', 'Xavier Davis', 110.00, 'Utility bill', 'PROCESSING', 310.00, 'EUR'),
    ('Yvonne Evans', 'Zachary Foster', 130.00, 'Insurance payment', 'COMPLETED', 460.00, 'GBP'),
    ('Aaron Gray', 'Bella Hughes', 60.00, 'Coffee shop', 'FAILED', 160.00, 'JPY'),
    ('Catherine Irwin', 'Daniel Jones', 140.00, 'Gym membership', 'PROCESSING', 340.00, 'CAD'),
    ('Emily Knight', 'Franklin Lopez', 160.00, 'Movie tickets', 'COMPLETED', 460.00, 'AUD'),
    ('George Mason', 'Hannah Nelson', 170.00, 'Book purchase', 'FAILED', 570.00, 'CHF'),
    ('Irene Owens', 'Jackson Parker', 180.00, 'Restaurant bill', 'PROCESSING', 680.00, 'CNY'),
    ('Karen Quinn', 'Leo Robinson', 190.00, 'Concert tickets', 'COMPLETED', 790.00, 'INR'),
    ('Martha Stewart', 'Nathan Turner', 200.00, 'Flight booking', 'FAILED', 900.00, 'RUB');
