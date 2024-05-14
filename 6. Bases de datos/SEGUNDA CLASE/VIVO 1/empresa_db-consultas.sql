
CREATE SCHEMA empresa_db;

USE empresa_db;

CREATE TABLE departamento(
	depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_dpto VARCHAR(20) NOT NULL,
    localidad VARCHAR(20) NOT NULL
);

CREATE TABLE empleado(
	cod_emp VARCHAR(10) PRIMARY KEY NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    puesto VARCHAR(15) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario INTEGER,
    comision INTEGER,
    depto_nro VARCHAR(10) NOT NULL,
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento VALUES ('D-000-1','Software','Los Tigres');
INSERT INTO departamento VALUES ('D-000-2','Sistemas','Guadalupe');
INSERT INTO departamento VALUES ('D-000-3','Contabilidad','La Roca');
INSERT INTO departamento VALUES ('D-000-4','Ventas','Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


/* Consultas */

SELECT nombre, puesto, d.localidad
FROM empleado e INNER JOIN departamento d ON d.depto_nro= e.depto_nro
WHERE e.puesto='Vendedor';

SELECT d.nombre_dpto
FROM empleado e INNER JOIN departamento d ON d.depto_nro= e.depto_nro
GROUP BY e.depto_nro
HAVING count(e.cod_emp)>5;

SELECT e.nombre, e.salario, d.nombre_dpto
FROM empleado e INNER JOIN departamento d ON d.depto_nro= e.depto_nro
WHERE e.puesto IN (SELECT puesto FROM empleado WHERE nombre='Mito' AND apellido ='Barchuk')
		AND e.nombre <> 'Mito';
        
SELECT e.*
FROM empleado e INNER JOIN departamento d ON d.depto_nro= e.depto_nro
WHERE d.nombre_dpto = 'Contabilidad'
ORDER BY e.nombre ASC;

SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);


SELECT nombre
FROM empleado e INNER JOIN departamento d ON d.depto_nro= e.depto_nro
WHERE salario = (SELECT MAX(salario) FROM empleado e INNER JOIN departamento d ON d.depto_nro= e.depto_nro
WHERE d.nombre_dpto='Ventas');

