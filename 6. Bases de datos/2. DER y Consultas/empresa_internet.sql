-- Creación del esquema empresa_internet

CREATE SCHEMA empresa_internet;

-- Cambiar al esquema empresa_internet
USE empresa_internet;


-- Creación de las tablas dentro del esquema empresa_internet
CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nac DATE NOT NULL,
    id_plan INT,
    id_ciudad INT,
    id_provincia INT,
    FOREIGN KEY (id_plan) REFERENCES plan(id_plan),
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad),
    FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);

CREATE TABLE plan (
    id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(5, 2) DEFAULT 0
);

CREATE TABLE ciudad (
    id_ciudad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    id_provincia INT,
    FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);

CREATE TABLE provincia (
    id_provincia INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- Inserción de registros en la tabla de planes de internet
INSERT INTO plan (velocidad, precio, descuento) VALUES
(50, 39.99, 5),
(100, 49.99, 10),
(200, 59.99, 15),
(500, 79.99, 20);


-- Inserción de registros en la tabla de provincias
INSERT INTO provincia (nombre) VALUES
('Buenos Aires'),
('Cordoba'),
('Mendoza'),
('Misiones'),
('Corrientes');


-- Inserción de registros en la tabla de ciudades
INSERT INTO ciudad (nombre, id_provincia) VALUES
('La Plata', 1),        -- Ciudad en Buenos Aires
('Mar del Plata', 1),   -- Ciudad en Buenos Aires
('Villa Carlos Paz', 2),-- Ciudad en Cordoba
('San Rafael', 3),      -- Ciudad en Mendoza
('Puerto Iguazu', 4);   -- Ciudad en Misiones


-- Inserción de registros en la tabla de clientes
INSERT INTO cliente (dni, nombre, apellido, fecha_nac, id_plan, id_ciudad, id_provincia) VALUES
('12345678A', 'Juan', 'Perez', '1990-01-15', 1, 1, 1),      -- Cliente en La Plata, Buenos Aires, con plan 1
('87654321B', 'Maria', 'Gomez', '1985-05-22', 2, 2, 1),     -- Cliente en Mar del Plata, Buenos Aires, con plan 2
('23456789C', 'Pedro', 'Lopez', '1978-03-10', 3, 3, 2),     -- Cliente en Villa Carlos Paz, Cordoba, con plan 3
('34567890D', 'Ana', 'Martinez', '1992-07-30', 4, 4, 3),    -- Cliente en San Rafael, Mendoza, con plan 4
('45678901E', 'Luis', 'Sanchez', '1988-11-12', 4, 5, 4);    -- Cliente en Puerto Iguazu, Misiones, con plan 4

-- Ejercicio 4 Plantear 10 consultas SQL

-- 1. Seleccionar todos los clientes junto con su ciudad y provincia
SELECT c.nombre, c.apellido, c.dni, ci.nombre AS ciudad, p.nombre AS provincia
FROM cliente c
JOIN ciudad ci ON c.id_ciudad = ci.id_ciudad
JOIN provincia p ON c.id_provincia = p.id_provincia;

-- 2. Listar todos los planes de internet disponibles
SELECT *
FROM plan;

-- 3. Contar el número de clientes por provincia
SELECT p.nombre AS provincia, COUNT(c.id_cliente) AS num_clientes
FROM cliente c
JOIN provincia p ON c.id_provincia = p.id_provincia
GROUP BY p.nombre;

-- 4. Obtener el nombre y plan de todos los clientes que viven en "Buenos Aires"
SELECT c.nombre, c.apellido, pl.velocidad AS velocidad_plan, pl.precio AS precio_plan
FROM cliente c
JOIN ciudad ci ON c.id_ciudad = ci.id_ciudad
JOIN provincia p ON ci.id_provincia = p.id_provincia
JOIN plan pl ON c.id_plan = pl.id_plan
WHERE p.nombre = 'Buenos Aires';

-- 5. Encontrar el cliente más joven
SELECT nombre, apellido, fecha_nac
FROM cliente
ORDER BY fecha_nac DESC
LIMIT 1;

-- 6. Calcular el precio total de todos los planes contratados por los clientes
SELECT SUM(pl.precio) AS precio_total
FROM cliente c
JOIN plan pl ON c.id_plan = pl.id_plan;

-- 7. Obtener el plan más popular (el más contratado) entre los clientes
SELECT pl.velocidad, pl.precio, COUNT(c.id_plan) AS num_clientes
FROM cliente c
JOIN plan pl ON c.id_plan = pl.id_plan
GROUP BY pl.velocidad, pl.precio
ORDER BY num_clientes DESC
LIMIT 1;

-- 8. Listar todas las ciudades y cuántos clientes viven en cada una
SELECT ci.nombre AS ciudad, COUNT(c.id_cliente) AS num_clientes
FROM cliente c
JOIN ciudad ci ON c.id_ciudad = ci.id_ciudad
GROUP BY ci.nombre;

-- 9. Encontrar clientes con un descuento en su plan superior a 10%
SELECT c.nombre, c.apellido, pl.descuento
FROM cliente c
JOIN plan pl ON c.id_plan = pl.id_plan
WHERE pl.descuento > 10;

-- 10. Obtener todos los clientes con su información de contacto y el nombre de su plan
SELECT c.nombre, c.apellido, c.dni, pl.velocidad AS velocidad_plan, pl.precio AS precio_plan, pl.descuento AS descuento_plan
FROM cliente c
JOIN plan pl ON c.id_plan = pl.id_plan;















