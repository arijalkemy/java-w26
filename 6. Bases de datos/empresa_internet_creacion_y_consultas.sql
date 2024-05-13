USE empresa_internet;

/*
CREATE TABLE PLANES (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    velocidad_mb INT,
    precio FLOAT,
    descuento FLOAT
);
CREATE TABLE CLIENTES (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    provincia VARCHAR(100),
    nombre VARCHAR(100),
    fecha_nacimiento DATETIME,
    apellido VARCHAR(100),
    ciudad VARCHAR(100),
    id_plan INT,
    FOREIGN KEY (id_plan) REFERENCES PLANES(id_plan)
);


INSERT INTO PLANES (velocidad_mb, precio, descuento) VALUES
(10, 29.99, 5.00),
(50, 49.99, 10.00),
(100, 69.99, 15.00),
(200, 89.99, 20.00),
(500, 109.99, 25.00);

INSERT INTO CLIENTES (dni, provincia, nombre, fecha_nacimiento, apellido, ciudad, id_plan) VALUES
('12345678A', 'Provincia A', 'Juan', '1980-01-01 00:00:00', 'Pérez', 'Ciudad A', 1),
('23456789B', 'Provincia B', 'María', '1985-02-02 00:00:00', 'García', 'Ciudad B', 2),
('34567890C', 'Provincia C', 'Luis', '1990-03-03 00:00:00', 'López', 'Ciudad C', 3),
('45678901D', 'Provincia D', 'Ana', '1995-04-04 00:00:00', 'Martínez', 'Ciudad D', 4),
('56789012E', 'Provincia E', 'Pedro', '2000-05-05 00:00:00', 'Sánchez', 'Ciudad E', 5),
('67890123F', 'Provincia F', 'Laura', '1975-06-06 00:00:00', 'Fernández', 'Ciudad F', 1),
('78901234G', 'Provincia G', 'Carlos', '1988-07-07 00:00:00', 'Rodríguez', 'Ciudad G', 2),
('89012345H', 'Provincia H', 'Sofía', '1992-08-08 00:00:00', 'Gómez', 'Ciudad H', 3),
('90123456I', 'Provincia I', 'Marta', '1983-09-09 00:00:00', 'Díaz', 'Ciudad I', 4),
('01234567J', 'Provincia J', 'Miguel', '1979-10-10 00:00:00', 'Torres', 'Ciudad J', 5);

*/


-- 1. Consultar todos los clientes
SELECT * FROM CLIENTES;

-- 2. Consultar todos los planes de internet
SELECT * FROM PLANES;

-- 3. Obtener los nombres y apellidos de todos los clientes junto con el nombre del plan que tienen
SELECT
    c.nombre,
    c.apellido,
    p.velocidad_mb,
    p.precio,
    p.descuento
FROM
    CLIENTES c
JOIN
    PLANES p ON c.id_plan = p.id_plan;

-- 4. Contar el número total de clientes
SELECT COUNT(*) AS total_clientes FROM CLIENTES;

-- 5. Obtener el plan más caro
SELECT * FROM PLANES ORDER BY precio DESC LIMIT 1;

-- 6. Obtener los clientes que viven en una provincia específica (ejemplo: 'Provincia A')
SELECT * FROM CLIENTES WHERE provincia = 'Provincia A';

-- 7. Listar los clientes ordenados por fecha de nacimiento (del más viejo al más joven)
SELECT * FROM CLIENTES ORDER BY fecha_nacimiento ASC;

-- 8. Obtener el promedio de velocidad de los planes de internet
SELECT AVG(velocidad_mb) AS promedio_velocidad FROM PLANES;

-- 9. Obtener la cantidad de clientes por cada plan de internet
SELECT
    p.velocidad_mb,
    COUNT(c.id_cliente) AS cantidad_clientes
FROM
    PLANES p
LEFT JOIN
    CLIENTES c ON p.id_plan = c.id_plan
GROUP BY
    p.velocidad_mb;

-- 10. Obtener los detalles de los clientes que tienen un plan con más de 100 Mbps de velocidad
SELECT
    c.*
FROM
    CLIENTES c
JOIN
    PLANES p ON c.id_plan = p.id_plan
WHERE
    p.velocidad_mb > 100;
