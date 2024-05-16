SELECT nombre, apellido, puesto, localidad
FROM empleado e INNER JOIN departamento d ON d.depto_nro=e.depto_nro
WHERE e.puesto = 'Vendedor';

SELECT nombre_dpto
FROM departamento d INNER JOIN empleado e ON d.depto_nro=e.dpto_nro 
GROUP BY d.depto_nro 
HAVING COUNT(e.cod_emp)>5;

SELECT nombre, apellido, salario, nombre_dpto
FROM empleado e INNER JOIN departamento d ON d.depto_nro=e.depto_nro
WHERE e.puesto IN (SELECT puesto
				  FROM empleado
                  WHERE nombre= 'Mito' AND apellido = 'Barchuk');

SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
FROM empleado e INNER JOIN departamento d ON d.depto_nro=e.depto_nro
WHERE d.nombre_dpto = 'Contabilidad'
ORDER BY e.nombre ASC;

SELECT nombre, apellido
FROM empleado
WHERE salario = MIN (salario);

SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
FROM empleado e INNER JOIN departamento d ON d.depto_nro=e.depto_nro
GROUP BY d.depto_nro
HAVING d.nombre_dpto = 'Ventas' AND e.salario = MAX(salario);