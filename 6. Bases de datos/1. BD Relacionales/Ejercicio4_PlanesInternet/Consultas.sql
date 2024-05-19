-- 1: Mostrar todos los clientes ordenados alfabéticamente por apellido y nombre.

SELECT cl.id, cl.dni, cl.nombre, cl.apellido, cl.fecha_nacimiento, cl.provincia, cl.ciudad
FROM clientes cl
ORDER BY cl.apellido, cl.nombre;

-- 2: Encontrar el plan de internet más económico y mostrar su velocidad y precio.

SELECT pl.id, pl.velocidad_megas, pl.precio
FROM planes pl
ORDER BY pl.precio
LIMIT 1;

-- 3: Calcular la cantidad total de clientes registrados en la base de datos.

SELECT COUNT(id) AS "Cantidad total de clientes"
FROM clientes;

-- 4: Calcular el promedio de velocidad de internet ofrecido por todos los planes disponibles.

SELECT ROUND(AVG(pl.velocidad_megas), 2) AS "Promedio de velocidad de internet"
FROM planes pl;

-- 5: Mostrar la cantidad total de clientes por provincia y ordenar los resultados de manera descendente.

SELECT COUNT(cl.id) AS "Cantiddad de cliente por provincia", cl.provincia AS "Provincia"
FROM clientes cl
GROUP BY cl.provincia;

-- 6: Encontrar el cliente con el plan más caro y mostrar sus detalles, incluyendo detalles del servicio.

SELECT cl.id, cl.dni, cl.nombre, cl.apellido, cl.fecha_nacimiento, cl.provincia, cl.ciudad, pl.precio, pl.velocidad_megas, pc.descuento, pc.total
FROM clientes cl, planes_clientes pc, planes pl
WHERE pc.id_cliente = cl.id AND pc.id_plan = pl.id
ORDER BY pc.total DESC
LIMIT 1;

-- 7: Calcular el total de ingresos mensuales obtenidos por la empresa en los últimos seis meses.

SELECT SUM(pc.total) AS "Total de ingresos por mes", 
       CONCAT(YEAR(pc.fecha_inicio), '-', MONTH(pc.fecha_inicio)) AS "Mes y Año"
FROM planes_clientes pc
WHERE pc.fecha_inicio >= DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH)
GROUP BY CONCAT(YEAR(pc.fecha_inicio), '-', MONTH(pc.fecha_inicio));

-- 8: Identificar el plan más popular entre los clientes y mostrar cuántos clientes lo han contratado.

SELECT pl.nombre AS "Nombre del plan", COUNT(pl.id) AS "Cantidad"
FROM planes_clientes pc, planes pl
WHERE pc.id_plan = pl.id
GROUP BY pl.nombre
ORDER BY COUNT(pl.id) DESC
LIMIT 1;

-- 9: Identificar la provincia con la mayor cantidad de clientes registrados.

SELECT cl.provincia AS "Provincia", COUNT(cl.provincia) AS "Cantidad de clientes" 
FROM clientes cl
GROUP BY cl.provincia
ORDER BY COUNT(cl.provincia) DESC
LIMIT 1;

-- 10: Encontrar el cliente más joven registrado en la base de datos y mostrar sus detalles.

SELECT cl.id, cl.dni, cl.nombre, cl.apellido, cl.fecha_nacimiento, cl.provincia, cl.ciudad
FROM clientes cl
ORDER BY cl.fecha_nacimiento ASC
LIMIT 1;
