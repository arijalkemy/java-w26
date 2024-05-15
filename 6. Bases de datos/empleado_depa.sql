-- 1)
select empleado.nombre, empleado.puesto, departamento.localidad
from empleado inner join departamento on empleado.depto_nro = DEPARTAMENTO.depto_nro
where empleado.puesto = "Vendedor";

-- 2)
SELECT empleado.depto_nro, COUNT(*) as num_empleados, DEPARTAMENTO.*
FROM empleado inner join departamento on empleado.depto_nro = departamento.depto_nro
GROUP BY empleado.depto_nro
HAVING COUNT(*) > 5;

-- 3)
select e.nombre, e.salario, d.nombre_depto from empleado e inner join departamento d on e.depto_nro = d.depto_nro
where e.puesto = "Presidente";

-- 4)

select e.*, d.nombre_depto from empleado e inner join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = "Contabilidad" order by e.nombre;

-- 5) 
select * from empleado where salario = (select min(salario) from empleado);

select e.*, d.nombre_depto from empleado e inner join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = "Ventas" and e.salario = (select max(salario) from empleado where puesto);



