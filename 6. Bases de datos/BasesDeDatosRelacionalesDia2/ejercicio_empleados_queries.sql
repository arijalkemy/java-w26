-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from Empleados e inner join Departamentos d on e.depto_nro = d.depto_nro
where e.puesto like '%Vendedor%';

-- Visualizar los departamentos con más de cinco empleados.
select d.* from departamentos d inner join empleados e on d.depto_nro = e.depto_nro
group by e.depto_nro having count(*) > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto from empleados e inner join departamentos d on e.depto_nro = d.depto_nro
where e.puesto like (select puesto from empleados where nombre like 'Mito' and apellido like 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.* from empleados e inner join departamentos d on e.depto_nro = d.depto_nro
where d.nombre_depto like 'Contabilidad' order by e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from empleados order by salario asc limit 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select * from empleados e inner join departamentos d on e.depto_nro = d.depto_nro
where d.nombre_depto like 'Ventas' order by e.salario desc limit 1;
