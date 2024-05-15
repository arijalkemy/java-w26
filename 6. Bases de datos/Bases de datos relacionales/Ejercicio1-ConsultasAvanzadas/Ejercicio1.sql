/* Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */

SELECT e.nombre, e.puesto, d.localidad  
FROM Departamento d 
INNER JOIN Empleado e ON e.depto_nro = d.depto_nro 
WHERE e.puesto = 'Vendedor'

/* Visualizar los departamentos con más de cinco empleados. */

SELECT d.nombre_depto
FROM Departamento d 
INNER JOIN Empleado e ON e.depto_nro = d.depto_nro 
GROUP BY d.nombre_depto 
HAVING COUNT(e.cod_emp) > 5

/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */

SELECT e.nombre, e.salario, d.nombre_depto  
FROM Departamento d 
INNER JOIN Empleado e ON e.depto_nro = d.depto_nro 
WHERE e.puesto = (SELECT puesto
					FROM Empleado 
					WHERE nombre = 'Mito' AND 
							apellido =  'Barchuk')

/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */

SELECT CONCAT(e.nombre, ' ',e.apellido) as nombre_apellido
FROM Empleado e 
WHERE e.depto_nro = (SELECT depto_nro
						FROM Departamento
						WHERE nombre_depto LIKE 'Contabilidad')
ORDER BY nombre_apellido ASC

/* Mostrar el nombre del empleado que tiene el salario más bajo. */

SELECT CONCAT(e.nombre, ' ',e.apellido) as nombre_apellido
FROM Empleado e 
ORDER BY e.salario
LIMIT 1

/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */

SELECT CONCAT(e.nombre, ' ',e.apellido) as nombre_apellido
FROM Empleado e 
WHERE e.depto_nro = (SELECT depto_nro
						FROM Departamento
						WHERE nombre_depto LIKE 'Ventas')
ORDER BY e.salario DESC
LIMIT 1