SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.id 
WHERE puesto LIKE "vendedor";


SELECT d.id, d.nombre_depto, count(*) as cantidad
FROM departamento as d 
INNER JOIN empleado as e 
ON e.depto_nro = d.id 
GROUP BY e.depto_nro
HAVING cantidad>2;

SELECT e.nombre, e.salario, d.nombre_depto
FROM departamento as d 
INNER JOIN empleado as e 
ON e.depto_nro = d.id 
WHERE puesto = (SELECT puesto 
				FROM empleado 
				WHERE nombre LIKE "Mito" AND apellido LIKE "Barchuk");
                
SELECT e.id, e.nombre, e.apellido, e.fecha_alta, e.salario, e.comision, e.puesto
FROM empleado AS e 
INNER JOIN departamento AS d 
ON e.depto_nro = d.id 
WHERE d.nombre_depto LIKE "contabilidad" 
ORDER BY e.nombre;

SELECT nombre, salario FROM empleado ORDER BY salario LIMIT 1;

SELECT nombre, salario 
FROM empleado 
WHERE empleado.depto_nro = (SELECT id FROM departamento WHERE departamento.nombre_depto LIKE "ventas") 
ORDER BY salario DESC LIMIT 1;
