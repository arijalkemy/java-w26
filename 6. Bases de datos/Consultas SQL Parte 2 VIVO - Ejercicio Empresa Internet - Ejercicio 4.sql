-- Obtener todos los Planes que tienen algún descuento con su respectivo descuento
SELECT identificacion_plan, descuento FROM plan WHERE descuento > 0;

-- Obtener todos los Planes sin descuento con su respectivo precio
SELECT identificacion_plan, precio FROM plan WHERE descuento = 0;

-- Obtener todos los Clientes de San Luis
SELECT nombre, apellido FROM cliente WHERE provincia LIKE "San Luis";

-- Obtener todos los Clientes cuyo apellido comienza con M
SELECT nombre, apellido FROM cliente WHERE apellido LIKE 'M%';

-- Obtener todos los Planes con sus respectivos precios finales con descuento
SELECT identificacion_plan, (precio - descuento)as precio_con_descuento FROM plan;

-- Obtener todos los Clientes
SELECT nombre, apellido FROM cliente;

-- Obtener todos los Planes con una velocidad mayor o igual a 50 Mb
SELECT identificacion_plan, velocidad FROM plan WHERE velocidad >= 50;

-- Obtener todos los Clientes que vivan en una ciudad que comienza con "Las"
SELECT nombre, apellido, ciudad FROM cliente WHERE ciudad LIKE "LAS%";

-- Obtener todos los Clientes cuyo DNI termine con 321
SELECT nombre, apellido, dni FROM cliente WHERE dni LIKE "%321";

-- Obtener todos los clientes de San Luis que vivan en Las Chacras o Juana Koslay
SELECT nombre, apellido, provincia, ciudad FROM cliente WHERE provincia LIKE 'San Luis' AND (ciudad LIKE 'Las Chacras' OR ciudad LIKE 'Juana Koslay');