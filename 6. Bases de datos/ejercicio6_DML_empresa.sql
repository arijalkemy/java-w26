-- Se usa la base de datos de empleados_db
USE empleados_db;

-- se consulta el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
    de.nombre_depto AS "departamento",
    em.nombre AS "nombre_empleado",
    em.puesto,
    de.localidad
FROM
    departamento de
    INNER JOIN empleado em ON de.depto_nro = em.depto_nro
WHERE
    de.nombre_depto LIKE 'Ventas';

-- Se consulta los departamentos con más de dos empleados. 
SELECT
    de.nombre_depto AS "Departamento"
FROM
    departamento de
    INNER JOIN empleado em ON de.depto_nro = em.depto_nro
GROUP BY
    de.depto_nro
HAVING
    COUNT(em.cod_emp) > 2;


-- Se consulta el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT
    em.nombre,
    em.apellido,
    em.salario,
    de.nombre_depto AS 'Departamento'
FROM
    empleado em
    INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE
    em.puesto = (
        SELECT
            puesto
        FROM
            empleado
        WHERE
            nombre = 'Mito'
            AND apellido = 'Barchuk'
    );

-- Se consulta los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT
    em.*
FROM
    empleado em
    INNER JOIN departamento de ON em.depto_nro = de.depto_nro
WHERE
    de.nombre_depto = 'Contabilidad'
ORDER BY
    em.nombre;

-- Se consulta el nombre del empleado que tiene el salario más bajo.
SELECT
    em.nombre
FROM
    empleado em
WHERE
    em.salario = (
        SELECT
            MIN(salario)
        FROM
            empleado
    );

-- Se consulta os datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT
    *
FROM
    empleado
WHERE
    salario = (
        SELECT
            MAX(salario)
        FROM
            empleado em
            INNER JOIN departamento de ON de.depto_nro = em.depto_nro
        WHERE
            de.nombre_depto = 'Ventas'
    );