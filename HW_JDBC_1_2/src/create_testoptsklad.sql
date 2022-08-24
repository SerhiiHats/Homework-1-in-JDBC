CREATE DATABASE testoptsklad;

USE testoptsklad;

-- DROP TABLE customer;

CREATE TABLE customer(id_cust INT AUTO_INCREMENT PRIMARY KEY, last_name_cust VARCHAR(50), first_name_cust VARCHAR(50), phone_cust VARCHAR(15), email_cust VARCHAR(255), created_cust DATE);
