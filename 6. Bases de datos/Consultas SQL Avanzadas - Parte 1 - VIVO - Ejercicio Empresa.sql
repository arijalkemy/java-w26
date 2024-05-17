-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT d.nombre_depto, e.puesto, d.localidad
FROM departamento d
JOIN empleado e ON e.depto_nro = d.depto_nro
WHERE e.puesto LIKE "Vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT nombre_depto, COUNT(*) as cantidad_empleados_depto 
FROM empleados e
JOIN departamento d ON e.depto_nro = d.depto_nro;
GROUP BY depto_nro
HAVING cantidad_empleados_depto > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 
(SELECT puesto FROM empleado WHERE nombre LIKE "Mito" AND nombre LIKE "Barchuk");

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleados e 
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto LIKE "Contabilidad"
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado ORDER BY salario DESC LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT * FROM empleado e WHERE e.depto_nro = 
(SELECT depto_nro FROM departamento WHERE nombre_depto LIKE "Ventas")
ORDER BY salario LIMIT 1;