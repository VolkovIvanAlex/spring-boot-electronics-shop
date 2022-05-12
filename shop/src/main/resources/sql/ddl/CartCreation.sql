CREATE TABLE Cart(
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