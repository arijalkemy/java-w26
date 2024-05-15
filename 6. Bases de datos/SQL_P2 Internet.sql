-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS empresa_internet;

-- Usar la base de datos recién creada
USE empresa_internet;

-- Crear la tabla de clientes con un id como clave primaria
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);

-- Crear la tabla de planes de internet
CREATE TABLE planes_internet (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    nombre_plan VARCHAR(50),
    velocidad_megas INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);

-- Crear tabla de relación entre clientes y planes de internet
CREATE TABLE cliente_plan_internet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_plan INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_plan) REFERENCES planes_internet(id_plan)
);

-- Insertar registros en la tabla de clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES
('12345678A', 'Juan', 'Pérez', '1990-05-20', 'Madrid', 'Madrid'),
('23456789B', 'María', 'López', '1985-09-15', 'Barcelona', 'Barcelona'),
('34567890C', 'Carlos', 'Gómez', '1982-03-10', 'Valencia', 'Valencia'),
('45678901D', 'Ana', 'Martínez', '1995-11-02', 'Sevilla', 'Sevilla'),
('56789012E', 'Laura', 'Rodríguez', '1978-07-25', 'Málaga', 'Málaga'),
('67890123F', 'Pedro', 'Sánchez', '1987-12-18', 'Alicante', 'Alicante'),
('78901234G', 'Sara', 'Fernández', '1992-08-30', 'Bilbao', 'Vizcaya'),
('89012345H', 'Diego', 'Ruiz', '1980-04-05', 'Zaragoza', 'Zaragoza'),
('90123456I', 'Elena', 'García', '1975-01-12', 'Murcia', 'Murcia'),
('01234567J', 'Mario', 'Díaz', '1998-06-28', 'Granada', 'Granada');

-- Insertar registros en la tabla de planes de internet
INSERT INTO planes_internet (nombre_plan, velocidad_megas, precio, descuento) VALUES
('Plan Básico', 30, 29.99, 0),
('Plan Estándar', 60, 49.99, 5),
('Plan Premium', 100, 79.99, 10),
('Plan Ultra', 200, 99.99, 15),
('Plan Empresarial', 500, 199.99, 20);

-- Asociar clientes con planes de internet
INSERT INTO cliente_plan_internet (id_cliente, id_plan) VALUES
(1, 1), -- Juan tiene el Plan Básico
(2, 2), -- María tiene el Plan Estándar
(3, 3), -- Carlos tiene el Plan Premium
(4, 4), -- Ana tiene el Plan Ultra
(5, 5); -- Laura tiene el Plan Empresarial

-- 1. Obtener todos los clientes y sus planes contratados
SELECT c.nombre, c.apellido, p.nombre_plan
FROM clientes c
INNER JOIN cliente_plan_internet cp ON c.id_cliente = cp.id_cliente
INNER JOIN planes_internet p ON cp.id_plan = p.id_plan;

-- 2. Mostrar los clientes que tienen contratado un plan con una velocidad mayor a 100 megas
SELECT c.nombre, c.apellido
FROM clientes c
INNER JOIN cliente_plan_internet cp ON c.id_cliente = cp.id_cliente
INNER JOIN planes_internet p ON cp.id_plan = p.id_plan
WHERE p.velocidad_megas > 100;

-- 3. Contar cuántos clientes hay en cada provincia
SELECT provincia, COUNT(*) AS total_clientes
FROM clientes
GROUP BY provincia;

-- 4. Calcular el precio promedio de los planes de internet
SELECT AVG(precio) AS precio_promedio
FROM planes_internet;

-- 5. Encontrar los planes de internet con descuento superior al 10%
SELECT nombre_plan, descuento
FROM planes_internet
WHERE descuento > 10;

-- 6. Mostrar los clientes que residen en la provincia de Madrid
SELECT *
FROM clientes
WHERE provincia = 'Madrid';

-- 7. Obtener la velocidad máxima ofrecida entre todos los planes de internet
SELECT MAX(velocidad_megas) AS velocidad_maxima
FROM planes_internet;

-- 8. Listar los clientes cuyo nombre comience con 'M'
SELECT *
FROM clientes
WHERE nombre LIKE 'M%';

-- 9. Calcular el total a pagar por cada cliente, considerando el descuento de su plan de internet
SELECT c.nombre, c.apellido, p.nombre_plan, (p.precio - (p.precio * (p.descuento / 100))) AS total_a_pagar
FROM clientes c
INNER JOIN cliente_plan_internet cp ON c.id_cliente = cp.id_cliente
INNER JOIN planes_internet p ON cp.id_plan = p.id_plan;

-- 10. Encontrar el cliente más joven
SELECT *
FROM clientes
ORDER BY fecha_nacimiento ASC
LIMIT 1;


