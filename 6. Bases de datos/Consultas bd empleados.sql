CREATE SCHEMA IF NOT EXISTS empleado_db;

USE empleado_db;

DROP TABLE IF EXISTS departamento;

CREATE TABLE departamento (
	depto_nro VARCHAR(10),
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50),
    PRIMARY KEY (depto_nro)
);

DROP TABLE IF EXISTS empleado;

CREATE TABLE empleado (
    cod_emp VARCHAR(10),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario INT,
    comision INT,
    depto_nro VARCHAR(10),
    PRIMARY KEY (cod_emp),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
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

# 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.apellido, e.puesto, d.localidad
FROM departamento d
INNER JOIN empleado e ON d.depto_nro = e.depto_nro
WHERE e.puesto = 'Vendedor';

# 2. Visualizar los departamentos con más de cinco empleados.
SELECT COUNT(*), d.nombre_depto
FROM departamento d
INNER JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(*) > 5;

# 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE e.puesto LIKE (SELECT puesto
					FROM empleado
                    WHERE nombre = 'Mito' AND apellido = 'Barchuk');
                    
# 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.depto_nro LIKE (SELECT depto_nro
						FROM departamento
                        WHERE nombre_depto = 'Contabilidad');

# 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

# 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM EMPLEADO
WHERE salario = (SELECT MAX(salario) 
				FROM EMPLEADO 
                WHERE depto_nro = (SELECT depto_nro 
									FROM DEPARTAMENTO 
									WHERE nombre_depto = 'Ventas'));

