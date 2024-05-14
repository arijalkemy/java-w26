USE Ejercicio_SQL_Avanzado;

CREATE TABLE departamento (
	depto_nro VARCHAR(10) NOT NULL,
    nombre_depto VARCHAR(20),
    localidad VARCHAR(20),
	PRIMARY KEY (depto_nro)
);


CREATE TABLE empleado (
	cod_empleado VARCHAR(10) NOT NULL,
    nombre VARCHAR(20),
    apellido VARCHAR(15),
    puesto VARCHAR(20),
    fecha_alta DATE,
    salario FLOAT,
    comision FLOAT,
    depto_nro VARCHAR(10) NOT NULL,
    PRIMARY KEY (cod_empleado),
    CONSTRAINT depto_nro FOREIGN KEY (depto_nro) REFERENCES departamento (depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES
    ('D-000-1', 'Software', 'Los Tigres'),
    ('D-000-2', 'Sistemas', 'Guadalupe'),
    ('D-000-3', 'Contabilidad', 'La Roca'),
    ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
    ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
    ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
    ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
    ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
    ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
    
/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

/*Visualizar los departamentos con más de cinco empleados.*/
SELECT d.depto_nro, d.nombre_depto, COUNT(e.cod_empleado) AS num_empleados
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro, d.nombre_depto
HAVING COUNT(e.cod_empleado) > 5;

/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
INSERT INTO empleado (cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
    ('E-0008', 'Mito', 'Barchuk', 'Vendedor', '2014-06-05', 190000, 0, 'D-000-3');
    
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.cod_empleado IN 
(SELECT cod_empleado
FROM empleado
WHERE nombre = 'Mito' AND apellido = 'Barchuk');

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre..*/
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad' ORDER BY e.nombre;

/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT e.nombre
FROM empleado e
ORDER BY e.salario
LIMIT 1;

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;