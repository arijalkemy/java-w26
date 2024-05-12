-- Selección de la base de datos
USE empresa_internet;

-- Creación de la tabla clientes
CREATE TABLE clientes (
    dni VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);

-- Creación de la tabla planes_internet
CREATE TABLE planes_internet (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    velocidad_megas INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);

-- Inserción de 10 registros en la tabla clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES
('11111111A', 'Juan', 'Gómez', '1990-05-20', 'Madrid', 'Madrid'),
('22222222B', 'María', 'López', '1985-10-15', 'Barcelona', 'Barcelona'),
('33333333C', 'Pedro', 'Martínez', '1988-12-30', 'Valencia', 'Valencia'),
('44444444D', 'Laura', 'Fernández', '1995-03-25', 'Sevilla', 'Sevilla'),
('55555555E', 'Carlos', 'Ruiz', '1980-08-10', 'Málaga', 'Málaga'),
('66666666F', 'Ana', 'Pérez', '1992-07-05', 'Alicante', 'Alicante'),
('77777777G', 'David', 'García', '1983-09-12', 'Zaragoza', 'Zaragoza'),
('88888888H', 'Elena', 'Sánchez', '1998-11-08', 'Murcia', 'Murcia'),
('99999999I', 'Javier', 'Díaz', '1987-04-17', 'Bilbao', 'Bilbao'),
('10101010J', 'Raquel', 'Jiménez', '1993-06-29', 'Granada', 'Granada');

-- Inserción de 5 registros en la tabla planes_internet
INSERT INTO planes_internet (velocidad_megas, precio, descuento) VALUES
(50, 30.00, 0.00),
(100, 45.00, 5.00),
(200, 60.00, 10.00),
(300, 75.00, 15.00),
(500, 90.00, 20.00);


-- Agregar columna id_plan a la tabla clientes
ALTER TABLE clientes ADD COLUMN id_plan INT;

-- Asignar un plan de Internet a cada cliente
UPDATE clientes SET id_plan = 1 WHERE dni = '11111111A';
UPDATE clientes SET id_plan = 2 WHERE dni = '22222222B';
UPDATE clientes SET id_plan = 3 WHERE dni = '33333333C';
UPDATE clientes SET id_plan = 4 WHERE dni = '44444444D';
UPDATE clientes SET id_plan = 5 WHERE dni = '55555555E';
UPDATE clientes SET id_plan = 1 WHERE dni = '66666666F';
UPDATE clientes SET id_plan = 2 WHERE dni = '77777777G';
UPDATE clientes SET id_plan = 3 WHERE dni = '88888888H';
UPDATE clientes SET id_plan = 4 WHERE dni = '99999999I';
UPDATE clientes SET id_plan = 5 WHERE dni = '10101010J';

-- Añadir la restricción de clave externa (foreign key) para la columna id_plan en la tabla clientes
ALTER TABLE clientes ADD CONSTRAINT fk_id_plan FOREIGN KEY (id_plan) REFERENCES planes_internet(id_plan);

-- Mostrar todos los clientes de madrid
SELECT * FROM clientes WHERE provincia = 'Madrid';
-- Mostrar plan de toddos los clientes
SELECT c.nombre, p.velocidad_megas FROM clientes c, planes_internet p WHERE c.id_plan = p.id_plan;
-- Contar cuantos clientes hay en cada provincia
SELECT provincia, COUNT(*) AS cantidad_clientes
FROM clientes
GROUP BY provincia;
-- Cliente mas joven
SELECT *
FROM clientes
ORDER BY fecha_nacimiento DESC
LIMIT 1;
-- Calcular el precio total de todos los planes de Internet sin aplicar descuento:
SELECT SUM(precio) AS precio_total_sin_descuento
FROM planes_internet;
-- Listar los clientes que tienen un descuento en su plan de Internet:
SELECT c.nombre, c.apellido
FROM clientes c, planes_internet p
WHERE c.id_plan = p.id_plan AND p.descuento > 0;
-- Encontrar los planes de Internet que ofrecen una velocidad superior a 200 megas:
SELECT *
FROM planes_internet
WHERE velocidad_megas > 200;
-- Mostrar el nombre y la velocidad del plan de Internet contratado por un cliente específico:
SELECT c.nombre, p.velocidad_megas
FROM clientes c, planes_internet p
WHERE c.id_plan = p.id_plan AND c.dni = '11111111A';
-- Calcular el precio medio de los planes de Internet con descuento:
SELECT AVG(precio) AS precio_medio_con_descuento
FROM planes_internet
WHERE descuento > 0;
-- Encontrar los clientes que tienen el mismo plan contratado:
SELECT id_plan, COUNT(*) AS cantidad_clientes
FROM clientes
GROUP BY id_plan
HAVING COUNT(*) > 1;
