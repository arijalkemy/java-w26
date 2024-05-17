CREATE DATABASE empresa_internet;
use empresa_internet;

CREATE TABLE planes_internet(
	id INT PRIMARY KEY,
    megas INT NOT NULL,
    precio FLOAT NOT NULL,
    descuento FLOAT NOT NULL
);

CREATE TABLE clientes(
	id INT PRIMARY KEY,
	dni VARCHAR(25),
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    ciudad VARCHAR (20) NOT NULL,
    planId INT,
    
    FOREIGN KEY (planId) REFERENCES planes_internet(id)
);

INSERT INTO planes_internet (id, megas, precio, descuento) VALUES
(1, 100, 29.99, 5.00),
(2, 150, 34.99, 2.50),
(3, 200, 39.99, 0.00),
(4, 250, 44.99, 7.50),
(5, 300, 49.99, 10.00);

INSERT INTO clientes (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, planId) VALUES
(1, '40222111X', 'Juan', 'Pérez', '1990-05-15', 'Madrid', 'Madrid', 1),
(2, '40222112X', 'Ana', 'Martínez', '1985-07-20', 'Barcelona', 'Barcelona', 2),
(3, '40222113X', 'Luis', 'Gómez', '1970-01-25', 'Valencia', 'Valencia', 3),
(4, '40222114X', 'Sofía', 'López', '1995-04-12', 'Sevilla', 'Sevilla', 4),
(5, '40222115X', 'Carlos', 'Hernández', '1965-08-30', 'Zaragoza', 'Zaragoza', 5),
(6, '40222116X', 'Lucía', 'Morales', '1978-11-11', 'Málaga', 'Málaga', 1),
(7, '40222117X', 'Francisco', 'Navarro', '1988-10-05', 'Murcia', 'Murcia', 2),
(8, '40222118X', 'Beatriz', 'Romero', '1992-03-15', 'Palma de Mallorca', 'Palma', 3),
(9, '40222119X', 'Antonio', 'Torres', '1980-12-22', 'Las Palmas', 'Las Palmas', 4),
(10, '40222120X', 'Marta', 'Sánchez', '1999-06-01', 'Bilbao', 'Bilbao', 5);

-- a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
-- La tabla clientes tiene como primary key un id de tipo int ya que si definiamos el dni como primary key tendríamos problemas con
-- la diferencia entre paises sobre el manejo de los dnis


-- b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta
-- La tabla planes de internet tiene como primary key un id de tipo int ya que no habia un identificador mejor para ser su primary key


-- c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key?
-- ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta
-- En este caso hicimos una relación uno a muchos sobre que un plan de internet puede tener muchos clientes y un cliente puede tener solo un plan de internet
-- Debido a esto, tenemos nuestra foreign key en la tabla clientes referenciando al id de la tabla planes de internet para poder asignar un plan cada vez que agregamos un cliente



-- Obtener todos los clientes
SELECT *
FROM clientes;

-- Obtener los clientes de una ciudad específica
SELECT nombre, apellido, ciudad
FROM clientes
WHERE ciudad = 'Madrid';

-- Encontrar clientes cuyo apellido comience con 'L'
SELECT nombre, apellido
FROM clientes
WHERE apellido LIKE 'L%';

-- Encontrar los clientes nacidos antes de 1980
SELECT nombre, apellido, fecha_nacimiento
FROM clientes
WHERE fecha_nacimiento < '1980-01-01';

-- Contar cuántos clientes hay en cada ciudad:
SELECT ciudad, COUNT(*) AS NumeroDeClientes
FROM clientes
GROUP BY ciudad;


-- Obtener todos los clientes con sus planes asociados:
SELECT c.nombre, c.apellido, p.megas, p.precio
FROM clientes c
JOIN planes_internet p ON c.planId = p.id;

-- Obtener todos los planes registrados
SELECT *
FROM planes_internet;

-- Buscar los planes con un descuento superior a 5 
SELECT id, megas, precio
FROM planes_internet
WHERE descuento > 5.00;

-- Obtener el promedio de precio de los planes de internet
SELECT AVG(precio) AS PrecioPromedio
FROM planes_internet;

-- Encontrar el plan de internet más barato disponible
SELECT id, megas, precio, descuento
FROM planes_internet
ORDER BY precio ASC
LIMIT 1;

