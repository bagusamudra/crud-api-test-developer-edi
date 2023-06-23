CREATE DATABASE database_users;

USE database_users;

CREATE TABLE tbl_user
(
    userid      VARCHAR(50) NOT NULL,
    namalengkap VARCHAR(50) NOT NULL,
    username    VARCHAR(10) NOT NULL,
    password    VARCHAR(10) NOT NULL,
    status      CHAR(10)    NOT NULL,
    PRIMARY KEY (userid)
) ENGINE InnoDB;

SELECT *
FROM tbl_user;

DESC tbl_user;

DROP TABLE tbl_user;