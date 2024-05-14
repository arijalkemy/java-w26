-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT d.nombre_depto, em.puesto, d.localidad
FROM departamentos d
JOIN empleados em ON em.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto
FROM departamentos d
JOIN empleados em ON em.depto_nro = d.depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(1) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, d.nombre_depto
FROM departamentos d
JOIN empleados em ON em.depto_nro = d.depto_nro
WHERE em.puesto = (SELECT em2.puesto
                    FROM empleados em2
                    WHERE em2.nombre = "Mito" AND
                        em2.apellido "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.*
FROM empleados em
JOIN departarmentos d ON em.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY em.nombre ASC

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT em.nombre
FROM empleados em
WHERE em.salario = (SELECT MIN(em2.salario)
                    FROM empleados em2
                    WHERE em2.cod_emp = em.cod_emp);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.*
FROM empleados em
WHERE em.salario = (SELECT MAX(em2.salario)
                    FROM empleados em2
                    JOIN departarmentos d ON em.depto_nro = d.depto_nro
                    WHERE em2.cod_emp = em.cod_emp AND
                        d.nombre_depto = "Ventas");