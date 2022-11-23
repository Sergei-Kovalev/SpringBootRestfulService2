DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    login VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
