# Creacion
create database employee_bootcamp;
use employee_bootcamp;
create table departamento
(
    depto_nro    varchar(20) not null primary key,
    nombre_depto varchar(20) not null,
    localidad    varchar(20) not null
);



create table empleado
(
    cod_emp    varchar(20) not null primary key,
    nombre     varchar(20) not null,
    apellido   varchar(20) not null,
    puesto     varchar(20) not null,
    fecha_alta date        not null,
    salario    float       not null,
    comision   float       not null,
    depto_nro  varchar(20) not null,
    foreign key (depto_nro) references departamento (depto_nro)
);

# Data

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES ('D-000-1', 'Software', 'Los tigres'),
       ('D-000-2', 'Sistemas', 'Guadalupe'),
       ('D-000-3', 'Contabilidad', 'La roca'),
       ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'Cesar', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
       ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
       ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
       ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
       ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
       ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
       ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

# Querys


# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e
         INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

# Visualizar los departamentos con más de cinco empleados.

SELECT COUNT(*) amount_by_employee, d.localidad
FROM departamento as d
         INNER JOIN empleado e on d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING amount_by_employee > 2;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
         INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE e.puesto IN
      (SELECT puesto FROM empleado WHERE CONCAT(nombre, CONCAT(' ', apellido)) LIKE ('Mito Barchuk'));

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT *
FROM empleado e
         INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE d.nombre_depto LIKE 'Contabilidad'
ORDER BY e.nombre;

# Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT e.nombre
FROM empleado e
WHERE salario = (SELECT MIN(salario) FROM empleado e);

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT e.*
FROM empleado e
         INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;

