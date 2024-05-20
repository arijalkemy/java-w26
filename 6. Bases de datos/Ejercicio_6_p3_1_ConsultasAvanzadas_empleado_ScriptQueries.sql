-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.id 
WHERE puesto LIKE "vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.id, d.nombre_depto, count(*) as cantidad
FROM departamento as d 
INNER JOIN empleado as e 
ON e.depto_nro = d.id 
GROUP BY e.depto_nro
HAVING cantidad>2;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM departamento as d 
INNER JOIN empleado as e 
ON e.depto_nro = d.id 
WHERE puesto = (SELECT puesto 
				FROM empleado 
				WHERE nombre LIKE "Mito" AND apellido LIKE "Barchuk");
                
-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.id, e.nombre, e.apellido, e.fecha_alta, e.salario, e.comision, e.puesto
FROM empleado AS e 
INNER JOIN departamento AS d 
ON e.depto_nro = d.id 
WHERE d.nombre_depto LIKE "contabilidad" 
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario FROM empleado ORDER BY salario LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre, salario 
FROM empleado 
WHERE empleado.depto_nro = (SELECT id FROM departamento WHERE departamento.nombre_depto LIKE "ventas") 
ORDER BY salario DESC LIMIT 1;
