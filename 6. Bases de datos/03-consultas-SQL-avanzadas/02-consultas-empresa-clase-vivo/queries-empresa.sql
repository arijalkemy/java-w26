INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT nombre_depto, puesto, localidad FROM empleado ep
JOIN departamento dp ON dp.depto_nro = ep.depto_nro
WHERE puesto LIKE '%Vendedor%';

-- 2. Visualizar los departamentos con más de cinco empleados.

SELECT nombre_depto, count(*) AS numeroEmpleados FROM departamento dp
JOIN empleado ep ON dp.depto_nro = ep.depto_nro
GROUP BY dp.depto_nro
HAVING numeroEmpleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT nombre, salario, nombre_depto FROM empleado ep
JOIN departamento dp ON dp.depto_nro = ep.depto_nro
WHERE ep.puesto = (
	SELECT puesto FROM empleado 
    WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT nombre, apellido, puesto, nombre_depto FROM empleado ep
JOIN departamento dp ON dp.depto_nro = ep.depto_nro
WHERE nombre_depto = 'contabilidad'
ORDER BY nombre; 

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT nombre, apellido FROM empleado
ORDER BY salario
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT nombre, apellido, salario, nombre_depto FROM empleado ep
JOIN departamento dp ON dp.depto_nro = ep.depto_nro
WHERE nombre_depto = 'ventas'
ORDER BY salario DESC
LIMIT 1;