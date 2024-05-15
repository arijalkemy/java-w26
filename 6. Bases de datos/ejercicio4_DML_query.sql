-- 1. Obtener clientes por plan
select nombre,apellido from Cliente where id_plan = 1;

-- 2. seleccionar los clientes cuyo apellido contengan la letra "S"
SELECT id_cliente, apellido FROM Cliente WHERE apellido LIKE '%S%';

-- 3. Calcular promedio de precios
SELECT AVG(precio) AS promedio_precios FROM Plan;

-- 4. Obtener planes con planes con descuento
SELECT * FROM Plan WHERE descuento > 0;

-- 5. Obtener clientes por provincia
SELECT * FROM Cliente WHERE provincia = 'California';

-- 6. Obtener clientes por ciudad
SELECT * FROM Cliente WHERE ciudad = 'Los Angeles';

-- 7. Obtener clientes por rango de fechas de nacimiento
SELECT * FROM Cliente WHERE fecha_nacimiento BETWEEN '1990-01-01' AND '1995-02-15';

-- 8. Obtener planes por rango de precios
SELECT * FROM Plan WHERE precio BETWEEN 50.00 AND 100.00;

-- 9. Obtener planes por rango de velocidades
SELECT * FROM Plan WHERE velocidad_megas BETWEEN 100 AND 300;

-- 10. Obtener planes por rango de descuentos
SELECT * FROM Plan WHERE descuento BETWEEN 0.10 AND 0.20;