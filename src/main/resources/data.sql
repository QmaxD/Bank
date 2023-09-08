INSERT INTO bank_accounts
VALUES ('101', 'Рубль', 'Универсальный', 0, 'Воротынцев Дмитрий', 0.01, '102');
INSERT INTO bank_accounts
VALUES ('102', 'Рубль', 'Накопительный', 10000, 'Воротынцев Дмитрий', 5.50, '102');
INSERT INTO bank_accounts
VALUES ('103', 'Рубль', 'Универсальный', 20000, 'Воротынцев Дмитрий', 0.01, '102');
INSERT INTO bank_accounts
VALUES ('104', 'Рубль', 'Универсальный', 30000, 'Воротынцев Дмитрий', 0.01, '102');

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