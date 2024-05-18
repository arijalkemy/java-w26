/*
	Ejercicio integrador - SQL Avanzado VIVO 1
*/

-- 1: Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad
FROM empleado LEFT JOIN departamento 
ON departamento.depto_nro = empleado.depto_nro
WHERE empleado.puesto LIKE 'Vendedor%';

-- 2: Visualizar los departamentos con más de un empleados.
SELECT nombre_depto as 'Nombre Departamento', COUNT(*) AS total
FROM departamento LEFT JOIN empleado
ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.depto_nro
HAVING total > 1; -- Mayor a uno para que devuelva un resultado

-- 3: Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Jonathan Aguilera’.
SELECT nombre, salario, nombre_depto
FROM empleado LEFT JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto IN (
	SELECT puesto FROM empleado WHERE nombre = 'Jonathan' AND apellido = 'Aguilera'
    ); -- Se cambia a Jonathan Aguilera ya que hay varios vendedores pero no presidentes

-- 4: Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, empleado.depto_nro, nombre_depto, localidad
FROM empleado LEFT JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto LIKE 'Contabilidad%'
ORDER BY nombre DESC;

-- 5: Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleado
WHERE empleado.salario = (SELECT MIN(salario) FROM empleado);

-- 6: Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT MAX(salario) as total FROM empleado
WHERE nombre IN (
	SELECT nombre FROM empleado LEFT JOIN departamento
    ON empleado.depto_nro = departamento.depto_nro
    WHERE departamento.nombre_depto LIKE 'Ventas%'
    );
