-- Consultas con INNER JOIN
-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
SELECT D.nombre_depto, E.nombre, E.puesto, D.localidad
FROM EMPLEADO E
INNER JOIN DEPARTAMENTO D ON E.depto_nro = D.depto_nro
WHERE E.puesto = 'Vendedor';

-- 2. Visualizar los departamentos con más de cinco empleados
SELECT D.nombre_depto
FROM DEPARTAMENTO D
INNER JOIN EMPLEADO E ON D.depto_nro = E.depto_nro
GROUP BY D.nombre_depto
HAVING COUNT(*) > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’
SELECT E.nombre, E.salario, D.nombre_depto
FROM EMPLEADO E
INNER JOIN DEPARTAMENTO D ON E.depto_nro = D.depto_nro
WHERE E.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre
SELECT E.*
FROM EMPLEADO E
INNER JOIN DEPARTAMENTO D ON E.depto_nro = D.depto_nro
WHERE D.nombre_depto = 'Contabilidad'
ORDER BY E.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo
SELECT nombre
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
SELECT *
FROM EMPLEADO
WHERE salario = (SELECT MAX(salario) FROM EMPLEADO 
WHERE depto_nro = (SELECT depto_nro FROM DEPARTAMENTO 
WHERE nombre_depto = 'Ventas'));
