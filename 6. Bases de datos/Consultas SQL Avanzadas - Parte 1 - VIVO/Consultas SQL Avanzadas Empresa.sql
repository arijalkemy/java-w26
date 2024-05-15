CREATE DATABASE empresa_practica;

CREATE TABLE departamento(
	depto_nro VARCHAR(7) PRIMARY KEY,
    nombre_depto VARCHAR(20),
    localidad VARCHAR(20)
);

CREATE TABLE empleado(
	cod_emp VARCHAR(6) PRIMARY KEY,
    nombre VARCHAR(20),
    apellido varchar(20),
    puesto varchar(20),
    fecha_alta DATE,
    salario DOUBLE,
    comision INT,
    depto_nro VARCHAR(7),
	FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);


INSERT INTO departamento (depto_nro, nombre_depto, localidad)
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
    
-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT  em.nombre ,de.nombre_depto, em.puesto, de.localidad
FROM empleado em
JOIN departamento de
ON em.depto_nro = de.depto_nro
WHERE em.puesto = 'Vendedor';

-- 2.Visualizar los departamentos con más de cinco empleados. 
SELECT de.nombre_depto, COUNT(*) AS tot_empleados
FROM empleado em
JOIN departamento de
ON em.depto_nro = de.depto_nro
GROUP BY de.nombre_depto
HAVING tot_empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre , em.salario, de.nombre_depto
FROM empleado em
JOIN departamento de
ON em.depto_nro = de.depto_nro
WHERE em.puesto = (SELECT puesto FROM empleado WHERE nombre LIKE 'Mito' AND apellido LIKE 'Barchuk')
AND nombre != 'Mito';

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.*
FROM empleado em
JOIN departamento de
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = 'Contabilidad'
ORDER BY em.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT em.nombre
FROM empleado em
ORDER BY em.salario ASC
LIMIT 1;


-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.nombre
FROM empleado em
JOIN departamento de
ON em.depto_nro = de.depto_nros
WHERE de.nombre_depto LIKE 'Ventas'
ORDER BY em.salario DESC
LIMIT 1;


