CREATE DATABASE CoffeeShop;
USE CoffeeShop;

CREATE TABLE Customers(
	customer_id INT,
	order_id INT,
	first_name VARCHAR(30),
	second_name VARCHAR(30),
	age INT,
	phone_number VARCHAR(15)
);

CREATE TABLE Coffee(
	coffee_id INT,
	name_coffee VARCHAR(15),
	volume INT,
	price DECIMAL(3, 2),
	with_ice VARCHAR(5)
);

CREATE TABLE ORDERS(
	order_id INT,
	customer_id INT,
	coffee_id INT,
	name_order VARCHAR(25),
	price DECIMAL(3, 2)
);

SELECT * FROM Customers;
SELECT * FROM Coffee;
SELECT * FROM Orders;
