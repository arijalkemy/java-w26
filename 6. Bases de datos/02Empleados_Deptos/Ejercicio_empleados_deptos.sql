
/* 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

/* 2. Visualizar los departamentos con más de cinco empleados. */
SELECT e.depto_nro, COUNT(*) AS cant_empleados
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro
HAVING cant_empleados > 5;

/* 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */ 
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

/* 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */ 
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre DESC;

/* 5. Mostrar el nombre del empleado que tiene el salario más bajo. */
SELECT e.nombre
FROM empleado e
WHERE e.salario = (SELECT MIN(salario) FROM empleado);

/* 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;
