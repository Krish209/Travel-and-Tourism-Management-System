DROP DATABASE IF EXISTS Travel_Management;
CREATE DATABASE Travel_Management;
USE Travel_Management;

-- Account table
CREATE TABLE account (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    security VARCHAR(50) NOT NULL,
    answer VARCHAR(50) NOT NULL
);

INSERT INTO account (username, name, password, security, answer) VALUES
('ff', 'Maheshboy', 'gg', 'ha', 'ha'),
('user1', 'Maheshboy', 'gg', 'ha', 'ha');


-- Customer table
CREATE TABLE customer (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    id_type VARCHAR(20) NOT NULL,
    id_number VARCHAR(20) NOT NULL,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    country VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO customer (username, id_type, id_number, name, gender, country, address, phone, email) VALUES
('user1', 'Passport', 'A1234567', 'John Doe', 'Male', 'USA', '123 Main St, Anytown, USA', '123-456-7890', 'john.doe@example.com');



-- Packages table
CREATE TABLE IF NOT EXISTS packages (
    package_id INT AUTO_INCREMENT PRIMARY KEY,
    image VARCHAR(50),
    name VARCHAR(50),
    duration VARCHAR(50),
    details TEXT,
    special VARCHAR(50),
    price VARCHAR(50)
);

INSERT INTO packages (image, name, duration, details, special, price) VALUES
('package1.jpg', 'GOLD PACKAGE', '6 days and 7 Nights', 'Airport Assistance at Aiport, Half Day City Tour, Welcome drinks on Arrival, Daily Buffet, Full Day 3 Island Cruise, English Speaking Guide', 'Summer Special', 'Rs 12000 only'),
('package2.jpg', 'SILVER PACKAGE', '4 days and 3 Nights', 'Toll Free and Entrance Free Tickets, Meet and Greet at Aiport, Welcome drinks on Arrival, Night Safari, Full Day 3 Island Cruise, Cruise with Dinner', 'Winter Special', 'Rs 25000 only'),
('package3.jpg', 'BRONZE PACKAGE', '6 days and 5 Nights', 'Return Airfare, Free Clubbing, Horse Riding & other Games, Welcome drinks on Arrival, Daily Buffet, Stay in 5 Star Hotel, BBQ Dinner', 'Winter Special', 'Rs 32000 only');


-- Booked Packages table
CREATE TABLE IF NOT EXISTS booked_packages (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    package VARCHAR(50) NOT NULL,
    number_of_persons INT NOT NULL,
    id_type VARCHAR(20),
    id_number VARCHAR(20),
    phone VARCHAR(20),
    price VARCHAR(20)
);

INSERT INTO booked_packages (username, name, package, number_of_persons, id_type, id_number, phone, price) VALUES 
('user1', 'John Doe', 'Gold Package', 2, 'Passport', 'A1234567', '9876543210', 'Rs 24000'),
('john_doe', 'John Doe', 'Gold Package', 2, 'Passport', 'A1234567', '9876543210', 'Rs 24000'),
('jane_smith', 'Jane Smith', 'Silver Package', 3, 'Driver License', 'DL789456', '8765432109', 'Rs 75000');
       
       
       
-- Hotels table
CREATE TABLE hotels (
    hotel_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    image VARCHAR(100),
    cost_per_day INT,
    food_charges INT,
    ac_charges INT
);

INSERT INTO hotels (name, image, cost_per_day, food_charges, ac_charges) VALUES
('JW Marriott Hotel', 'hotel1.jpg', 5000, 500, 1000),
('Mandarin Oriental Hotel', 'hotel2.jpg', 7000, 700, 1200),
('Four Seasons Hotel', 'hotel3.jpg', 6500, 600, 1100),
('Radisson Hotel', 'hotel4.jpg', 4500, 400, 900),
('Classio Hotel', 'hotel5.jpg', 3000, 300, 700),
('The Bay Club Hotel', 'hotel6.jpg', 3500, 350, 750),
('Breeze Blows Hotel', 'hotel7.jpg', 4000, 400, 800),
('Quick Stop Hotel', 'hotel8.jpg', 2000, 200, 500),
('Happy Mornings Motel', 'hotel9.jpg', 1500, 150, 400),
('Moss View Hotel', 'hotel10.jpg', 2500, 250, 600);


-- Booked Hotels table
CREATE TABLE booked_hotels (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name varchar(50) NOT NULL,
    hotel_name VARCHAR(50) NOT NULL,
    totalPersons INT NOT NULL,
    numberOfDays INT NOT NULL,
    ac VARCHAR(10) NOT NULL,
    food VARCHAR(10) NOT NULL,
    id_type VARCHAR(20) NOT NULL,
    id_number VARCHAR(20) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL
    -- FOREIGN KEY (username) REFERENCES customer(username),
--     FOREIGN KEY (hotel_id) REFERENCES hotels(hotel_id)
);

INSERT INTO booked_hotels(username, name, hotel_name, totalPersons, numberOfDays, ac, food, id_type, id_number, phone, totalPrice) VALUES
('user1', 'John Doe', 'Four Seasons Hotel', 2, 3, 'AC', 'Yes', 'password', 'A1234567', '9876543210', '24000'),
('jane_smith', 'Jane Smith', 'Silver Package', 3, 3, 'AC', 'Yes', 'Driver License', 'DL789456', '8765432109', '75000');



-- flights table
CREATE TABLE IF NOT EXISTS flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO flights (name, price) VALUES 
('Flight to London', 1500.00),
('Flight to Paris', 1200.00),
('Flight to Hong Kong', 5000.00);

CREATE TABLE IF NOT EXISTS booked_flights (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    flight_name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    numberOfPersons INT NOT NULL,
    from_date DATE NOT NULL,
    to_date DATE NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL
);

INSERT INTO booked_flights(username, name, flight_name, price, numberOfPersons, from_date, to_date, totalPrice) VALUES
('user1', 'John Doe', 'Flight to London', 2000, 2, '2024-02-18', '2024-02-23', 24000),
('user2', 'John Doe', 'Flight to London', 2000, 2, '2024-02-18', '2024-02-23', 24000);

SELECT * FROM account;
SELECT * FROM customer;
SELECT * FROM booked_hotels;
SELECT * FROM hotels;
SELECT * FROM booked_packages;
SELECT * FROM packages;
SELECT * FROM flights;
SELECT * FROM booked_flights;
