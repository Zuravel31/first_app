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

INSERT INTO transactions (receiver, sender, amount, description, status, balance, currency_id)
VALUES ('Alice Johnson', 'Bob Smith', 100.00, 'Payment for services', 'COMPLETED', 500.00, '1'),
       ('Charlie Brown', 'David Wilson', 200.00, 'Product purchase', 'FAILED', 300.00, '2'),
       ('Eve Davis', 'Frank Lee', 150.00, 'Subscription fee', 'PROCESSING', 450.00, '3'),
       ('Grace Clark', 'Hannah Moore', 50.00, 'Donation', 'COMPLETED', 250.00, '4'),
       ('Ian King', 'Julia White', 300.00, 'Investment', 'FAILED', 600.00, '5'),
       ('Kevin Hall', 'Linda Green', 75.00, 'Gift', 'PROCESSING', 175.00, '6'),
       ('Michael Young', 'Nancy Adams', 250.00, 'Loan repayment', 'COMPLETED', 550.00, '7'),
       ('Olivia Scott', 'Paul Turner', 400.00, 'Rent payment', 'FAILED', 800.00, '8'),
       ('Quinn Harris', 'Rachel Walker', 90.00, 'Charity', 'PROCESSING', 290.00, '9'),
       ('Samuel Lewis', 'Tina Martin', 120.00, 'Freelance work', 'COMPLETED', 320.00, '10'),
       ('Ursula Hill', 'Victor Baker', 80.00, 'Grocery shopping', 'FAILED', 180.00, '1'),
       ('William Carter', 'Xavier Davis', 110.00, 'Utility bill', 'PROCESSING', 310.00, '2'),
       ('Yvonne Evans', 'Zachary Foster', 130.00, 'Insurance payment', 'COMPLETED', 460.00, '3'),
       ('Aaron Gray', 'Bella Hughes', 60.00, 'Coffee shop', 'FAILED', 160.00, '4'),
       ('Catherine Irwin', 'Daniel Jones', 140.00, 'Gym membership', 'PROCESSING', 340.00, '5'),
       ('Emily Knight', 'Franklin Lopez', 160.00, 'Movie tickets', 'COMPLETED', 460.00, '6'),
       ('George Mason', 'Hannah Nelson', 170.00, 'Book purchase', 'FAILED', 570.00, '7'),
       ('Irene Owens', 'Jackson Parker', 180.00, 'Restaurant bill', 'PROCESSING', 680.00, '8'),
       ('Karen Quinn', 'Leo Robinson', 190.00, 'Concert tickets', 'COMPLETED', 790.00, '9'),
       ('Martha Stewart', 'Nathan Turner', 200.00, 'Flight booking', 'FAILED', 900.00, '10'),
       ('Frank Sharko', 'Lusi Anabel', '1000.00', 'Food shope', 'COMPLETED', '15000.00', '10');





