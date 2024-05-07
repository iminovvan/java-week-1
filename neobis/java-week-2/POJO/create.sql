CREATE DATABASE CoffeeShop;
USE CoffeeShop;

CREATE TABLE Customers(
	customer_id INT NOT NULL,
	order_id INT NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	second_name VARCHAR(30) NOT NULL,
	age INT,
	phone_number VARCHAR(15)
);

CREATE TABLE Coffee(
	coffee_id INT NOT NULL,
	name_coffee VARCHAR(15) NOT NULL,
	volume INT,
	price DECIMAL(3, 2),
	with_ice VARCHAR(5)
);

CREATE TABLE ORDERS(
	order_id INT NOT NULL,
	customer_id INT NOT NULL,
	coffee_id INT NOT NULL,
	name_order VARCHAR(25),
	price DECIMAL(3, 2)
);

SELECT * FROM Customers;
SELECT * FROM Coffee;
SELECT * FROM Orders;
