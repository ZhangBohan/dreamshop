ALTER TABLE goods ADD COLUMN company_id INT,
ADD FOREIGN KEY (company_id) REFERENCES company(id);