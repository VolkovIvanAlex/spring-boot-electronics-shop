CREATE TABLE Customer
(
    id         Integer     NOT NULL AUTO_INCREMENT,
    login      VARCHAR(50) NOT NULL,
    password   VARCHAR(50) NOT NULL,
    firstName  VARCHAR(50) NOT NULL,
    lastName   VARCHAR(50) NOT NULL,
    gender     VARCHAR(50),
    birthDay   DATE,
    phone      VARCHAR(30) NOT NULL,
    address_id INTEGER     NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES Address (id)
);