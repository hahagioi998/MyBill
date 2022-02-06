DROP DATABASE IF EXISTS mybill;
CREATE DATABASE mybill;
USE mybill;
#软件的配置表
CREATE TABLE billconfig(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`key` VARCHAR(255),
`value` VARCHAR(255)
);
#消费分类表
CREATE TABLE category(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255)
);
#账单表，需要外键约束至category表
CREATE TABLE record(
`id` INT PRIMARY KEY AUTO_INCREMENT,
spend DECIMAL,
cid INT,
note VARCHAR(255),
`date` DATE,
FOREIGN KEY(`cid`) REFERENCES category(`id`)
);

DESC billconfig;
DESC category;
DESC record;

SELECT * FROM billconfig;
SELECT * FROM category;
SELECT * FROM record;

DELETE FROM billconfig;
DELETE FROM category;
DELETE FROM record;