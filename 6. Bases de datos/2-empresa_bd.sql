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
SELECT E.nombre, E.puesto, D.localidad
FROM empleado E  
INNER JOIN departamento D 
	ON E.depto_nro = D.depto_nro;

## Visualizar los departamentos con más de cinco empleados.
SELECT D.nombre_depto, COUNT(E.cod_emp)
FROM empleado E  
INNER JOIN departamento D 
	ON E.depto_nro = D.depto_nro
GROUP BY D.depto_nro;
--
SELECT D.*
FROM Departamentos D
INNER JOIN Empleados E 
	ON D.depto_nro = E.depto_nro
GROUP BY E.depto_nro
HAVING count(*) > 5;

## Mostrar el nombre, salario y nombre del departamento de los empleados
## que tengan el mismo puesto que 'Mito Barchuk'.
SELECT E.nombre, E.salario, D.nombre_depto
FROM empleado E  
INNER JOIN departamento D 
	ON E.depto_nro = D.depto_nro
WHERE E.puesto like (
	SELECT E2.puesto
    FROM empleado E2
    WHERE E2.nombRe = 'Mito' AND E2.apellido = 'Barchuk'
    )
AND e.nombre <> 'Mito'
AND e.apellido <> 'Barchuk';

## Mostrar los datos de los empleados que trabajan en el
## departamento de contabilidad, ordenados por nombre.
SELECT E.*
FROM empleado E
INNER JOIN departamento D
	ON E.depto_nro = D.depto_nro
HAVING D.nombre_depto = 'Contabilidad'
ORDER BY E.nombre;

## Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT E.nombre
FROM empleado E
WHERE E.salario = (
		SELECT MIN(salario)
        FROM empelado
        );
--
SELECT
    e.nombre
FROM Empleados e
ORDER BY e.salario
LIMIT 1;

## Mostrar los datos del empleado que tiene el salario más alto en el departamento de 'Ventas'.
SELECT E.*
FROM empleado E 
WHERE E.salario = (
		SELECT MAX(salario)
        FROM empelado E2
        INNER JOIN departamento D
			ON E2.depto_nro = D.depto_nro
		WHERE D.nombre_depto = 'Ventas'
        );
--
SELECT E.*
FROM Empleados E 
INNER JOIN Departamentos D 
	ON E.depto_nro = D.depto_nro
WHERE D.nombre_depto='Ventas'
ORDER BY e.salario DESC
LIMIT 1;