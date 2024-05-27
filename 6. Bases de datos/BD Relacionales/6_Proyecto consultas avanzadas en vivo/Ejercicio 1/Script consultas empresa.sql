-- CONSULTAS

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT  e.nombre nombre_empleado, e.puesto Cargo, d.localidad localidad 
FROM EMPLEADO e 
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro; 


-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto departamento, COUNT(e.cod_emp) empleados  
FROM DEPARTAMENTO d 
JOIN EMPLEADO e ON e.depto_nro = d.depto_nro 
GROUP BY departamento
HAVING empleados >= 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT  e.nombre empleado, e.salario salario, d.nombre_depto departamento
FROM EMPLEADO e 
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro 
WHERE e.puesto = 
(SELECT e2.puesto FROM EMPLEADO e2 WHERE e2.nombre LIKE 'Mito' AND e2.apellido LIKE 'Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT *
FROM EMPLEADO e 
JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro 
WHERE d.nombre_depto LIKE 'Contabilidad'
ORDER BY e.nombre; 

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre nombre, e.apellido apellido
FROM EMPLEADO e 
JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro 
WHERE e.salario = (SELECT MIN(e2.salario)  from EMPLEADO e2);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM EMPLEADO e 
JOIN DEPARTAMENTO d ON d.depto_nro = e.depto_nro 
WHERE d.nombre_depto LIKE 'Ventas' AND 
e.salario = (
	SELECT MAX(salario) 
	from EMPLEADO 
	WHERE depto_nro = d.depto_nro 
);