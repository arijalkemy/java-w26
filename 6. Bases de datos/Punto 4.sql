create database if not exists empresa_internet;
use empresa_internet;

drop table if exists Planes;
drop table if exists Cliente;
create table if not exists Cliente (
id int primary key auto_increment,
dni varchar(10) unique,
nombre varchar(255),
apellido varchar(255),
provincia varchar(255),
ciudad varchar(255),
fecha_nacimiento date
);

drop table if exists Planes;
create table if not exists Planes (
id_plan int primary key auto_increment,
velocidad_ofrecida int,
precio double,
descuento float,
id_cliente int,
foreign key(id_cliente)
references Cliente(id)
      ON UPDATE RESTRICT 
      ON DELETE CASCADE
);

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("123456789", "Juan", "García", "Madrid", "Madrid", '1990-05-12');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("987654321", "María", "López", "Barcelona", "Barcelona", '1985-10-25');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("987654327", "Barbara", "Gordon", "Barcelona", "Barcelona", '1985-10-25');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("987654329", "James", "Gordon", "Barcelona", "Barcelona", '1985-10-25');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("456789123", "Pedro", "Martínez", "Valencia", "Valencia", '1978-03-17');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("789123456", "Ana", "Rodríguez", "Sevilla", "Sevilla", '1982-08-08');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("159357852", "Laura", "Fernández", "Alicante", "Elche", '1995-12-30');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("369258147", "Carlos", "Sánchez", "Málaga", "Marbella", '1989-07-21');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("753951846", "Elena", "Gómez", "Granada", "Granada", '1975-11-03');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("258147369", "Antonio", "Pérez", "Murcia", "Murcia", '1983-04-15');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("147369258", "Isabel", "Hernández", "Bilbao", "Bilbao", '1992-09-28');

INSERT INTO Cliente (dni, nombre, apellido, provincia, ciudad, fecha_nacimiento)
VALUES ("951753846", "Daniel", "Fernández", "Zaragoza", "Zaragoza", '1980-02-10');

#Planes

INSERT INTO Planes (velocidad_ofrecida, precio, descuento, id_cliente)
VALUES (200, 55000, 0.15, 2);

INSERT INTO Planes (velocidad_ofrecida, precio, descuento, id_cliente)
VALUES (200, 55000, 0.20, 10);

INSERT INTO Planes (velocidad_ofrecida, precio, descuento, id_cliente)
VALUES (150, 45000, 0.1, 3);

INSERT INTO Planes (velocidad_ofrecida, precio, descuento, id_cliente)
VALUES (250, 65000, 0.25, 4);

INSERT INTO Planes (velocidad_ofrecida, precio, descuento, id_cliente)
VALUES (180, 50000, 0.18, 5);

INSERT INTO Planes (velocidad_ofrecida, precio, descuento, id_cliente)
VALUES (300, 70000, 0.3, 6);

#Consultas SQL

#1: Selección de todos los usuarios con posibilidad de paginación
SELECT id, dni, nombre, apellido FROM Cliente
LIMIT 5 OFFSET 5;

#2: Selección de todos los planes con posibilidad de paginación
SELECT * FROM Planes
LIMIT 5 OFFSET 0;

#3: Selección de todos los planes con posibilidad de paginación
SELECT id_plan, velocidad_ofrecida, precio, descuento FROM Planes
LIMIT 5 OFFSET 0;

#4: Promedio general de los descuentos ofrecidos
SELECT avg(descuento) FROM Planes;

#5: Moda en los planes de velocidad_ofrecidos para los clientes ordenados de forma DESCENDENTE
SELECT velocidad_ofrecida, COUNT(*) as "cantidad" FROM Planes
GROUP BY velocidad_ofrecida
ORDER BY cantidad DESC;

#6: Busqueda de Clientes por patron de DNI
SELECT id, dni, nombre, apellido FROM Cliente
WHERE dni like "1%";

#7: Buqueda de usuarios por rango de fechas
SELECT id, dni, nombre, apellido, fecha_nacimiento FROM Cliente
WHERE fecha_nacimiento >= 19900512; #Opcion #1

SELECT id, dni, nombre, apellido, fecha_nacimiento FROM Cliente
WHERE fecha_nacimiento >= "1990-05-12"; #Opcion #2

SELECT id, dni, nombre, apellido, fecha_nacimiento FROM Cliente
WHERE fecha_nacimiento <= unix_timestamp("1990-05-12"); #No tiene sentido

#8: Cantidad de clientes por Ciudad

SELECT ciudad, count(*) FROM Cliente
GROUP BY ciudad;

#9: Total de clientes que han adquirido un plan

SELECT count(id_cliente) as "Total clienes con plan" from Planes;

#10: Cantidad total de clientes registrados en el sistema

SELECT count(id) as "Total de clientes" from Cliente;


