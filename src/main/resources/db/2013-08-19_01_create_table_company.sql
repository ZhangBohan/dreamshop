DROP TABLE IF EXISTS dream_shop.company;

CREATE TABLE dream_shop.company(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  deleted BOOLEAN DEFAULT FALSE,
  modified_at DATETIME,
  create_at DATETIME
);