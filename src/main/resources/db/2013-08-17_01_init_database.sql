DROP DATABASE IF EXISTS dream_shop;
CREATE DATABASE IF NOT EXISTS dream_shop CHARACTER SET utf8;
DROP USER 'dream_worker'@'localhost';
CREATE USER 'dream_worker'@'localhost';
GRANT ALL PRIVILEGES ON dream_shop.* TO 'dream_worker'@'localhost';