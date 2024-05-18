DROP database if exists empleados_db;
CREATE DATABASE IF NOT EXISTS empleados_db;
use empleados_db;

CREATE TABLE Departamento(
id_departamento int primary key auto_increment, 
nombre_departamento varchar(55),
localidad varchar(255));

CREATE TABLE Empleado(
id_empleado int primary key auto_increment,
nombre varchar(25),
apellido varchar(25),
puesto varchar(25),
fecha_alta date,
salario double,
comision double,
id_departamento int,
foreign key (id_departamento) references Departamento (id_departamento));

INSERT INTO Departamento(nombre_departamento, localidad) VALUES ("Software","Los Tigres");
INSERT INTO Departamento(nombre_departamento, localidad) VALUES ("Sistemas","Guadalupe");
INSERT INTO Departamento(nombre_departamento, localidad) VALUES ("Contabilidad","La Roca");
INSERT INTO Departamento(nombre_departamento, localidad) VALUES ("Ventas","Plata");

INSERT INTO Empleado(nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("César","Piñero","Vendedor", "2018-05-12",8000,15000,4);
INSERT INTO Empleado(nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("Yosep","Kowaleski","Analista","2015-07-14",140000,0,2);
INSERT INTO Empleado( nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("Mariela", "Barrios", "Director", "2014-06-05", 185000, 0, 3);
INSERT INTO Empleado(nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, 4);
INSERT INTO Empleado(nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, 4);
INSERT INTO Empleado(nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("Mito", "Barchuk", "Presidente", "2014-06-05", 190000, 0, 3);
INSERT INTO Empleado(nombre, apellido, puesto, fecha_alta, salario, comision, id_departamento) 
VALUES ("Emilio", "Galarza", "Desarrollador", "2014-08-02", 60000, 0, 1);


/*
* Ejercicio consultas
*/

/* 1 */
SELECT e.nombre , e.apellido, e.puesto , d.localidad FROM
Empleado e INNER JOIN Departamento d 
ON d.id_departamento = e.id_departamento;

/* 2 */
SELECT d.nombre_departamento, COUNT(e.id_departamento) as numero_empleado
FROM Empleado e INNER JOIN Departamento d
ON d.id_departamento = e.id_departamento
GROUP BY d.id_departamento
HAVING COUNT(e.id_departamento) > 1;

/* 3 */
SELECT e.nombre, e.salario, d.nombre_departamento
FROM Empleado e INNER JOIN Departamento d
ON d.id_departamento = e.id_departamento
WHERE e.puesto IN (SELECT puesto 
FROM Empleado
WHERE nombre = "Mito" AND apellido = "Barchuk");

/* 4 */
SELECT * FROM Empleado WHERE id_departamento = 3 ORDER BY nombre;

/* 5 */
EXPLAIN SELECT nombre, apellido FROM Empleado WHERE salario = (SELECT MIN(salario) FROM Empleado); #Resulta menos eficiente
EXPLAIN SELECT nombre, apellido FROM Empleado order by salario limit 1;

/* 6 */
SELECT * FROM Empleado WHERE id_departamento = 4 ORDER BY salario DESC LIMIT 1;

/*
SELECT nombre, MAX(salario) FROM Empleado GROUP BY id_departamento ;
*/