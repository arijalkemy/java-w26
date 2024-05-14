-- Consulta los clientes totales
SELECT * from client;

-- Consulta los planes totales
select * FROM plan;

-- Consulta los clientes de la provincia de BA
select * from client where province = 'Buenos Aires';

-- Consulta los planes con velocidad mayor o igual a 150 megas
SELECT * from plan where velocity >= 150;

-- Consulta los planes de manera ordenada desc por precio
SELECT * from plan order by price DESC;

-- Consulta los planes que no tienen descuento
SELECT * from plan where discount = 0;

-- Consulta los clientes de la ciudad de quilmes
SELECT * from client where city = 'Quilmes';

-- Consulta los clientes ordenados por apellido de manera asc
SELECT * FROM  client order by last_name;

-- Consulta los clientes de apellido lopez
SELECT * from client where last_name = 'López';

-- Consulta los clientes que su identificador por cliente, este entre 7 y 10
SELECT * from client where client_id BETWEEN 7 and 10

