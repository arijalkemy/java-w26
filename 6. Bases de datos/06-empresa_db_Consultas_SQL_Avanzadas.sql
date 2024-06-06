CREATE DATABASE IF NOT EXISTS empresa_db;
use empresa_db;

CREATE TABLE departamento (
  depto_nro CHAR(7) PRIMARY KEY,
  nombre_depto VARCHAR(25),
  localidad VARCHAR(25)
);

CREATE TABLE empleado (
  cod_emp CHAR(6) PRIMARY KEY,
  nombre VARCHAR(25),
  apellido VARCHAR(25),
  puesto VARCHAR(25),
  fecha_alta DATE,
  salario DECIMAL(10,2),
  comision DECIMAL(10,2),
  depto_nro CHAR(7) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES
  ('D-000-1', 'Software', 'Los Tigres'),
  ('D-000-2', 'Sistemas', 'Guadalupe'),
  ('D-000-3', 'Contabilidad', 'La Roca'),
  ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
  ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
  ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
  ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
  ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
  ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
  ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
  ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad
FROM departamento
JOIN empleado
ON departamento.depto_nro=empleado.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT departamento.nombre_depto, COUNT(*) AS num_empleados
FROM departamento
JOIN empleado ON departamento.depto_nro = empleado.nombre_depto
GROUP BY departamento.nombre_depto
HAVING COUNT(*) >= 3;


-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT nombre, salario, nombre_depto
FROM empleado
JOIN departamento
WHERE puesto = (SELECT puesto FROM empleado WHERE nombre = "Mito Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT *
FROM empleado
WHERE depto_nro=(SELECT depto_nro FROM departamento WHERE nombre_depto = "contabilidad");

-- Mostar el nombre del empleado que tenga el salario mas bajo
SELECT nombre
FROM empleado
ORDER BY salario
ASC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre
FROM empleado
WHERE depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto="Ventas")
ORDER BY salario
DESC
LIMIT 1;
