use movies_db;

SELECT *
FROM movies;

SELECT a.first_name, a.last_name, a.rating
FROM actors a;

SELECT s.title as titulo
FROM series s;

SELECT a.first_name, a.last_name
FROM actors a
WHERE a.rating > 7.5;

SELECT m.title, m.rating, m.awards
FROM movies m
WHERE m.rating > 7.5
  AND m.awards > 2;

SELECT m.title, m.rating
FROM movies m
ORDER BY m.rating;

SELECT m.title
FROM movies m
LIMIT 3;

SELECT m.title, m.rating
FROM movies m
ORDER BY m.rating DESC
LIMIT 5;

SELECT a.first_name, a.last_name
FROM actors a
LIMIT 10;

SELECT m.title, m.rating
FROM movies m
WHERE m.title = 'Toy Story';

SELECT a.first_name, a.last_name
FROM actors a
WHERE first_name LIKE 'Sam%';

SELECT m.title
FROM movies m
WHERE YEAR(m.release_date) >= 2004
  AND YEAR(m.release_date) <= 2008;

SELECT m.title, m.rating
FROM movies m
WHERE m.rating > 3
  AND m.awards > 1
  AND YEAR(m.release_date) >= 1988
  AND YEAR(m.release_date) <= 2009
ORDER BY m.rating;

INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '10403205', 'Daniel', 'Melo', '2000-05-31', 'Soacha', 'Soacha :v');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '15432052', 'Carlos', 'Cardozo', '2002-05-02', 'Cundinamarca', 'Cazuca');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '65404035', 'Nicolas', 'Hoyos', '1998-05-13', 'Amazonas', 'Lima');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '55687746', 'Bryann', 'Torres', '2000-05-31', 'Quindio', 'Bucaramanga');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '34545624', 'Edwin', 'Villarraga', '2000-03-23', 'Romania', 'Roma');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '56859978', 'Camilo', 'Ardila', '2000-07-05', 'Tangamandapio', 'Mexico');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '53647324', 'Diana', 'Lopez', '2000-05-31', 'Santander', 'Armenia');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '56674224', 'Mia', 'Turbay', '2000-05-31', 'Medellin', 'Itagui');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '45676252', 'Daniela', 'Aguilar', '1999-04-14', 'Antioquia', 'Tolima');
INSERT INTO empresa_internet.cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES (null, '65652657', 'Karla', 'Mendez', '2000-05-31', 'Huila', 'Pasto');

INSERT INTO empresa_internet.plan (id, descuento, precio, velocidad) VALUES (generated, 20, 89000, 300);
INSERT INTO empresa_internet.plan (id, descuento, precio, velocidad) VALUES (generated, 15, 58900, 250);
INSERT INTO empresa_internet.plan (id, descuento, precio, velocidad) VALUES (generated, 10, 44200, 200);
INSERT INTO empresa_internet.plan (id, descuento, precio, velocidad) VALUES (generated, 30, 50000, 230);
INSERT INTO empresa_internet.plan (id, descuento, precio, velocidad) VALUES (generated, 10, 20000, 100);

INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 10, 3);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 9, 2);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 8, 1);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 7, 3);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 6, 5);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 5, 2);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 4, 2);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 3, 1);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 2, 1);
INSERT INTO empresa_internet.cliente_plan (id, id_cliente, id_plan) VALUES (generated, 1, 4);

-- ----------  CONSULTAS PLANTEADAS POR EL EQUIPO  -------------
SELECT MAX(p.precio) as plan_mayor_precio
FROM plan p;

SELECT MIN(p.precio) as plan_menor_precio
FROM plan p;

# planes por cliente
SELECT COUNT(cp.id_plan) as planes, id_cliente
FROM cliente_plan cp
GROUP BY id_cliente
ORDER BY planes DESC;

SELECT p.id, p.precio
FROM plan p
WHERE p.velocidad > 200
ORDER BY precio;

# cantidad de planes del 2
SELECT COUNT(id_cliente) as cantidad
FROM cliente_plan cp
WHERE id_plan = 2
GROUP BY id_plan;

# promedio de velocidad del proveedor
SELECT AVG(p.velocidad) promedio_velocidad_proveedor
FROM plan p;

# nombres que contengan 'ca'
SELECT c.nombre, c.apellido, c.dni
FROM cliente c
WHERE c.nombre LIKE '%ca%';

# promedio precio del plan
SELECT AVG(p.precio) promedio_precio_proveedor
FROM plan p;

# usuarios nacidos despues de cierto anio
SELECT c.nombre, c.apellido FROM cliente c WHERE YEAR(c.fecha_nacimiento) >= 2002;