DROP TABLE IF EXISTS dream_shop.bill;

CREATE TABLE dream_shop.bill(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,

  modified_at DATETIME,
  create_at DATETIME,

  FOREIGN KEY(user_id) REFERENCES dream_shop.user(id)
);

DROP TABLE IF EXISTS dream_shop.bill_detail;

CREATE TABLE dream_shop.bill_detail(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  order_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  count INT NOT NULL,
  price DECIMAL NOT NULL ,
  cost DECIMAL NOT NULL ,

  FOREIGN KEY(order_id) REFERENCES dream_shop.bill(id)
);