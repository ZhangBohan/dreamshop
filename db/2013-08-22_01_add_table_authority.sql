DROP TABLE IF EXISTS dream_shop.user_authority;
DROP TABLE IF EXISTS dream_shop.user_authority;
DROP TABLE IF EXISTS dream_shop.authority;

CREATE TABLE dream_shop.authority(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL UNIQUE,
  description VARCHAR(255) NOT NULL,
  modified_at DATETIME,
  create_at DATETIME
);

CREATE TABLE dream_shop.user_authority(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  authority_id INT NOT NULL,
  FOREIGN KEY(user_id) REFERENCES dream_shop.user(id),
  FOREIGN KEY(authority_id) REFERENCES dream_shop.authority(id)
);