CREATE SCHEMA IF NOT EXISTS empleado_db;

USE empleado_db;

DROP TABLE IF EXISTS departamento;


-- sala 4
CREATE TABLE departamento (
	depto_nro VARCHAR(10),
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50),
    PRIMARY KEY (depto_nro)
);

DROP TABLE IF EXISTS empleado;

CREATE TABLE empleado(
	cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(10),
    apellido VARCHAR(10),
    puesto VARCHAR(15),
    fecha_alta DATE,
	salario INT,
    comision INT,
    depto_nro VARCHAR(10),
    foreign key (depto_nro) REFERENCES departamento(depto_nro)

);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezecicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

SELECT * FROM EMPLEADO;
SELECT * FROM DEPARTAMENTO;

-- 1
SELECT e.nombre, e.puesto, d.localidad FROM empleado as e JOIN departamento as d ON d.depto_nro = e.depto_nro WHERE e.puesto = "Vendedor";

-- 2
SELECT d.nombre_depto, COUNT(e.cod_emp) AS cantidad_dpto FROM departamento d JOIN empleado e ON d.depto_nro = e.depto_nro GROUP BY d.depto_nro HAVING COUNT(e.depto_nro) > 5;

-- 3

SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e JOIN departamento d ON d.depto_nro = e.depto_nro WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = "Mito" AND apellido = "Barchuk" ) AND e.cod_emp != 'E-0006';

-- 4

SELECT e.* from empleado e JOIN departamento d ON d.depto_nro = e.depto_nro WHERE d.nombre_depto = 'Contabilidad' ORDER BY e.nombre;


-- 5

SELECT nombre, salario FROM empleado WHERE salario = (select MIN(salario) FROM empleado);

-- 6

SELECT e.* FROM empleado e JOIN departamento d ON d.depto_nro = e.depto_nro  WHERE salario = (select MAX(e.salario) FROM empleado  AS e JOIN Departamento d ON d.depto_nro = e.depto_nro WHERE d.nombre_depto = 'Ventas');
