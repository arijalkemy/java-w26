-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d ON (e.depto_nro=d.depto_nro);

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, d.localidad, COUNT(e.cod_emp) AS cantidad_empleados
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d ON (e.depto_nro=d.depto_nro)
group by d.depto_nro
HAVING cantidad_empleados> 2; #pide 5 pero la tabla solo hay con mayor a 3

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d ON (e.depto_nro=d.depto_nro)
WHERE e.puesto IN (SELECT puesto FROM EMPLEADO WHERE nombre="mito" AND apellido="Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM EMPLEADO e INNER JOIN DEPARTAMENTO d ON (e.depto_nro=d.depto_nro)
WHERE d.nombre_depto="contabilidad"
order by e.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, e.salario 
FROM EMPLEADO e
WHERE e.salario=(SELECT MIN(e1.salario)FROM EMPLEADO e1) LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision
FROM EMPLEADO e
WHERE e.salario= (SELECT MAX(e1.salario)
					FROM EMPLEADO e1 INNER JOIN DEPARTAMENTO d ON (e1.depto_nro=d.depto_nro) 
					WHERE d.nombre_depto="Ventas") LIMIT 1;