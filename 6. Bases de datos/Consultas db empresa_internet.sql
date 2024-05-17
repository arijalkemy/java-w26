-- Ejercicio 3.a
CREATE DATABASE IF NOT EXISTS empresa_internet;

USE empresa_internet;

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    dni INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL
);

CREATE TABLE plan (
    id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad SMALLINT NOT NULL,
    precio FLOAT NOT NULL,
    descuento FLOAT NOT NULL
);

CREATE TABLE clientexplan (
    id_cliente INT,
    id_plan INT,
    PRIMARY KEY (id_cliente, id_plan),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);


-- Ejercicio 3.b
-- Inserts registros en la tabla de clientes
INSERT INTO cliente (id_cliente,nombre, apellido, fecha_nacimiento, provincia, ciudad, direccion,dni) VALUES
(1,'Homero', 'Simpson', '1956-05-12', 'Springfield', 'Springfield', '742 Evergreen Terrace', 128494),
(2,'Bob', 'Esponja', '1986-07-14', 'Bikini Bottom', 'Fondo de Bikini', '124 Calle Concha',3449334),
(3,'Cenicienta', 'Triste', '1920-02-10', 'Île-de-France', 'París', '35 Rue du Pied de Cochon',5493943),
(4,'Harry', 'Potter', '1980-07-31', 'Surrey', 'Little Whinging', '4 Privet Drive',940394),
(5,'Paddington', 'Blank', '1958-06-25', 'Greater London', 'Londres', '32 Windsor Gardens',9475748),
(6,'Freddy', 'Krueger', '1942-09-12', 'Ohio', 'Springwood', '123 Elm Street', 3583849),
(7,'Banana', 'Man', '1999-01-01', 'Nitt', 'Nuttytown', '29 Acacia Avenue', 0696005),
(8,'Pato', 'Lucas', '1989-05-12', 'Sprintfield', 'Pueblo Looney', 'Desierto de Sonora', 957689),
(9,'Goku', 'Saiyajin', '1973-04-16', 'Planeta Tierra', 'Monte Paoz', 'Monte Paoz', 859604),
(10,'Rick', 'Sánchez','2000-02-06', 'Disney', 'Dimension C-137', '6104 Avenida Ácido', 958403);

-- Inserts registros en la tabla de planes
INSERT INTO plan (id_plan, velocidad, precio, descuento) VALUES
(1,100, 29.99, 0.1),
(2,200, 39.99, 0.15),
(3,500, 49.99, 0.2),
(4,1000, 59.99, 0.25),
(5,2000, 69.99, 0.3);



-- Ejercicio 3.c
-- Asociaciones entre los registros de planes y clientes
INSERT INTO clientexplan (id_cliente, id_plan) VALUES
(1,1),
(2,1),
(3,2),
(4,2),
(5,3),
(6,3),
(7,4),
(8,4),
(9,5),
(10,5);


-- Ejercicio 4

-- Buscar el nombre y apellido de todas las personas que hayan nacido de 1980 al 2000
select nombre,apellido from cliente where fecha_nacimiento between "1980-01-01" and "2000-12-31";

-- Buscar el nombre,apellido y ciudad de las personas cuya ciudad sea Springfield o Paris
select nombre,apellido,ciudad from cliente where ciudad in ('Springfield','Paris');

-- Buscar el nombre,apellido y direccion de las personas que no viven en la ciudad Springfield
select nombre,apellido,direccion from cliente where ciudad not like "Springfield";

-- Buscar el nombre,apellido y direccion de las personas que contenga la letra M en el apellido
select nombre,apellido,direccion from cliente where apellido like "%m%";

-- Buscar el nombre,apellido y direccion de las personas que contenga la letra a en el nombre
-- y la fecha de nacimiento sea de 1990 al 2005
select nombre,apellido,direccion from cliente where nombre like "%a%" and fecha_nacimiento between "1990-01-01" and "2005-12-31";

-- Mostar los planes que tengas mas de 300 Megas
select velocidad,precio,descuento from plan where velocidad > 300;

-- Mostar los planes que tengan menos de 500 Megas y un descuento mayor al 10%
select velocidad,precio,descuento from plan where velocidad < 500 and descuento > 0.1;

-- Mostar el promedio del costo de los planes
select round(avg(precio),2) as promedio from plan;

-- Mostar la cantidad de planes
select count(*) as cantidad_planes from plan;

-- Mostar la suma del valor de todos los planes
select round(sum(precio),2) as cantidad_planes from plan;