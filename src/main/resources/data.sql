
INSERT INTO bank_accounts (BANK_ACCOUNT_ID, ACCOUNT_CURRENCY, ACCOUNT_NAME, ACCOUNT_NUMBER, BALANCE, CREATION_DATE, FULL_NAME, INTEREST_RATE, IS_PROLONGATION, RENEWAL_DATE, USER_ID)
VALUES ('10001', '643', 'Универсальный', 1, 0, '2023-09-01 00:00:00.000', 'Воротынцев Дмитрий', 0.01, TRUE, '2028-09-01 00:00:00.000', '102');
INSERT INTO bank_accounts (BANK_ACCOUNT_ID, ACCOUNT_CURRENCY, ACCOUNT_NAME, ACCOUNT_NUMBER, BALANCE, CREATION_DATE, FULL_NAME, INTEREST_RATE, IS_PROLONGATION, RENEWAL_DATE, USER_ID)
VALUES ('10002', '643', 'Накопительный', 2, 10000, '2023-09-01 00:00:00.000', 'Воротынцев Дмитрий', 5.50, FALSE, '2024-09-01 00:00:00.000', '102');
INSERT INTO bank_accounts (BANK_ACCOUNT_ID, ACCOUNT_CURRENCY, ACCOUNT_NAME, ACCOUNT_NUMBER, BALANCE, CREATION_DATE, FULL_NAME, INTEREST_RATE, IS_PROLONGATION, RENEWAL_DATE, USER_ID)
VALUES ('10003', '643', 'Универсальный', 3, 20000, '2023-09-01 00:00:00.000', 'Воротынцев Дмитрий', 0.01, TRUE, '2028-09-01 00:00:00.000', '102');
INSERT INTO bank_accounts (BANK_ACCOUNT_ID, ACCOUNT_CURRENCY, ACCOUNT_NAME, ACCOUNT_NUMBER, BALANCE, CREATION_DATE, FULL_NAME, INTEREST_RATE, IS_PROLONGATION, RENEWAL_DATE, USER_ID)
VALUES ('10004', '643', 'Универсальный', 4, 30000, '2023-09-01 00:00:00.000', 'Воротынцев Дмитрий', 0.01, TRUE, '2028-09-01 00:00:00.000', '102');

INSERT INTO roles
VALUES(1, 'ROLE_ADMIN');
INSERT INTO roles
VALUES(2, 'ROLE_USER');

INSERT INTO users (user_id, fullname, username, password)
VALUES('101', 'Админ Админ', 'admin', 'password');
INSERT INTO users (user_id, fullname, username, password)
VALUES('102', 'Воротынцев Дмитрий', 'dmitry', '2211');

INSERT INTO user_role
VALUES('101', 1);
INSERT INTO user_role
VALUES('101', 2);
INSERT INTO user_role
VALUES('102', 2);