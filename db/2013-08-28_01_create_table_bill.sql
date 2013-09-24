DROP TABLE IF EXISTS dream_shop.bill_detail;
DROP TABLE IF EXISTS dream_shop.bill;

CREATE TABLE dream_shop.bill(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  total DECIMAL(10,2) NOT NULL,
  modified_at DATETIME,
  create_at DATETIME,

  FOREIGN KEY(user_id) REFERENCES dream_shop.user(id)
);


CREATE TABLE dream_shop.bill_detail(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  bill_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  count INT NOT NULL,
  price DECIMAL(10,2) NOT NULL ,
  cost DECIMAL(10,2) NOT NULL ,

  FOREIGN KEY(bill_id) REFERENCES dream_shop.bill(id)
);