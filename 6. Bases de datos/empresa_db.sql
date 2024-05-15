-- Creación de la tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Inserción de datos en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Creación de la tabla EMPLEADO
CREATE TABLE EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10,2),
    comision DECIMAL(10,2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

-- Inserción de datos en la tabla EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT nombre, puesto, localidad 
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

#Visualizar los departamentos con más de cinco empleados.

SELECT nombre_depto, COUNT(cod_emp) AS nro_emp
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto HAVING nro_emp >= 2;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT nombre, salario, nombre_depto
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = 'Barchuk');

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, e.depto_nro
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

#Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT nombre, apellido, salario
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, e.depto_nro
FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE salario = (SELECT MAX(salario) FROM EMPLEADO WHERE depto_nro = (SELECT depto_nro FROM DEPARTAMENTO WHERE nombre_depto = 'Ventas'));