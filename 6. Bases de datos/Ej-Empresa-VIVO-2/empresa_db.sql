use empresa_db;

CREATE TABLE Departamentos
(
    depto_nro    VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad    VARCHAR(50)
);

CREATE TABLE Empleados
(
    cod_emp    VARCHAR(10) PRIMARY KEY,
    nombre     VARCHAR(50),
    apellido   VARCHAR(50),
    puesto     VARCHAR(50),
    fecha_alta DATE,
    salario    DECIMAL(10, 2),
    comision   DECIMAL(10, 2),
    depto_nro  VARCHAR(10),
    CONSTRAINT fk_departamento FOREIGN KEY (depto_nro) REFERENCES Departamentos (depto_nro)
);

## insertar datos Departamentos
INSERT INTO Departamentos (depto_nro, nombre_depto, localidad)
VALUES ('D-000-1', 'Software', 'Los Tigres');

INSERT INTO Departamentos (depto_nro, nombre_depto, localidad)
VALUES ('D-000-2', 'Sistemas', 'Guadalupe');

INSERT INTO Departamentos (depto_nro, nombre_depto, localidad)
VALUES ('D-000-3', 'Contabilidad', 'La Roca');

INSERT INTO Departamentos (depto_nro, nombre_depto, localidad)
VALUES ('D-000-4', 'Ventas', 'Plata');

## insertar datos empleados
INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');

INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');

INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');

INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');

INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');

INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');

INSERT INTO Empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

## Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

select e.nombre,
       e.puesto,
       d.localidad
from Empleados e
         inner join Departamentos D on e.depto_nro = D.depto_nro;

## Visualizar los departamentos con más de cinco empleados.

select D.*
from Departamentos D
         inner join Empleados E on D.depto_nro = E.depto_nro
group by E.depto_nro
having count(*) > 5;

## Mostrar el nombre, salario y nombre del departamento de los empleados
## que tengan el mismo puesto que ‘Mito Barchuk’.

select e.nombre,
       e.salario,
       d.nombre_depto
from Empleados e
         inner join Departamentos D on e.depto_nro = D.depto_nro
where e.puesto like (select e2.puesto
                     from Empleados e2
                     where e2.nombre like 'Mito'
                       and e2.apellido like 'Barchuk')
  and e.nombre <> 'Mito'
  and e.apellido <> 'Barchuk';

## Mostrar los datos de los empleados que trabajan en el
## departamento de contabilidad, ordenados por nombre.

select
    e.*
from Empleados e inner join Departamentos D on e.depto_nro = D.depto_nro
where D.nombre_depto = 'Contabilidad'
order by e.nombre;

## Mostrar el nombre del empleado que tiene el salario más bajo.

select
    e.nombre
from Empleados e
where e.salario = (select min(e.salario) from Empleados e);

select
    e.nombre
from Empleados e
order by e.salario
limit 1;

## Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

select
    e.*
from Empleados e inner join Departamentos D on e.depto_nro = D.depto_nro
where D.nombre_depto='Ventas'
order by e.salario desc
limit 1;








