CREATE DATABASE CoffeeShop;
USE CoffeeShop;

CREATE TABLE Customers(
	customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(30) NOT NULL,
	second_name VARCHAR(30) NOT NULL,
	age INT,
	email VARCHAR(40)
);

CREATE TABLE Coffee(
	coffee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_coffee VARCHAR(15) NOT NULL,
	volume INT,
	price DECIMAL(3, 2),
	with_ice VARCHAR(5)
);

CREATE TABLE ORDERS(
	order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customer_id INT NOT NULL,
	coffee_id INT NOT NULL,
	name_order VARCHAR(25),
	price DECIMAL(3, 2)
);

SELECT * FROM Customers;
SELECT * FROM Coffee;
SELECT * FROM Orders;
