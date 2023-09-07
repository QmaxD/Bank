INSERT INTO bank_accounts
VALUES ('101', 0, 'Воротынцев Дмитрий');
INSERT INTO bank_accounts
VALUES ('102', 10, 'Воротынцев Дмитрий');
INSERT INTO bank_accounts
VALUES ('103', 20, 'Воротынцев Дмитрий');
INSERT INTO bank_accounts
VALUES ('104', 30, 'Воротынцев Дмитрий');

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