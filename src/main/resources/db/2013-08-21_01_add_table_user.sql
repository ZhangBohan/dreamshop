CREATE TABLE dream_shop.user(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  company_id INT NOT NULL,
  account_expired BOOLEAN DEFAULT FALSE,
  account_locked BOOLEAN DEFAULT FALSE,
  credentials_expired BOOLEAN DEFAULT FALSE,
  enabled BOOLEAN DEFAULT FALSE,
  modified_at DATETIME,
  create_at DATETIME,
  FOREIGN KEY (company_id) REFERENCES company(id)
);
CREATE INDEX user_username_index ON dream_shop.user(username(50));

INSERT INTO dream_shop.user (username, password, company_id, account_expired, account_locked, credentials_expired, enabled, modified_at, create_at)
  VALUES ('bohan', '123456', 1, NOW(), NOW());



