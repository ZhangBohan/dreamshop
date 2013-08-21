DROP TABLE IF EXISTS dream_shop.goods;

CREATE TABLE dream_shop.goods(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  bar_code VARCHAR(50) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  price DECIMAL NULL DEFAULT 0.0,
  cost DECIMAL NULL DEFAULT 0.0,
  specification VARCHAR(100) NULL,
  unit VARCHAR(50) NULL,
  deleted BOOLEAN DEFAULT FALSE,
  modified_at DATETIME,
  create_at DATETIME
);
CREATE INDEX goods_bar_code ON dream_shop.goods(bar_code(13));