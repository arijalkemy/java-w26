-- Mostrar todos los clientes en la tabla
SELECT * FROM clientes;

-- Mostrar todos los planes de internet en la tabla
SELECT * FROM planes_internet;

-- Mostrar los clientes que viven en la provincia de Buenos Aires
SELECT * FROM clientes WHERE provincia = 'Buenos Aires';

-- Mostrar los planes de internet con una velocidad mayor a 100 megas
SELECT * FROM planes_internet WHERE velocidad_megas > 100;

-- Mostrar los clientes que tienen un descuento en su plan de internet
SELECT c.* FROM clientes c
JOIN planes_internet p ON c.id_plan = p.id_plan
WHERE p.descuento > 0;

-- Mostrar los clientes ordenados alfabéticamente por apellido
SELECT * FROM clientes ORDER BY apellido;

-- Mostrar los planes de internet ordenados por precio de forma descendente
SELECT * FROM planes_internet ORDER BY precio DESC;

-- Mostrar el nombre, apellido y provincia de los clientes que tienen más de 30 años
SELECT nombre, apellido, provincia FROM clientes
WHERE fecha_nacimiento <= DATE_SUB(CURDATE(), INTERVAL 30 YEAR);

-- Mostrar la velocidad y el precio del plan de internet con identificación 3
SELECT velocidad_megas, precio FROM planes_internet WHERE id_plan = 3;

-- Mostrar la cantidad total de clientes en la base de datos
SELECT COUNT(*) AS total_clientes FROM clientes;