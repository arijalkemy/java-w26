INSERT INTO Plan (velocidad, precio, descuento) VALUES
(50, 29.99, 5.00),
(100, 39.99, 7.50),
(200, 49.99, 10.00),
(300, 59.99, 15.00),
(500, 69.99, 20.00);


INSERT INTO Cliente (dni, nombre, apellido, fechaNacimiento, provincia, ciudad, Plan_idPlan) VALUES
('12345678', 'Juan', 'Pérez', '1985-02-15', 'Buenos Aires', 'La Plata', 5),
('23456789', 'Laura', 'García', '1990-07-23', 'Córdoba', 'Córdoba', 1),
('34567890', 'Carlos', 'Fernández', '1975-03-30', 'Santa Fe', 'Rosario', 2),
('45678901', 'Alicia', 'López', '1988-11-10', 'Mendoza', 'Mendoza', 3),
('56789012', 'Mariano', 'Martínez', '1992-05-05', 'Tucumán', 'San Miguel de Tucumán',4),
('67890123', 'Carmen', 'Rojas', '1978-01-17', 'Salta', 'Salta', 5),
('78901234', 'Pablo', 'Gomez', '1967-08-19', 'Chaco', 'Resistencia', 1),
('89012345', 'Sofía', 'Torres', '1999-12-25', 'Chubut', 'Comodoro Rivadavia', 2),
('90123456', 'Lucas', 'Alvarez', '1982-09-15', 'Tierra del Fuego', 'Ushuaia', 3),
('01234567', 'Ana', 'Sánchez', '1972-04-28', 'La Pampa', 'Santa Rosa', 4);

-- PK tabla Cliente: idCliente
-- PK tabla Plan: idPlan

-- Según la solución planteada un Cliente tiene un Plan y un Plan puede ser contratado por muchos Clientes
-- Por lo que es una relación uno a muchos del Plan al Cliente.
-- La tabla Cliente tiene una FK haciendo referencia al Id del Plan.

-- Consultas 

-- 1) Mostrar todos los registros de la tabla de Plan

select * from Plan;

-- 2) Mostrar el nombre, apellido y provincia de todos los clientes

select nombre, apellido, provincia from Cliente;

-- 3) Mostrar el nombre y apellido de los clientes que hayan nacido entre 1990 y 2000

select nombre, apellido from Cliente where year(fechaNacimiento) <= 2000 and year(fechaNacimiento) >= 1990;

-- 4) Mostrar los planes ordenados por descuento en foma ascendente

select * from Plan order by descuento asc;

-- 5) Mostrar los dos primeros Clientes

select * from Cliente limit 2;

-- 6) Mostrar nombre y apellido de los clientes cuyo plan tiene id 5

select nombre, apellido from Cliente where Plan_idPlan = 5;

-- 7) Mostrar la velocidad de los planes cuyo precio se encuentra entre 30 y 50

select velocidad from Plan where precio >= 30 and precio <= 50;

-- 8) Mostrar nombre y apellido de todos los clientes ordenados por fecha de nacimiento en forma ascendente.

select nombre, apellido from Cliente order by fechaNacimiento asc;

-- 9) Mostrar nombre y apellido de todos los clientes que tienen mas de 20 años

select nombre, apellido from Cliente where fechaNacimiento <= DATE_SUB(CURRENT_DATE(), INTERVAL 20 YEAR);

-- 10) Mostrar nombre y apellido de todos los clientes que tienen entre 30 y 40 años

select nombre, apellido from Cliente where 
year(fechaNacimiento) <= DATE_SUB(CURRENT_DATE(), INTERVAL 30 YEAR)
and year(fechaNacimiento) >= DATE_SUB(CURRENT_DATE(), INTERVAL 40 YEAR);



