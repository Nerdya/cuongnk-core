CREATE TABLE student (
     id     BIGINT       NOT NULL AUTO_INCREMENT,
     name   VARCHAR(255) NOT NULL,
     email  varchar(255) UNIQUE,
     dob    date,
     age    INTEGER,
     PRIMARY KEY (id)
);