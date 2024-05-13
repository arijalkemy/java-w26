/*
 * Ejercicio 3.b
 * Incorporar 10 registros en la tabla de clientes y 5 en la 
 * tabla de planes de internet.
 */
INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad) 
VALUES
    ('12345678A', 'Juan', 'Pérez', 'Madrid', 'Madrid'),
    ('23456789B', 'María', 'López', 'Madrid', 'Getafe'),
    ('34567890C', 'Luis', 'García', 'Madrid', 'Alcobendas'),
    ('45678901D', 'Ana', 'Martínez', 'Barcelona', 'Barcelona'),
    ('56789012E', 'Carlos', 'Sánchez', 'Barcelona', 'Sabadell'),
    ('67890123F', 'Laura', 'Fernández', 'Barcelona', 'Terrassa'),
    ('78901234G', 'Pedro', 'Rodríguez', 'Valencia', 'Valencia'),
    ('89012345H', 'Sara', 'Gómez', 'Valencia', 'Gandía'),
    ('90123456I', 'Pablo', 'Ruiz', 'Valencia', 'Torrent'),
    ('01234567J', 'Elena', 'Díaz', 'Alicante', 'Alicante');

INSERT INTO Plan (identificacion_plan, velocidad, precio, descuento) 
VALUES
    ('Plan básico', 20, 29.99, 0.05),
    ('Plan piola', 50, 39.99, 0.1),
    ('Plan veloz', 100, 49.99, 0.15),
    ('Plan copado', 200, 59.99, 0.2),
    ('Plan megamáquina', 500, 69.99, 0.25);

/*
 * Ejercicio 3.c
 * Realizar las asociaciones/relaciones correspondientes entre estos registros.
 */
INSERT INTO ClientePlan (id_cliente, id_plan, fecha_alta, fecha_baja)
VALUES
    (1, 1, '2024-05-01', '2024-05-10'),
    (2, 2, '2024-04-15', NULL),
    (3, 3, '2024-04-20', '2024-05-05'),
    (4, 4, '2024-05-03', NULL),
    (5, 5, '2024-04-25', '2024-05-15'),
    (6, 1, '2024-05-07', NULL),
    (7, 2, '2024-05-10', NULL),
    (8, 3, '2024-04-30', '2024-05-20'),
    (9, 4, '2024-05-05', NULL),
    (10, 5, '2024-05-15', NULL);

/*
 * Ejercicio 4
 * Plantear 10 consultas SQL que se podrían realizar a la base de datos. 
 * Expresar las sentencias.
 */
-- Obtener toda la información de Clientes, ordenando por apellido y nombre
SELECT *
FROM Cliente c
ORDER BY apellido, nombre;

-- Obtener el listado de los Clientes de la provincia de Valencia
SELECT nombre, apellido, provincia, ciudad
FROM Cliente
WHERE provincia = 'Valencia';

-- Obtener el listado de Clientas que no estén en la provincia de Barcelona
SELECT nombre, apellido, provincia, ciudad
FROM Cliente
WHERE provincia != 'Barcelona';

-- Obtener el listado de todas las provincias para las que existen Clientes
SELECT DISTINCT(provincia)
FROM Cliente
ORDER BY provincia;

-- Obtener la cantidad total de Clientes
SELECT COUNT(*)
FROM Cliente;

-- Obtener el nombre, velocidad precio de los planes con velocidad igual o mayor a 100 megas
SELECT identificacion_plan, velocidad, precio
FROM Plan
WHERE velocidad >= 100;

-- Obtener el Plan con mayor velocidad
SELECT identificacion_plan, velocidad, precio 
FROM Plan
ORDER BY velocidad DESC
LIMIT 1;

-- Obtener el Plan mas económico
SELECT identificacion_plan, velocidad, precio 
FROM Plan
ORDER BY precio
LIMIT 1;

-- Obtener la cantidad de suscripciones actualmente activas
SELECT COUNT(*)
FROM ClientePlan
WHERE fecha_baja IS NULL;
