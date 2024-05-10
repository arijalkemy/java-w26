USE empresa_internet;

INSERT INTO `Cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`)
VALUES
('12345678A', 'Juan', 'García', '1990-03-15', 'Madrid', 'Madrid'),
('98765432B', 'María', 'López', '1985-07-20', 'Barcelona', 'Barcelona'),
('45678901C', 'Pedro', 'Martínez', '1988-05-10', 'Valencia', 'Valencia'),
('78901234D', 'Ana', 'Fernández', '1995-11-25', 'Sevilla', 'Sevilla'),
('23456789E', 'Luis', 'Gómez', '1979-09-05', 'Málaga', 'Málaga'),
('89012345F', 'Elena', 'Rodríguez', '1983-12-30', 'Alicante', 'Alicante'),
('56789012G', 'Pablo', 'Sánchez', '1992-02-18', 'Murcia', 'Murcia'),
('01234567H', 'Laura', 'Pérez', '1980-06-12', 'Granada', 'Granada'),
('34567890I', 'Carlos', 'Hernández', '1987-04-03', 'Cádiz', 'Cádiz'),
('67890123J', 'Sofía', 'Díaz', '1998-08-08', 'Bilbao', 'Vizcaya');

SELECT * FROM cliente;

INSERT INTO `PlanInternet` (`identificacion`, `velocidadMB`, `precio`, `descuento`)
VALUES
('Plan06', 300, 44.50, 10),
('Plan07', 600, 54.75, 15),
('Plan08', 1200, 64.25, 20),
('Plan09', 2500, 74.12, 25),
('Plan10', 5000, 84.38, 30);

SELECT * FROM planinternet;

INSERT INTO `Contratacion` (`PlanInternet_id_planInternet`, `Cliente_id_cliente`)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9), 
(5, 10); 

-- Obtener todos los clientes con su provincia y ciudad

SELECT nombre, apellido, provincia, ciudad FROM cliente;

-- Obtener todos los planes de internet junto con su velocidad y precio

SELECT identificacion, velocidadMB, precio from planinternet;

-- Obtener la cantidad de clientes en cada provincia

SELECT provincia, COUNT(*) as 'Numero de clientes de la provincia' FROM cliente
GROUP BY provincia;

-- Calcular el precio promedio de los planes de internet

SELECT identificacion, AVG(precio) as 'Promedio precio por plan' FROM planinternet
GROUP BY identificacion;

-- Encontrar el plan de internet más caro

SELECT * FROM planinternet ORDER BY precio DESC LIMIT 1;

-- Encontrar el plan de internet más barato

SELECT * FROM planinternet ORDER BY precio ASC LIMIT 1;

-- Calcular el número total de contrataciones realizadas

SELECT COUNT(*) as 'Total contrataciones' FROM contratacion;

-- Encontrar los clientes que contrataron un plan específico

SELECT id_contratacion, nombre, apellido, identificacion FROM contratacion 
JOIN cliente on id_cliente = Cliente_id_cliente
JOIN planinternet on id_planinternet = planinternet_id_planinternet
WHERE identificacion = 'Plan06';

-- Obtener todos los datos de la contratacion del plan de internet ordenado descendentemente por el precio

SELECT id_contratacion, nombre, apellido, identificacion, velocidadMB, precio, descuento FROM contratacion 
JOIN cliente on id_cliente = Cliente_id_cliente
JOIN planinternet on id_planinternet = planinternet_id_planinternet
ORDER BY precio DESC;

-- Encontrar los clientes que contrataron planes de internet con una velocidad superior a 1000MB

SELECT id_contratacion, nombre, apellido, identificacion, velocidadMB FROM contratacion 
JOIN cliente on id_cliente = Cliente_id_cliente
JOIN planinternet on id_planinternet = planinternet_id_planinternet
WHERE velocidadMB > 1000;




