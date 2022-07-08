DROP TABLE IF EXISTS student;

CREATE TABLE student (
     id     BIGINT       NOT NULL AUTO_INCREMENT,
     name   VARCHAR(255) NOT NULL,
     email  varchar(255) UNIQUE,
     dob    date,
     PRIMARY KEY (id)
);