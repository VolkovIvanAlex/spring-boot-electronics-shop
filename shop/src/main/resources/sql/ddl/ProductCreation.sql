CREATE TABLE Product(
         id Integer NOT NULL AUTO_INCREMENT,
         code VARCHAR (50) NOT NULL,
         name VARCHAR (70) NOT NULL,
         price DOUBLE NOT NULL ,
         description VARCHAR (250),
         category_code VARCHAR (50) NOT NULL,
         PRIMARY KEY (id),
         FOREIGN KEY (category_code) REFERENCES Category(id),
);