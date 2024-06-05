/*
Ejercicio 3
Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, 
utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:
Se solicita crear una nueva base de datos llamada “empresa_internet”.
Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
Realizar las asociaciones/relaciones correspondientes entre estos registros.
*/

-- Crear la base de datos
CREATE DATABASE empresa_internet;

-- Usar la base de datos creada
USE empresa_internet;

CREATE TABLE ciudades(
	idCiudad int(11) not null,
    nombreCiudad varchar(50) not null,
    PRIMARY KEY (idCiudad)
);

CREATE TABLE provincias (
    idProvincia int(11) NOT NULL,
    nombreProvincia varchar(50) NOT NULL,
    idCiudad int(11) NOT NULL,
    FOREIGN KEY (idCiudad) REFERENCES ciudades(idCiudad),
    PRIMARY KEY (idProvincia)
);

CREATE TABLE planesInternet(
	idPlan int(11) not null,
	velocidadMegas varchar(20) not null,
	precio double not null,
	descuento double not null,
    PRIMARY KEY(idPlan)
);

CREATE TABLE clientes (
    idCliente int(11) not null,
    numDocumento varchar(15) not null,
    primer_nombre varchar(30) not null,
    segundo_nombre varchar(30) not null,
    primer_apellido varchar(30) not null,
    segundo_apellido varchar(30) not null,
    fecha_nacimiento date not null,
    idProvincia int(11) not null,
    idPlan int(11) not null,
    FOREIGN KEY (idProvincia) REFERENCES provincias(idProvincia),
    FOREIGN KEY (idPlan) REFERENCES planesInternet(idPlan),
    PRIMARY KEY (idCliente)
);

-- //----------------------------------------------------------------
-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
INSERT INTO ciudades (idCiudad, nombreCiudad) VALUES
(1, 'Bogotá'),
(2, 'Medellín'),
(3, 'Cali'),
(4, 'Barranquilla'),
(5, 'Cartagena');

INSERT INTO provincias (idProvincia, nombreProvincia, idCiudad) VALUES
(1, 'Cundinamarca', 1),
(2, 'Antioquia', 2),
(3, 'Valle del Cauca', 3),
(4, 'Atlántico', 4),
(5, 'Bolívar', 5);

INSERT INTO planesInternet (idPlan, velocidadMegas, precio, descuento) VALUES
(1, '50 Mbps', 29.99, 0),
(2, '100 Mbps', 49.99, 0),
(3, '200 Mbps', 69.99, 0),
(4, '500 Mbps', 99.99, 0),
(5, '1 Gbps', 149.99, 0);

INSERT INTO clientes (idCliente, numDocumento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, idProvincia, idPlan) VALUES
(1, '123456789', 'Juan', '', 'Pérez', 'Gómez', '1990-05-15', 1, 2),
(2, '987654321', 'María', '', 'González', 'López', '1985-10-20', 2, 3),
(3, '456789123', 'Carlos', '', 'Martínez', 'Ramírez', '1988-07-03', 3, 4),
(4, '789123456', 'Laura', '', 'Sánchez', 'Díaz', '1995-02-12', 4, 1),
(5, '321654987', 'Pedro', '', 'García', 'Hernández', '1983-11-30', 5, 5);

INSERT INTO clientes (idCliente, numDocumento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, idProvincia, idPlan) VALUES
(6, '135792468', 'Ana', '', 'Rodríguez', 'Gómez', '1992-08-25', 1, 2),
(7, '246813579', 'David', '', 'López', 'Martínez', '1980-04-10', 2, 3),
(8, '951357246', 'Sofía', '', 'Hernández', 'Sánchez', '1998-03-17', 3, 4),
(9, '357924681', 'Diego', '', 'González', 'Díaz', '1994-12-08', 4, 1),
(10, '579246813', 'Julia', '', 'Martínez', 'García', '1987-06-29', 5, 5);

-- Ejercicio 4 Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

-- 1. Consultar todos los clientes registrados:
SELECT * FROM clientes;

-- 2 Consultar los clientes ordenados por apellido en orden ascendente:
SELECT * FROM clientes ORDER BY primer_apellido ASC, segundo_apellido ASC;

-- 3 Contar el número total de clientes registrados:
SELECT COUNT(*) AS total_clientes FROM clientes;

-- 4 Consultar los clientes nacidos después de 1990:
SELECT * FROM clientes WHERE YEAR(fecha_nacimiento) > 1990;

-- 5 Consultar los clientes que pertenecen a la ciudad de Bogotá:
SELECT * FROM clientes c
	JOIN provincias p ON c.idProvincia = p.idProvincia 
		JOIN ciudades ci ON p.idCiudad = ci.idCiudad 
			WHERE ci.nombreCiudad = 'Bogotá';
            
-- 6 Consultar los clientes que tienen un descuento en su plan de internet:
SELECT * FROM clientes c
	JOIN planesInternet p ON c.idPlan = p.idPlan 
		WHERE p.descuento > 0;

-- 7 Consultar los clientes que tienen un nombre que comienza con 'J':
SELECT * FROM clientes WHERE primer_nombre LIKE 'J%';

-- 8 Consultar la información de los clientes junto con la velocidad de su plan de internet:
SELECT c.*, p.velocidadMegas 
	FROM clientes c
		JOIN planesInternet p ON c.idPlan = p.idPlan;

-- 9 Consultar la cantidad de clientes por provincia:
SELECT p.nombreProvincia, COUNT(*) AS cantidad_clientes 
	FROM clientes c
		JOIN provincias p ON c.idProvincia = p.idProvincia 
			GROUP BY p.nombreProvincia;
 
-- 10 Consultar los clientes que tienen el nombre 'María' y el apellido 'González':
SELECT * FROM clientes WHERE primer_nombre = 'María' AND primer_apellido = 'González';







