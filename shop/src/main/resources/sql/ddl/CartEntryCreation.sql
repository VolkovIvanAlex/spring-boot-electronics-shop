CREATE TABLE CartEntry (
          id Integer NOT NULL AUTO_INCREMENT,
          entryNumber INTEGER NOT NULL,
          product_code VARCHAR (50) NOT NULL,
          totalPrice DOUBLE NOT NULL,
          quantity INTEGER NOT NULL,
          PRIMARY KEY (id),
          FOREIGN KEY (product_code) REFERENCES Product(id),
);