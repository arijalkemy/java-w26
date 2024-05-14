-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, apellido, localidad  FROM empleado inner join departamento on empleado.depto_nro = departamento.depto_nro;

-- Visualizar los departamentos con más de cinco empleados
SELECT depto_nro from empleado group by depto_nro having COUNT(depto_nro)>5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT nombre, salario, nombre_dpto from empleado e inner join departamento on e.depto_nro = departamento.depto_nro  WHERE puesto = (select DISTINCT  puesto from empleado e2 where e2.nombre = 'Mito' and e2.apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* from empleado e inner join departamento d on e.depto_nro = d.depto_nro where nombre_dpto = 'Contabilidad' ORDER by e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT MIN(salario), nombre  from empleado e;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT MAX(salario), e.* from empleado e; 
