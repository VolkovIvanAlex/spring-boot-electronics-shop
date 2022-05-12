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