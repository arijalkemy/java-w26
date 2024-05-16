-- 1. Creacion de la base de datos 
CREATE DATABASE Empleados; 

USE Empleados;

CREATE TABLE Departamento(
	depto_nro VARCHAR(120) PRIMARY KEY NOT NULL, 
    nombre_depto VARCHAR(120) NOT NULL, 
    localidad VARCHAR(120) NOT NULL
);

CREATE TABLE Empleado (
	cod_emp VARCHAR (100) PRIMARY KEY NOT NULL,
	nombre VARCHAR (100) NOT NULL,
	apellido VARCHAR (100) NOT NULL,
	puesto VARCHAR (100) NOT NULL,
	fecha_alta VARCHAR (100) DEFAULT (01/01/2014) NOT NULL,
	salario INTEGER NOT NULL,
	comision INTEGER NOT NULL,
	depto_nro VARCHAR (120) NOT NULL,
    FOREIGN KEY (depto_nro) REFERENCES Departamento(depto_nro)
); 

-- 2. Inseracion de valores 
INSERT INTO Departamento (depto_nro, nombre_depto, localidad)
VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO Empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- 3. Queries 
    -- 3.1: Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. 
    SELECT nombre, puesto, localidad FROM empleado 
    JOIN departamento ON empleado.depto_nro = departamento.depto.nro
    WHERE departamento.nombre_depto LIKE "Ventas";   

    -- 3.2: Visualizar los departamentos con más de cinco empleados.
    SELECT d.nombre_depto, COUNT(*) FROM empleado e
    JOIN departamento d  ON e.depto_nro = d.depto_nro
    GROUP BY d.nombre_depto
    HAVING COUNT(*) >= 3;

    -- 3.3: Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
    SELECT e.nombre, e.salario, d.nombre_depto AS depto
    FROM Empleado AS e
    INNER JOIN Departamento AS d ON e.depto_nro = d.depto_nro
    WHERE e.puesto = (SELECT puesto FROM Empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

    -- 3.4: Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
    SELECT * FROM empleado 
    JOIN departamento ON empleado.depto_nro = departamento.depto_nro
    WHERE Departamento.nombre_depto LIKE 'Contabilidad' ORDER BY empleado.nombre DESC; 

    -- 3.5: Mostrar el nombre del empleado que tiene el salario más bajo.
    SELECT e.nombre, MIN(e.salario) as min_sal
    FROM empleado e
    GROUP BY e.nombre
    ORDER BY min_sal ASC
    LIMIT 1;

    -- 3.6: Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
    SELECT e.*
    FROM Empleado AS e
    INNER JOIN Departamento AS b
    ON e.depto_nro = b.depto_nro
    WHERE b.nombre_depto = 'Ventas'
    AND e.salario = (SELECT MAX(salario) FROM Empleado WHERE depto_nro = b.depto_nro);

