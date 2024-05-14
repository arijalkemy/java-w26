-- EJERCICIO 2
--  ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
-- Ya que el atributo DNI de la entidad cliente



-- EJERCICIO 3
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    cliente_id INT(10) PRIMARY KEY NOT NULL,
    dni INT(10),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    ciudad VARCHAR(50),
    provincia VARCHAR(50),
    fecha_nacimiento DATE
);

DROP TABLE IF EXISTS plan;

CREATE TABLE plan (
    plan_id INT(10) PRIMARY KEY NOT NULL,
	velocidad double,
    precio double,
    descuento double
);

DROP TABLE IF EXISTS clientePlan;

CREATE TABLE clientePlan (

  cliente_id INT(10) NOT NULL,
  plan_id INT(10) NOT NULL,
  KEY cliente_id_foreign (cliente_id),
  KEY plan_id_foreign (plan_id),
  CONSTRAINT cliente_id_foreign FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id),
  CONSTRAINT plan_id_foreign FOREIGN KEY (plan_id) REFERENCES plan (plan_id)
);

-- b Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.

INSERT INTO cliente (cliente_id, dni, nombre, apellido, ciudad, provincia, fecha_nacimiento)
VALUES 
    (1, 87654321, 'María', 'López', 'Bogota', 'Cundinamarca', '1992-08-21'),
    (2, 98765432, 'Pedro', 'García', 'Lima', 'Cundinamarca', '1988-03-05'),
    (3, 98765432, 'Andres', 'Perez', 'Lima', 'Cundinamarca', '1988-03-05'),
    (4, 98765432, 'Daniel', 'Oviedo', 'Lima', 'Cundinamarca', '1988-03-05'),
    (5, 98765432, 'Juan', 'Caravajal', 'Lima', 'Antioquia', '1988-03-05'),
    (6, 98765432, 'Danila', 'Navarro', 'Lima', 'Antioquia', '1988-03-05'),
    (7, 98765432, 'Diana', 'García', 'Lima', 'Antioquia', '1988-03-05'),
    (8, 98765432, 'Marta', 'García', 'Medellin', 'Antioquia', '1988-03-05'),
    (9, 98765432, 'Leandro', 'García', 'Manizales', 'Antioquia', '1988-03-05'),
    (10, 98765432, 'Camilo', 'García', 'Medellin', 'Antioquia', '1988-03-05');


INSERT INTO plan (plan_id, velocidad, precio, descuento)
VALUES 
    (1, 100, 50.0, 0.0),
    (2, 200, 70.0, 0.1),
    (3, 500, 100.0, 0.2),
    (4, 1000, 150.0, 0.3),
    (5, 2000, 200.0, 0.4);


-- Asignar un plan a cada cliente
INSERT INTO clientePlan (cliente_id, plan_id)
VALUES
    (1, 1),  -- Cliente 1 con Plan 1
    (2, 2),  -- Cliente 2 con Plan 2
    (3, 3),  -- Cliente 3 con Plan 3
    (4, 4),  -- Cliente 4 con Plan 4
    (5, 5),  -- Cliente 5 con Plan 5
    (6, 1),  -- Cliente 6 con Plan 1
    (7, 2),  -- Cliente 7 con Plan 2
    (8, 3),  -- Cliente 8 con Plan 3
    (9, 4),  -- Cliente 9 con Plan 4
    (10, 5); -- Cliente 10 con Plan 5

SELECT * FROM CLIENTE;
SELECT * FROM PLAN;

-- EJERCICIO 4
SELECT count(cliente_id) FROM cliente; -- contar la cantidad de clientes
SELECT count(plan_id) FROM plan; -- contar la cantidad de planes
SELECT MIN(velocidad) AS velociadaMinima FROM plan; -- Obtener la velocidad minima de los planes
SELECT Max(velocidad) AS velociadadMaxima FROM plan; -- Obtener la velocidad maxima de los planes
SELECT avg(velocidad) FROM plan; -- obtener la velocidad promedio de los planes
SELECT plan_id, precio, velocidad FROM plan ORDER BY precio; -- ordenar los planes por precio
SELECT plan_id, precio, velocidad FROM plan WHERE precio < 100 ORDER BY precio DESC; -- obtener todos los planes cuyo precio no supere los 100
SELECT cliente_id, nombre, apellido, dni FROM cliente WHERE provincia = "Cundinamarca"; -- Obtener a los clientes que sean de cundinamarca
SELECT ciudad, COUNT(*) AS total_clientes FROM cliente Group By ciudad; -- contar clientes por ciuadad
SELECT SUM(p.precio) AS precio_total FROM plan p; -- Suma del precio total de los planes







