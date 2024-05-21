USE empresa_internet;

-- 1 Seleccionar los clientes cuya residencia sea en la Ciudad de Mexico

SELECT *
FROM CLIENTES
WHERE ciudad
LIKE "mexico city" ;

-- 2 Seleccionar los clientes que no residan en Tijuana

SELECT *
FROM CLIENTES
WHERE ciudad
NOT LIKE "tijuana";

-- 3 Seleccionar los clientes que sean del 1990 hasta la actualidad

SELECT *
FROM CLIENTES
WHERE fecha_nacimiento > "1990-01-01";

-- 4 Seleccionar los nombres y apellidos de los clientes que hayan nacido del 2000 a la actualidad

SELECT nombre, apellido
FROM CLIENTES
WHERE  fecha_nacimiento
BETWEEN "2000-01-01" AND NOW();

-- 5 Seleccionar los nombres, apellidos y fechas de los clientes que hayan nacido entre los 90 y antes de los 2000s,
-- el nombre de las columnas recuperadas deben de estar en ingles

SELECT nombre as name, apellido as last_name, fecha_nacimiento as birth_date
FROM CLIENTES
WHERE  fecha_nacimiento
BETWEEN "1990-01-01" AND "2000-01-01";

-- 6  Obtener clientes que tengan el plan de 1000 mb

SELECT nombre, apellido, velocidad_mb
FROM CLIENTES
JOIN PLANES ON CLIENTES.id_plan = PLANES.id_plan
WHERE PLANES.velocidad_mb = 1000;


-- 7 Obtener los clientes que tengan un descuento disponible

SELECT nombre, apellido, descuento
FROM CLIENTES
JOIN PLANES ON CLIENTES.id_plan = PLANES.id_plan
WHERE PLANES.descuento IS NOT NULL;


-- 8 Obtener el promedio del precion de los planes por ciudad

SELECT ciudad, AVG(precio) AS avg_price
FROM CLIENTES
JOIN PLANES ON CLIENTES.id_plan = PLANES.id_plan
GROUP BY ciudad;


-- 9 Clientes que paguen mas dinero que el promedio de su ciudad

SELECT nombre, apellido, precio
FROM CLIENTES
JOIN PLANES ON CLIENTES.id_plan = PLANES.id_plan
WHERE precio > (SELECT AVG(precio) FROM PLANES);


-- 10 Listar el plan mas popular

SELECT PLANES.id_plan, velocidad_mb, COUNT(*) AS num_clients
FROM CLIENTES
JOIN PLANES ON CLIENTES.id_plan = PLANES.id_plan
GROUP BY PLANES.id_plan, velocidad_mb
ORDER BY num_clients DESC
LIMIT 1;
