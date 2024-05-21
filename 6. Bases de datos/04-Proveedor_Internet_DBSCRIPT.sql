CREATE DATABASE IF NOT EXISTS empresa_internet;
USE empresa_internet;

CREATE TABLE PLANES (
	id_plan INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    velocidad_mb INT NOT NULL,
    precio FLOAT NOT NULL,
    descuento FLOAT
);

CREATE TABLE CLIENTES (
	id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_plan INT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    dni VARCHAR(18) NOT NULL UNIQUE,
    ciudad VARCHAR(20) NOT NULL,
    provincia VARCHAR(30) NOT NULL,
    fecha_nacimiento DATETIME NOT NULL,
	FOREIGN KEY(id_plan) REFERENCES PLANES(id_plan)
);

INSERT INTO PLANES (velocidad_mb, precio, descuento)
VALUES
  (50, 25.99, 0.1), -- 10% discount on 50 Mbps plan
  (100, 39.99, NULL),
  (200, 59.99, 0.05), -- 5% discount on 200 Mbps plan
  (500, 89.99, NULL),
  (1000, 149.99, 0.15); -- 15% discount on 1000 Mbps plan

INSERT INTO CLIENTES (id_plan, nombre, apellido, dni, ciudad, provincia, fecha_nacimiento)
VALUES
  (1, 'Maria', 'Rodriguez', '123456789', 'Mexico City', 'Mexico City', '1990-05-12'),
  (2, 'Carlos', 'Gomez', '987654321', 'Guadalajara', 'Jalisco', '1985-08-22'),
  (3, 'Ana', 'Lopez', '567891234', 'Monterrey', 'Nuevo Leon', '1998-03-18'),
  (1, 'Luis', 'Martinez', '345678912', 'Puebla', 'Puebla', '1978-11-05'),
  (4, 'Sofia', 'Hernandez', '891234567', 'Tijuana', 'Baja California', '2002-06-29'),
  (2, 'Juan', 'Perez', '234567891', 'Cancun', 'Quintana Roo', '1994-09-03'),
  (5, 'Laura', 'Garcia', '789123456', 'Merida', 'Yucatan', '1989-01-27'),
  (3, 'Miguel', 'Sanchez', '456789123', 'Leon', 'Guanajuato', '1982-04-14'),
  (1, 'Isabella', 'Torres', '678912345', 'Queretaro', 'Queretaro', '1996-12-19'),
  (4, 'David', 'Ramirez', '912345678', 'Acapulco', 'Guerrero', '1975-07-07');
