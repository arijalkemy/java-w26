INSERT INTO departamento (depto_nro, nombre_depto, localidad) 
VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) 
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000.00, 15000.00, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000.00, 0.00, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000.00, 0.00, 'D-000-1');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT e.nombre, e.puesto, d.localidad FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE e.puesto LIKE 'Vendedor'

-- Visualizar los departamentos con más de cinco empleados.

SELECT d.* FROM departamento d 
INNER JOIN empleado e ON d.depto_nro = e.depto_nro 
GROUP BY d.depto_nro 
HAVING COUNT(*) > 5

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE e.puesto LIKE (SELECT e2.puesto FROM empleado e2 WHERE e2.nombre LIKE 'Mito' AND e2.apellido LIKE 'Barchuk')

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT * FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto LIKE 'Contabilidad'
ORDER BY e.nombre

-- Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT e.nombre FROM empleado e
WHERE e.salario = (SELECT MIN(e.salario) FROM empleado e)

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT e.nombre FROM empleado e
WHERE e.salario = (SELECT MAX(e2.salario) 
					FROM empleado e2 
					INNER JOIN departamento d2 ON e2.depto_nro = d2.depto_nro
					WHERE d2.nombre_depto LIKE 'Ventas') 