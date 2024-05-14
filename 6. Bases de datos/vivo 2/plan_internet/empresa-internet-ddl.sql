DROP DATABASE IF EXISTS empresa_internet_db;
CREATE DATABASE empresa_internet_db;
USE empresa_internet_db;

CREATE TABLE `empresa_internet_db`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(150) NOT NULL,
  `ciudad` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idCliente`));

CREATE TABLE `empresa_internet_db`.`plan` (
  `idplan` INT NOT NULL AUTO_INCREMENT,
  `velocidad` DECIMAL(14,2) NOT NULL,
  `precio` DECIMAL(12,2) NOT NULL,
  `descuento` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`idplan`));

CREATE TABLE `empresa_internet_db`.`plan_cliente` (
  `plan_cliente` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idPlan` INT NOT NULL,
  PRIMARY KEY (`plan_cliente`),
  CONSTRAINT `fk_idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `empresa_internet_db`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idPlan`
    FOREIGN KEY (`idPlan`)
    REFERENCES `empresa_internet_db`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Incorporar registros en la tabla de clientes
INSERT INTO `empresa_internet_db`.`cliente` (`nombre`, `apellido`, `dni`, `fecha_nacimiento`, `provincia`, `ciudad`)
VALUES
('Juan', 'Perez', 12345678, '1990-05-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires'),
('María', 'González', 87654321, '1985-10-20', 'Córdoba', 'Córdoba'),
('Pedro', 'López', 55555555, '1988-07-03', 'Santa Fe', 'Rosario'),
('Ana', 'Martinez', 98765432, '1992-12-10', 'Buenos Aires', 'La Plata'),
('Luis', 'Rodriguez', 11111111, '1978-03-25', 'Mendoza', 'Mendoza'),
('Laura', 'Díaz', 22222222, '1980-08-18', 'Buenos Aires', 'Avellaneda'),
('Carlos', 'García', 33333333, '1995-06-30', 'Córdoba', 'Villa María'),
('Silvia', 'Fernández', 44444444, '1991-11-05', 'Santa Fe', 'Santa Fe'),
('Diego', 'Gómez', 66666666, '1982-04-12', 'Buenos Aires', 'Mar del Plata'),
('Martina', 'Sánchez', 77777777, '1994-09-28', 'Mendoza', 'Godoy Cruz');

-- Incorporar registros en la tabla de planes de internet
INSERT INTO `empresa_internet_db`.`plan` (`velocidad`, `precio`, `descuento`)
VALUES
(10.00, 50.00, 0.00),
(20.00, 75.00, 5.00),
(50.00, 100.00, 10.00),
(100.00, 120.00, 15.00),
(200.00, 150.00, 20.00);

-- agregar planes a clientes
INSERT INTO `empresa_internet_db`.`plan_cliente` (`idCliente`, `idPlan`)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 5),
(8, 3),
(9, 4),
(10, 5);

