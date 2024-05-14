create table empleado(
cod_emp VARCHAR(10) primary key,
nombre VARCHAR(15),
apellido VARCHAR(15),
puesto VARCHAR(15),
fecha_alta DATE,
salario INT,
comision INT,
depto_nro VARCHAR(10),
foreign key(depto_nro) references departamento(depto_nro)
);

-- 2
create table departamento(
depto_nro VARCHAR(10) primary key,
nombre_depto VARCHAR(15),
localidad VARCHAR(15)
);

-- 3

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- 4
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- 1
select e.nombre, e.puesto, d.localidad 
from empleado e join departamento d
on e.depto_nro = d.depto_nro;

-- 2
select d.depto_nro, d.nombre_depto, d.localidad, count(cod_emp) as cant_empleados
from departamento d join empleado e
on d.depto_nro = e.depto_nro
group by d.depto_nro
having cant_empleados > 2;

-- 3

select e.nombre, e.apellido, e.salario, d.nombre_depto
from empleado e join departamento d on e.depto_nro = d.depto_nro
where puesto like (
	select puesto from empleado where apellido like "Barchuk"
)
;
-- 4
select *
from empleado e
where e.depto_nro like (
	select depto_nro from departamento where nombre_depto like "Contabilidad"
)
;
-- 5
select e.nombre, e.apellido
from empleado e
where salario = (
	select min(salario) from empleado 
);

-- 6 

select * 
from empleado e join departamento d
on d.depto_nro = e.depto_nro
where e.salario = (
	select max(e.salario)
    from empleado e join departamento d
    on d.depto_nro = e.depto_nro
	where d.nombre_depto like 'Ventas'
)
and d.nombre_depto like 'Ventas';

-- 6 bis
SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;

