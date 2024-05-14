/*Consultar todos los clientes:*/
SELECT * FROM Cliente;
/*Obtener todos los planes de internet:*/
SELECT * FROM Plan;
/*Listar todos los clientes que están suscritos a un plan de internet:*/
SELECT c.id_cliente, c.nombre, c.apellido, cp.id_plan
FROM Cliente c
JOIN ClientePlan cp ON c.id_cliente = cp.id_cliente;
/*Encontrar todos los clientes de una provincia específica, por ejemplo, "Cundinamarca":*/
SELECT * FROM Cliente WHERE provincia = 'Cundinamarca';
/*Mostrar el nombre y la ciudad de los clientes junto con los detalles del plan de internet al que están suscritos:*/
SELECT c.nombre, c.ciudad, p.velocidad, p.precio, p.descuento
FROM Cliente c
JOIN ClientePlan cp ON c.id_cliente = cp.id_cliente
JOIN Plan p ON cp.id_plan = p.id_plan;
/*Obtener el número total de clientes en cada ciudad:*/
SELECT ciudad, COUNT(*) as total_clientes
FROM Cliente
GROUP BY ciudad;
/*Listar los clientes que tienen un plan de internet con una velocidad mayor a 120 Mbps:*/
SELECT c.nombre, c.apellido, p.velocidad
FROM Cliente c
JOIN ClientePlan cp ON c.id_cliente = cp.id_cliente
JOIN Plan p ON cp.id_plan = p.id_plan
WHERE p.velocidad > 120;
/*Mostrar el nombre y el descuento del plan para todos los clientes nacidos después del 1 de enero de 2010:*/
SELECT c.nombre, c.apellido, p.descuento
FROM Cliente c
JOIN ClientePlan cp ON c.id_cliente = cp.id_cliente
JOIN Plan p ON cp.id_plan = p.id_plan
WHERE c.fecha_nacimiento > '2010-01-01';
/*Encontrar los clientes que no están suscritos a ningún plan de internet:*/
SELECT c.*
FROM Cliente c
LEFT JOIN ClientePlan cp ON c.id_cliente = cp.id_cliente
WHERE cp.id_cliente IS NULL;
/*Calcular el precio promedio de los planes de internet:*/
SELECT AVG(precio) as precio_promedio
FROM Plan;