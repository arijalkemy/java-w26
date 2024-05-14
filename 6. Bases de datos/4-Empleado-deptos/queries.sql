-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT e.nombre, e.apellido, e.puesto, d.localidad FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.

SELECT * FROM departamento d JOIN empleado e ON e.depto_nro = d.depto_nro GROUP BY d.depto_nro HAVING COUNT(*) > 5:

SELECT g.* FROM genres g WHERE (SELECT COUNT(*) FROM movies m WHERE m.genre_id = g.id) > 3;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e 
JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE e.puesto = (
    SELECT puesto 
    FROM empleado 
    WHERE e.nombre = 'Mito' AND e.apellido = 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT * FROM empleados e INNER JOIN departamento d ON e.depto_nro = e.depto_nro
WHERE d.nombre_depto = contabilidad ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT e.nombre FROM empleado e ORDER BY e.salario LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT * 
FROM empleado e 
INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = ventas
ORDER BY e.salario DESC LIMIT 1;
