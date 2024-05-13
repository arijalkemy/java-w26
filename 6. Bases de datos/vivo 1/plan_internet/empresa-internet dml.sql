SELECT * FROM cliente;
SELECT * FROM plan;
SELECT * FROM plan_cliente;

SELECT c.idCliente, c.nombre, c.apellido, p.idplan, p.velocidad, p.precio, p.descuento
FROM cliente c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON pc.idPlan = p.idplan;

SELECT c.idCliente, c.nombre, c.apellido, p.idplan, p.velocidad, p.precio, p.descuento
FROM cliente c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON pc.idPlan = p.idplan WHERE p.velocidad > 50;

SELECT c.idCliente, c.nombre, c.apellido, p.idplan, p.velocidad, p.precio, p.descuento
FROM cliente c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON pc.idPlan = p.idplan WHERE p.velocidad > 50 AND p.precio < 150;

SELECT c.nombre, p.velocidad
FROM cliente AS c
    INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
    INNER JOIN plan p ON p.idPlan = pc.idPlan;

SELECT c.nombre, p.velocidad
FROM cliente AS c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON p.idPlan = pc.idPlan
WHERE c.nombre LIKE '%a';

SELECT c.nombre, p.velocidad
FROM cliente AS c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON p.idPlan = pc.idPlan
WHERE c.nombre NOT LIKE '%a%';

SELECT c.nombre, p.precio, p.descuento
FROM cliente AS c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON p.idPlan = pc.idPlan
WHERE (p.precio - p.descuento) < 120;

SELECT AVG(p.precio) AS precio_promedio, AVG(p.descuento) AS descuento_promedio, AVG(p.velocidad) AS velocidad_promedio
FROM plan p;

SELECT AVG(p.precio) AS precio_promedio, AVG(p.descuento) AS descuento_promedio, AVG(p.velocidad) AS velocidad_promedio
FROM cliente AS c
         INNER JOIN plan_cliente pc ON c.idCliente = pc.idCliente
         INNER JOIN plan p ON p.idPlan = pc.idPlan;
