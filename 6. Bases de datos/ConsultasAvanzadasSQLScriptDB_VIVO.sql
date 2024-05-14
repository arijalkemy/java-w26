USE empleados_db;

CREATE TABLE departamento(
	id INT(11) AUTO_INCREMENT PRIMARY KEY,
    nombre_depto VARCHAR(20),
    localidad VARCHAR(50)
);

CREATE TABLE empleado (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario INT,
    comision INT,
    depto_nro INT(11),
    FOREIGN KEY (depto_nro) REFERENCES departamento(id)
);



INSERT INTO DEPARTAMENTO (id, nombre_depto, localidad) VALUES (1, 'Software', 'Los Tigres');
INSERT INTO DEPARTAMENTO (id, nombre_depto, localidad) VALUES (2, 'Sistemas', 'Guadalupe');
INSERT INTO DEPARTAMENTO (id, nombre_depto, localidad) VALUES (3, 'Contabilidad', 'La Roca');
INSERT INTO DEPARTAMENTO (id, nombre_depto, localidad) VALUES (4, 'Ventas', 'Plata');


INSERT INTO empleado (id, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
(1, 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 4),
(2, 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 2),
(3, 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 3),
(4, 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 4),
(5, 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 4),
(6, 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 3),
(7, 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 1);

