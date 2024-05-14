SELECT e.nombre, e.puesto, d.localidad
FROM empleado e 
JOIN departamento d 
ON e.depto_nro = d.depto_nro;

SELECT 
	D.nombre_depto, count(*) AS EMPLEADOS  
FROM empleados as E 
inner join departamentos as D on E.depto_nro = D.depto_nro 
GROUP  BY D.nombre_depto 
HAVING EMPLEADOS>5;

SELECT E.nombre,E.salario,D.nombre_depto 
FROM empleados as E 
inner join departamentos as D on E.depto_nro = D.depto_nro 
where E.puesto like (select puesto from empleados where apellido like 'Brezezicki');

SELECT E.nombre,E.salario,D.nombre_depto 
FROM empleados as E 
inner join departamentos as D on E.depto_nro = D.depto_nro and D.nombre_depto LIKE 'Contabilidad' 
order by E.nombre desc;

SELECT nombre, MIN(salario) AS SALARIO_MIN
FROM empleados
GROUP BY NOMBRE
ORDER BY SALARIO_MIN LIMIT 1 ;

SELECT E.*
FROM empleados as E 
where 
E.salario = (select max(salario) from empleados e inner join departamentos as D on E.depto_nro = D.depto_nro and D.nombre_depto LIKE 'Ventas');