SELECT * FROM empresa_internet.cliente c LIMIT 8

SELECT * FROM empresa_internet.plan p 
WHERE p.precio < 30000

SELECT c.dni, c.ciudad FROM empresa_internet.cliente c 
WHERE c.ciudad LIKE 'Villa%'

SELECT * FROM empresa_internet.plan p 
WHERE p.descuento BETWEEN 30 and 50

SELECT p.id_plan, p.velocidad, p.precio FROM empresa_internet.plan p
WHERE p.velocidad > 500

SELECT COUNT(cp.id_plan) as 'Cant. usuarios con plan 2'  FROM empresa_internet.cliente_plan cp 
WHERE cp.id_plan = 2

INSERT INTO cliente(dni, apellido, nombre, telefono, ciudad, provincia)
VALUES ('33393288','Solis', 'Juan', '111922222', 'Boedo', 'CABA')

INSERT INTO plan(velocidad, precio, descuento)
VALUES (150,10000, 80)

UPDATE 
empresa_internet.cliente 
SET apellido = 'Bec'
WHERE cliente.dni = '39459678'

DELETE FROM empresa_internet.cliente
WHERE apellido = 'Solis'

