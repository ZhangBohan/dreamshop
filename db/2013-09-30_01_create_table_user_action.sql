DROP TABLE IF EXISTS dream_shop.user_action;

CREATE TABLE dream_shop.user_action(
  id  INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(255) NULL,
  success_count INT NOT NULL DEFAULT 0,
  created_at DATETIME,

  FOREIGN KEY(user_id) REFERENCES dream_shop.user(id)
);
