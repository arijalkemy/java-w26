-- 1. Creacion de la base de datos 
CREATE DATABASE Telefonica;
USE Telefonica;
CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
    dni VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL
);
CREATE TABLE PlanInternet (
    id_plan INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    velocidad INT NOT NULL,
    precio DECIMAL NOT NULL,
    descuento DECIMAL NOT NULL
);
CREATE TABLE Contrato (
	id_cliente INT NOT NULL,
    id_plan INT NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
	FOREIGN KEY (id_plan) REFERENCES PlanInternet(id_plan)
);

-- 2. Cargado de informacion 
-- Insertar clientes
INSERT INTO Cliente (nombre, apellido, fecha_nacimiento, dni, provincia, ciudad) VALUES
('Juan', 'Pérez', '1990-05-15', '12345678A', 'Madrid', 'Madrid'),
('María', 'Gómez', '1985-08-20', '87654321B', 'Barcelona', 'Barcelona'),
('Carlos', 'Martínez', '1978-03-10', '98765432C', 'Valencia', 'Valencia'),
('Laura', 'López', '1995-11-25', '54321678D', 'Sevilla', 'Sevilla'),
('Pedro', 'García', '1982-07-03', '34567812E', 'Málaga', 'Málaga'),
('Ana', 'Fernández', '1989-09-18', '65432187F', 'Alicante', 'Alicante'),
('Sara', 'Ruiz', '1970-12-07', '87651234G', 'Bilbao', 'Vizcaya'),
('Javier', 'Hernández', '1998-02-28', '23148765H', 'Murcia', 'Murcia'),
('Luis', 'Díaz', '1993-04-14', '89763412J', 'Granada', 'Granada'),
('Elena', 'Sánchez', '1987-06-30', '12348765K', 'Córdoba', 'Córdoba');
-- Insertar planes de internet
INSERT INTO PlanInternet (velocidad, precio, descuento) VALUES
(50, 29.99, 0),
(100, 39.99, 5),
(200, 49.99, 10),
(300, 59.99, 15),
(500, 69.99, 20);
-- Insertar contratos
-- Asignar a cada cliente al menos un plan de internet
INSERT INTO Contrato (id_cliente, id_plan) VALUES
(1, 1), -- Juan - Plan 1
(2, 2), -- María - Plan 2
(3, 3), -- Carlos - Plan 3
(4, 4), -- Laura - Plan 4
(5, 5), -- Pedro - Plan 5
(6, 1), -- Ana - Plan 1
(7, 2), -- Sara - Plan 2
(8, 3), -- Javier - Plan 3
(9, 4), -- Luis - Plan 4
(10, 5); -- Elena - Plan 5

-- 3. Consultas 
    -- 3.1: Todos los clientes
    SELECT * FROM Cliente;

    -- 3.2: Todos los planes
    SELECT * FROM PlanInternet;

    -- 3.3: Todos los contratos
    SELECT * FROM Contrato;

    -- 3.4: Todos los contrato con sus clientes
    SELECT * FROM Contrato
    LEFT JOIN Cliente
    ON Contrato.id_cliente = Cliente.id_cliente;

    -- 3.5: Todos los contratos con sus planes
    SELECT * FROM Contrato
    LEFT JOIN PlanInternet
    ON Contrato.id_plan = PlanInternet.id_plan;

    -- 3.6: Inner Join Completo
    SELECT * FROM Contrato
    LEFT JOIN Cliente
    ON Contrato.id_cliente = Cliente.id_cliente
    RIGHT JOIN PlanInternet
    ON Contrato.id_plan = PlanInternet.id_plan;

    -- 3.7: Clientes con fecha de nacimiento despues de 1985
    SELECT * FROM Cliente
    WHERE YEAR(fecha_nacimiento) > 1985;

    -- 3.8: Planes con velocidad mayor a 100
    SELECT * FROM PlanInternet
    WHERE velocidad > 100;

    -- 3.9: Planes ordenados de manera desc-velocidad y asc-descuento
    SELECT * FROM PlanInternet
    ORDER BY velocidad DESC, descuento ASC;

    -- 3.10: Cliente ordenados por dni de manera desc
    SELECT * FROM Cliente
    ORDER BY dni DESC;

