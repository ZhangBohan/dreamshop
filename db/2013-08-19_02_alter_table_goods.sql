ALTER TABLE dream_shop.goods ADD COLUMN company_id INT,
ADD FOREIGN KEY (company_id) REFERENCES dream_shop.company(id);