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

SELECT E.NOMBRE, E.PUESTO, D.LOCALIDAD
FROM EMPLEADOS E
INNER JOIN DEPARTAMENTOS D ON D.DEPTO_NRO = E.DEPTO_NRO
WHERE E.PUESTO = 'Vendedor';


## Visualizar los departamentos con más de cinco empleados.

SELECT D.*
FROM DEPARTAMENTOS D
WHERE (
    SELECT COUNT(*)
    FROM EMPLEADOS E
    WHERE D.DEPTO_NRO = E.DEPTO_NRO
) > 5;

SELECT D.*
FROM DEPARTAMENTOS D
INNER JOIN EMPLEADOS E ON D.DEPTO_NRO = E.DEPTO_NRO
GROUP BY E.DEPTO_NRO
HAVING COUNT(*) > 5;


## Mostrar el nombre, salario y nombre del departamento de los empleados
## que tengan el mismo puesto que 'Mito Barchuk'.


SELECT E.NOMBRE,
       E.SALARIO,
       D.NOMBRE_DEPTO
FROM EMPLEADOS E
	INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE E.PUESTO LIKE (SELECT E2.PUESTO
                     FROM EMPLEADOS E2
                     WHERE E2.NOMBRE LIKE 'Mito'
                       AND E2.APELLIDO LIKE 'Barchuk')
  AND E.NOMBRE <> 'Mito'
  AND E.APELLIDO <> 'Barchuk';

## Mostrar los datos de los empleados que trabajan en el
## departamento de contabilidad, ordenados por nombre.

SELECT E.*
FROM EMPLEADOS E 
INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE D.NOMBRE_DEPTO LIKE 'Contabilidad'
ORDER BY E.NOMBRE;


## Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT E.NOMBRE
FROM EMPLEADOS E 
ORDER BY E.SALARIO 
LIMIT 1;

SELECT E.NOMBRE
FROM EMPLEADOS E
WHERE E.SALARIO = (SELECT MIN(E.SALARIO) FROM EMPLEADOS E);


## Mostrar los datos del empleado que tiene el salario más alto en el departamento de 'Ventas'.

SELECT E.*
FROM EMPLEADOS E 
INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE D.NOMBRE_DEPTO LIKE 'Ventas' 
AND E.SALARIO = (
    SELECT MAX(E2.SALARIO) 
    FROM EMPLEADOS E2 
    WHERE E2.DEPTO_NRO = E.DEPTO_NRO
);

SELECT
    E.*
FROM EMPLEADOS E INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE D.NOMBRE_DEPTO = 'Ventas'
ORDER BY E.SALARIO DESC
LIMIT 1;