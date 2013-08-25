DROP TABLE IF EXISTS dream_shop.company;

CREATE TABLE dream_shop.company(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  deleted BOOLEAN DEFAULT FALSE,
  modified_at DATETIME,
  create_at DATETIME
);

INSERT INTO dream_shop.company(id, name, description, deleted,modified_at,create_at)
  VALUES(1, "梦之店", "梦想开始的地方", false, NOW(), NOW());