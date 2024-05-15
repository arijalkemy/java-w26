/*Obtener el nombre de los clientes que dieron de alta un plan en el mes de mayo*/
SELECT c.nombre, c.apellido 
FROM ClientePlan cp, Cliente c 
WHERE cp.id_cliente = c.id 
AND cp.fecha_alta >= "2024-05-01 00:00:00";

/*Obtener el nombre de los clientes de Rafaela*/
SELECT c.nombre , c.apellido 
FROM Cliente c 
WHERE c.ciudad = "Rafaela";

/*Obtener el nombre y ciudad de los clientes que tienen el plan mas alto*/
SELECT c.nombre , c.ciudad 
FROM ClientePlan cp, Cliente c , Plan p 
WHERE p.id = cp.id_plan AND p.id = 5 AND c.Id = cp.id;

/*Obtener informacion de los planes vigentes*/
SELECT p.nombre, p.velocidad , p.precio , p.descuento 
FROM Plan p;

/*Obtener el nombre de los clientes que no tienen un plan de alta*/
SELECT *
FROM Cliente c 
WHERE c.Id  NOT IN (
	SELECT c.Id 
	FROM ClientePlan cp 
	WHERE cp.id_cliente = c.Id 
)

/*Obtener los clientes que tienen 2 planes o mas*/
SELECT cp.id_cliente, c.nombre 
FROM ClientePlan cp 
JOIN Cliente c ON cp.id_cliente = c.Id 
		AND cp.fecha_baja IS NULL 
GROUP BY cp.id_cliente 
HAVING COUNT(*) > 1;


/*Obtener la cantidad de planes activos*/
SELECT COUNT(*) AS "Cantidad de planes activos" 
FROM ClientePlan cp 
WHERE cp.fecha_baja IS NULL;

/*Obtener la cantidad de planes que se dieron de baja en mayo*/
SELECT COUNT(*) AS "Cantidad de planes de baja en mayo" 
FROM ClientePlan cp 
WHERE cp.fecha_baja > "2024-05-01 00:00:00";


/*Obtener los precios finales de cada plan*/
SELECT p.nombre, p.precio * (0.01 * (100-p.descuento)) AS "Precio final"
FROM Plan p;

/*Obtener el monto a pagar de cada cliente por mes*/
SELECT cp.id_cliente, SUM(p.precio * (0.01 * (100-p.descuento))) AS "Precio a pagar"
FROM ClientePlan cp 
JOIN Plan p ON cp.id_plan  = p.id 
WHERE cp.fecha_baja IS NULL 
GROUP BY cp.id_cliente 





