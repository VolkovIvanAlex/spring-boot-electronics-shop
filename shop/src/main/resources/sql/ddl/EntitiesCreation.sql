CREATE
DATABASE Shop;

CREATE TABLE Address
(
    id      Integer     NOT NULL AUTO_INCREMENT,
    street  VARCHAR(50) NOT NULL,
    zipCode VARCHAR(15) NOT NULL,
    town    VARCHAR(30) NOT NULL,
    region  VARCHAR(30) NOT NULL,
    country VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Category
(
    id   Integer     NOT NULL AUTO_INCREMENT,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

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

CREATE TABLE Cart
(
    id          Integer     NOT NULL AUTO_INCREMENT,
    code        VARCHAR(50) NOT NULL,
    totalPrice  DOUBLE      NOT NULL,
    placedDate  DATE        NOT NULL,
    customer_id INTEGER     NOT NULL,
    address_id  INTEGER     NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES Customer (id),
    FOREIGN KEY (address_id) REFERENCES Address (id)
);

CREATE TABLE Product
(
    id            Integer     NOT NULL AUTO_INCREMENT,
    code          VARCHAR(50) NOT NULL,
    name          VARCHAR(70) NOT NULL,
    price         DOUBLE      NOT NULL,
    description   VARCHAR(250),
    category_code Integer     NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_code) REFERENCES Category (id)
);

CREATE TABLE CartEntry
(
    id           Integer NOT NULL AUTO_INCREMENT,
    entryNumber  INTEGER NOT NULL,
    product_code INTEGER NOT NULL,
    totalPrice   DOUBLE  NOT NULL,
    quantity     INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_code) REFERENCES Product (id)
);