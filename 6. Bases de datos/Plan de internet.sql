DROP SCHEMA empresa_internet;
CREATE SCHEMA IF NOT EXISTS empresa_internet;

USE empresa_internet;

CREATE TABLE IF NOT EXISTS cliente (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATETIME NOT NULL,
	provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS plan_de_internet(
	id INT PRIMARY KEY AUTO_INCREMENT,
    velocidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    descuento DECIMAL,
    cliente_id INT NOT NULL,
    FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);

INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Daniel','Melo','1997-10-23','Bogota', 'Bogota DC');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Armando','Casas','1972-08-12','Valle del Cauca', 'Cali');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Armando','Paredes','1989-05-24','Risaralda', 'Pereira');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Pepito','Perez','2000-04-13','Caqueta', 'Florencia');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Pepita','Alvarez','1990-12-24','Bogota', 'Bogota DC');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Augusto','Salamanca','1997-11-30','Risaralda', 'Dosquebradas');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Sofia','Lopez','1999-03-13','Bogota', 'Bogota DC');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Mery','Bermudez','1990-11-11','Meta', 'Villavicenci0');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Juan','Melo','1989-08-20','Quindio', 'Armenia');
INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('Camilo','Pabon','2001-01-10','Bogota', 'Bogota DC');

INSERT INTO plan_de_internet (velocidad, precio, descuento, cliente_id) VALUES (200,200.23,5,1);
INSERT INTO plan_de_internet (velocidad, precio, descuento, cliente_id) VALUES (80,85.20,0,2);
INSERT INTO plan_de_internet (velocidad, precio, descuento, cliente_id) VALUES (100,90,0,3);
INSERT INTO plan_de_internet (velocidad, precio, descuento, cliente_id) VALUES (120,110.23,3,4);
INSERT INTO plan_de_internet (velocidad, precio, descuento, cliente_id) VALUES (150,150.20,10,2);

SELECT id, nombre, apellido, fecha_nacimiento
FROM cliente
WHERE fecha_nacimiento > '2000-01-01';

SELECT c.id, c.nombre, c.apellido, p.velocidad
FROM cliente c INNER JOIN plan_de_internet p ON p.cliente_id = c.id
WHERE p.velocidad>=100;

SELECT nombre, apellido
FROM cliente
WHERE provincia = 'Bogota';

SELECT c.nombre, c.apellido, p.velocidad, p.precio
FROM cliente c INNER JOIN plan_de_internet p ON p.cliente_id= c.id
WHERE p.precio>100;

SELECT c.nombre, c.apellido, p.precio  'Precio final'
FROM cliente c INNER JOIN plan_de_internet p ON p.cliente_id=c.id;

SELECT c.nombre, c.apellido, MAX(p.descuento)
FROM cliente c INNER JOIN plan_de_internet p ON c.id = p.cliente_id
GROUP BY c.id;

SELECT c.nombre, c.apellido, COUNT(p.id) 'Numero de planes'
FROM cliente c LEFT JOIN plan_de_internet p ON c.id=p.cliente_id
GROUP BY c.id;

SELECT MAX(velocidad)
FROM plan_de_internet;

SELECT MIN(velocidad)
FROM plan_de_internet;

SELECT MAX(precio) 
FROM plan_de_internet;

SELECT MIN(precio)
FROM plan_de_internet;






