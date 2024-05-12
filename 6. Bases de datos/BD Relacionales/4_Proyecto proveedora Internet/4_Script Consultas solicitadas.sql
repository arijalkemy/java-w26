-- 1. Obtener todos los clientes activos en Madrid:
SELECT CONCAT(c.nombre, CONCAT(" ",c.apellido)) nombre_completo 
FROM Cliente c 
WHERE c.provincia LIKE '%Madrid%' and c.ciudad LIKE '%Madrid%';

-- 2. Contar el número de clientes en cada provincia:
SELECT c.provincia, COUNT(c.id_cliente) clientes  
FROM Cliente c 
GROUP BY c.provincia; 

-- 3. Listar todos los planes con una velocidad superior a 100 Mbps:
SELECT p.nombre, p.velocidad  
FROM Plan p 
WHERE p.velocidad > 100;

-- 4. Encontrar los clientes que tienen descuentos en sus planes:
SELECT CONCAT(c.nombre, CONCAT(" ",c.apellido)) nombre_completo, dp.descuento  
FROM Cliente c, Detalle_Plan dp  
WHERE c.id_cliente = dp.id_cliente and dp.descuento != 0; 

-- 5. Calcular el total de ingresos de la compañía por planes vendidos hasta este momento:
SELECT SUM(p.precio) total_ingresos 
FROM Detalle_Plan dp, Plan p  
WHERE dp.id_plan = p.id_plan; 

-- 6. Listar los clientes cuyos planes están suspendidos:
SELECT CONCAT(c.nombre, CONCAT(" ",c.apellido)) nombre_completo, dp.id_detalle_plan id_plan, e.nombre estado_plan
FROM Cliente c, Detalle_Plan dp, Estado e  
WHERE c.id_cliente = dp.id_cliente  and dp.id_estado = e.id_estado and e.id_estado = 103;

-- 7. Encontrar los planes con descuento y su respectivo monto de descuento:
SELECT CONCAT(c.nombre, CONCAT(" ",c.apellido)) nombre_completo, p.nombre plan, (p.precio * dp.descuento)/100 monto_descuento
FROM Cliente c, Plan p, Detalle_Plan dp  
WHERE c.id_cliente = dp.id_cliente and dp.id_plan = p.id_plan and dp.descuento > 0;

-- 8. Contar el número de clientes por estado de cuenta:
SELECT e.nombre estado_cuenta, COUNT(c.id_cliente) numero_clientes 
FROM Cliente c, Detalle_Plan dp, Estado e  
WHERE c.id_cliente = dp.id_cliente and dp.id_estado = e.id_estado 
GROUP BY estado_cuenta;

-- 9. Encontrar la fecha de nacimiento del cliente más joven:
SELECT CONCAT(c.nombre, CONCAT(" ",c.apellido)) nombre_completo ,c.fecha_nacimiento as "fecha nacimiento cliente mas joven" 
FROM Cliente c
WHERE c.fecha_nacimiento = (SELECT MAX(c2.fecha_nacimiento) FROM Cliente c2); 

-- 10. Listar los planes ordenados por precio de forma descendente:
SELECT p.nombre plan, p.velocidad as "velocidad en Mgb", p.precio as "valor del plan" 
FROM Plan p 
ORDER BY p.precio DESC;

-- 11. Calcular el promedio de velocidad de todos los planes:
SELECT AVG(p.velocidad) as "velocidad promedio"  
FROM Plan p;

-- 12. Calcular el precio máximo de todos los planes:
SELECT MAX(p.precio)  as "precio maximo"  
FROM Plan p;
















