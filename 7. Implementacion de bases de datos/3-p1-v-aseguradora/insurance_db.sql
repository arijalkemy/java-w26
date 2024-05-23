-- MySQL dump
-- Server version 5.7

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Create database
DROP DATABASE IF EXISTS insurance_db;
CREATE DATABASE insurance_db;
USE insurance_db;

-- Create vehicles table
DROP TABLE IF EXISTS vehicles;
CREATE TABLE vehicles (
    vehicle_id INT AUTO_INCREMENT NOT NULL,
    license_plate VARCHAR(10) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    manufacture_year YEAR NOT NULL,
    wheel_count INT NOT NULL,
    PRIMARY KEY (vehicle_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create accidents table
DROP TABLE IF EXISTS accidents;
CREATE TABLE accidents (
    accident_id INT AUTO_INCREMENT NOT NULL,
    accident_date DATE NOT NULL,
    economic_loss DECIMAL(10, 2) NOT NULL,
    vehicle_id INT NOT NULL,
    PRIMARY KEY (accident_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert sample data into vehicles table
INSERT INTO vehicles (license_plate, brand, model, manufacture_year, wheel_count) VALUES
('ABC123', 'Toyota', 'Corolla', 2019, 4),
('DEF456', 'Ford', 'F-150', 2020, 4),
('GHI789', 'Honda', 'Civic', 2018, 4),
('JKL012', 'Tesla', 'Model S', 2021, 4),
('MNO345', 'Chevrolet', 'Silverado', 2020, 4),
('PQR678', 'Ram', '1500', 2022, 4),
('STU901', 'Ford', 'Transit', 2021, 6);

-- Insert sample data into accidents table
INSERT INTO accidents (accident_date, economic_loss, vehicle_id) VALUES
('2023-01-10', 15000.00, 1),
('2023-02-20', 5000.00, 2),
('2023-03-15', 12000.00, 3),
('2023-04-25', 7000.00, 4),
('2023-05-30', 30000.00, 5),
('2023-06-18', 10000.00, 6),
('2023-07-22', 25000.00, 7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
