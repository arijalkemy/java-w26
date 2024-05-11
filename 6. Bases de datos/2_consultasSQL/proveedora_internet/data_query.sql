# Ejercicio 4

# 10 Consultas sencillas (sin joins)

SELECT name from empresa_internet.clients;

SELECT name, birthDate FROM empresa_internet.clients WHERE birthDate < "1999-01-01";

SELECT * from empresa_internet.internet_plans WHERE discount < 10;

SELECT speed, clientId  FROM empresa_internet.internet_plans WHERE clientId  = 12;

SELECT speed, discount, clientId  FROM empresa_internet.internet_plans WHERE clientId  = 20;

SELECT DISTINCT speed FROM empresa_internet.internet_plans;

SELECT DISTINCT city FROM empresa_internet.clients;

SELECT clientId, price, discount FROM empresa_internet.internet_plans WHERE price < 37000.5;

SELECT * FROM empresa_internet.internet_plans ORDER BY speed ASC;

SELECT name, surname FROM empresa_internet.clients LIMIT 2;

# Extra
SELECT name, surname, speed, empresa_internet.clients.clientId, price
FROM empresa_internet.clients
INNER JOIN empresa_internet.internet_plans
ON empresa_internet.internet_plans.clientId  = empresa_internet.clients.clientId ;