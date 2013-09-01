DROP TABLE IF EXISTS dream_shop.company;

CREATE TABLE dream_shop.company(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NULL,
  deleted BOOLEAN DEFAULT FALSE,
  modified_at DATETIME,
  create_at DATETIME
);