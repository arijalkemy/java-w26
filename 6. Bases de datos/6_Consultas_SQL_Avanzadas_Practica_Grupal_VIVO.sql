--
-- Ejercicio de empresa con empleados
--

-- ejercicio 1
SELECT e.nombre , e.puesto , d.localidad  FROM empleado e 
inner join departamento d ON e.depto_nro = d.depto_nro 

-- ejercicio 2
select d.nombre_depto FROM departamento d 
inner join empleado e on e.depto_nro  = d.depto_nro
GROUP BY d.nombre_depto 
HAVING COUNT(e.cod_emp) > 5

-- ejercicio 3
select e.nombre , e.salario , d.nombre_depto  from empleado e
inner join departamento d ON d.depto_nro = e.depto_nro
where e.puesto = (select puesto from empleado e2 
					where e2.nombre = 'Cesar' AND e2.apellido = 'Piñero')
					
-- ejercicio 4
select e.* from empleado e
inner join departamento d on d.depto_nro = e.depto_nro 
where d.nombre_depto = 'Contabilidad'
order by e.nombre 

-- ejercicio 5
select e.nombre  from empleado e 
order by salario
limit 1

-- ejercicio 6
select e.* from empleado e
inner join departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Ventas'
order by salario DESC
limit 1
