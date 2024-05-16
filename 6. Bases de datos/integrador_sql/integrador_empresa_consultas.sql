-- 1. Seleccionar todos los clientes
SELECT nombre, apellido, email
FROM cliente;

-- 2. Seleccionar todos los planes
SELECT * FROM plan;

-- 3. Seleccionar clientes cuyo apellido termine en z
SELECT nombre, apellido, email
FROM cliente
WHERE apellido LIKE '%Z';

-- 4. Top 3 de planes con mayor velocidad en megas
SELECT * FROM plan
ORDER BY velocidad DESC
LIMIT 3;

-- 5. Top 1 de planes con menor precio
SELECT * FROM plan
ORDER BY precio ASC
LIMIT 1;

-- 6. Seleccionar clientes cuya dirección incluya la palabra calle
SELECT nombre, apellido, direccion, email
FROM cliente
WHERE direccion LIKE 'Calle%';

-- 7. Seleccionar planes de manera ascendente
SELECT * FROM plan
ORDER BY precio ASC;

-- 8. Seleccionar planes de manera descendente
SELECT * FROM plan
ORDER BY precio DESC;

-- 9. Seleccionar planes de manera ascendente
SELECT * FROM plan
ORDER BY velocidad ASC;

-- 10. Seleccionar planes de manera ascendente
SELECT * FROM plan
ORDER BY velocidad DESC;
