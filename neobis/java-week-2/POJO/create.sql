CREATE DATABASE IF NOT EXISTS CoffeeShop;
USE CoffeeShop;

CREATE TABLE Customers(
	customer_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(250) NOT NULL,
	second_name VARCHAR(250) NOT NULL,
	age INT,
	email VARCHAR(400)
);

CREATE TABLE Coffee(
	coffee_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_coffee VARCHAR(30) NOT NULL,
	volume INT,
	price DECIMAL(3, 2),
	with_ice VARCHAR(5)
);

CREATE TABLE Orders(
	order_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customer_id BIGINT NOT NULL
);

CREATE TABLE OrderItem(
	order_item_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	order_id BIGINT NOT NULL,
    coffee_id BIGINT NOT NULL,
    quantity INT NOT NULL
);

-- foreign keys to each table

ALTER TABLE Orders 
ADD FOREIGN KEY (customer_id) REFERENCES Customers(customer_id);

ALTER TABLE OrderItem
ADD FOREIGN KEY (order_id) REFERENCES Orders (order_id),
ADD FOREIGN KEY (coffee_id) REFERENCES Coffee(coffee_id);

SELECT * FROM Customers;
SELECT * FROM Coffee;
SELECT * FROM Orders;
