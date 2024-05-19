CREATE DATABASE empresa;

USE empresa;

CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(100) NOT NULL,
    localidad VARCHAR(100) NOT NULL
);

CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    puesto VARCHAR(100) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    comision DECIMAL(10, 2) NOT NULL,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) 
VALUES 
    ('D-000-1', 'Software', 'Los Tigres'),
    ('D-000-2', 'Sistemas', 'Guadalupe'),
    ('D-000-3', 'Contabilidad', 'La Roca'),
    ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) 
VALUES 
    ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000.00, 15000.00, 'D-000-4'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 'D-000-2'),
    ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000.00, 0.00, 'D-000-3'),
    ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 'D-000-4'),
    ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 'D-000-4'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 'D-000-3'),
    ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000.00, 0.00, 'D-000-1');

SELECT de.nombre_depto AS "Departamento", em.nombre AS "Empleado", em.puesto AS "Puesto", de.localidad AS "Localidad"
FROM departamento de INNER JOIN empleado em ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto LIKE 'Ventas';

SELECT de.nombre_depto AS "Departamento"
FROM departamento de INNER JOIN empleado em ON de.depto_nro = em.depto_nro
GROUP BY de.depto_nro
HAVING COUNT(em.cod_emp) > 5; 

SELECT em.nombre, em.apellido, em.salario, de.nombre_depto
FROM empleado em INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE em.puesto = (SELECT puesto FROM empleado WHERE nombre LIKE 'Mito' AND apellido LIKE 'Barchuk');

SELECT em.* 
FROM empleado em INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto = 'Contabilidad'
ORDER BY em.nombre;

SELECT em.nombre
FROM empleado em
WHERE em.salario = (SELECT MIN(salario) FROM empleado);

SELECT *
FROM empleado   
WHERE salario = (SELECT MAX(salario) FROM empleado em INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto = 'Ventas');
