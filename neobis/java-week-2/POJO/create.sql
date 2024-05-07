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

-- add primary keys to each table
ALTER TABLE Customers
ADD PRIMARY KEY (customer_id);

ALTER TABLE Orders
ADD PRIMARY KEY (order_id);

ALTER TABLE Coffee
ADD PRIMARY KEY (coffee_id);

-- add foreign keys to each table
ALTER TABLE Customers
ADD FOREIGN KEY (order_id) REFERENCES Orders(order_id);

ALTER TABLE Orders 
ADD FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
ADD FOREIGN KEY (coffee_id) REFERENCES Coffee(coffee_id);

SELECT * FROM Customers;
SELECT * FROM Coffee;
SELECT * FROM Orders;
