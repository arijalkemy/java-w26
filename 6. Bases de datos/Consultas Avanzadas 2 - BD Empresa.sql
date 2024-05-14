#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.apellido, d.localidad FROM Empleado e 
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro;

#Visualizar los departamentos con mas de cinco empleados
SELECT d.nombre_depto FROM Departamento d 
INNER JOIN Empleado e ON d.depto_nro = e.depto_nro 
GROUP BY d.nombre_depto HAVING COUNT(*) > 5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM Empleado e 
INNER JOIN Departamento d on e.depto_nro = d.depto_nro 
WHERE e.puesto = (SELECT puesto FROM Empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk')
AND e.nombre <> 'Mito' AND e.apellido <> 'Barchuk';

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM Empleado e 
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Contabilidad' 
ORDER BY e.nombre;

#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre FROM Empleado e ORDER BY e.salario LIMIT 1;

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT * FROM Empleado e 
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;
