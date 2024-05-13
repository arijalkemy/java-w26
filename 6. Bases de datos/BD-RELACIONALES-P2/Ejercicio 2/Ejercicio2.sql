CREATE TABLE clients (
		id_cliente INT AUTO_INCREMENT,
        nombre VARCHAR(25),
        apellido VARCHAR(25),
        fecha_nacimiento DATE,
        id_plan INT,
        id_ciudad INT,
        id_provincia INT,
        PRIMARY KEY (id_cliente),
        FOREIGN KEY (id_plan) REFERENCES planes(id_plan),
		FOREIGN KEY (id_ciudad) REFERENCES ciudades(id_ciudad),
		FOREIGN KEY (id_provincia) REFERENCES provincias(id_provincia)
        );
-- 2

CREATE TABLE provincias(
		nombre VARCHAR(25),
		id_provincia INT AUTO_INCREMENT,
        PRIMARY KEY (id_provincia)
        );
        
-- 3

CREATE TABLE ciudades(
		id_ciudad INT AUTO_INCREMENT,
        id_provincia INT,
        nombre VARCHAR(25),
        PRIMARY KEY (id_ciudad),
        FOREIGN KEY (id_provincia) REFERENCES provincias(id_provincia)
        );
        
-- 4
CREATE TABLE planes(
		id_plan INT AUTO_INCREMENT,
        velocidad INT,
        descuento FLOAT,
        precio INT,
        PRIMARY KEY (id_plan)
        );
-- 5
INSERT INTO planes (id_plan, velocidad, precio, descuento) VALUES
(1, 100, 29.99, 0.10),
(2, 300, 49.99, 0.15),
(3, 500, 59.99, 0.20),
(4, 1000, 79.99, 0.25),
(5, 50, 19.99, 0.05);

-- 6

INSERT INTO provincias (id_provincia, nombre) VALUES
(1, 'Córdoba'),
(2, 'Buenos Aires'),
(3, 'Santa Fe');

-- 7

INSERT INTO ciudades (id_ciudad, nombre, id_provincia) VALUES
(1, 'Córdoba', 1),
(2, 'Villa María', 1),
(3, 'Rosario', 3),
(4, 'Buenos Aires', 2),
(5, 'La Plata', 2);

-- 8

INSERT INTO clients (id_cliente, nombre, apellido, fecha_nacimiento, id_plan, id_ciudad, id_provincia) VALUES
(1, 'Juan', 'Pérez', '1985-02-15', 1, 1, 1),
(2, 'Ana', 'González', '1990-07-22', 2, 2, 1),
(3, 'Luis', 'Martínez', '1975-08-30', 3, 3, 3),
(4, 'Laura', 'López', '1988-12-10', 4, 4, 2),
(5, 'Mario', 'García', '2000-01-05', 5, 5, 2),
(6, 'Clara', 'Rodríguez', '1995-03-25', 1, 1, 1),
(7, 'Oscar', 'Herrera', '1969-11-09', 2, 2, 1),
(8, 'Sofía', 'Vega', '1983-04-17', 3, 3, 3),
(9, 'Ricardo', 'Juárez', '1978-06-21', 4, 4, 2),
(10, 'Pablo', 'Aguirre', '1992-09-15', 5, 5, 2);

-- 9

SELECT * FROM clients;
-- 10

SELECT * FROM provincias WHERE id_provincia =1;

-- 11

SELECT id_cliente, nombre, apellido FROM clients WHERE fecha_nacimiento > "1980-01-01";

-- 12

SELECT nombre FROM provincias WHERE nombre LIKE "S%";

-- 13
SELECT nombre FROM ciudades ORDER BY nombre DESC;

-- 14
SELECT id_plan, precio FROM planes ORDER BY precio;

-- 15
SELECT AVG(precio) FROM planes;

-- 16
SELECT nombre, apellido, fecha_nacimiento FROM clients WHERE id_provincia = 3; 

-- 17 
SELECT SUM(precio) FROM planes;

-- 18 
SELECT id_plan, descuento FROM planes WHERE descuento BETWEEN 30 AND 60;