create database empresa_internet;

use empresa_internet;

CREATE TABLE Provincias (
        id INT AUTO_INCREMENT PRIMARY KEY,
        provincia VARCHAR(255) NOT NULL
    );
    
    CREATE TABLE Ciudades (
        id INT AUTO_INCREMENT PRIMARY KEY,
        ciudad VARCHAR(255) NOT NULL
        );
        
        CREATE TABLE PlanesInternet (
        id INT AUTO_INCREMENT PRIMARY KEY,
        velocidad INT NOT NULL,
        precio DECIMAL(10,2) NOT NULL,
        descuento DECIMAL(10,2) DEFAULT 0.00
    );
    
        CREATE TABLE Clientes (
        id INT AUTO_INCREMENT PRIMARY KEY,
        dni VARCHAR(20) NOT NULL,
        nombre VARCHAR(255) NOT NULL,
        apellido VARCHAR(255) NOT NULL,
        fecha_nacimiento DATE NOT NULL,
        id_provincia INT,
        id_ciudad INT,
        FOREIGN KEY (id_provincia) REFERENCES provincias(id),
        FOREIGN KEY (id_ciudad) REFERENCES ciudades(id)
    );
    
   
       CREATE TABLE ClientePlan (
        id INT AUTO_INCREMENT PRIMARY KEY,
        id_cliente INT,
        id_plan INT,
        fecha_inicio DATE,
        PRIMARY KEY (id),
        FOREIGN KEY (id_cliente) REFERENCES clientes(id),
        FOREIGN KEY (id_plan) REFERENCES planesInternet(id)
    );
    
    /*Insercion de datos*/
    
INSERT INTO provincias (provincia) VALUES 
('Buenos Aires'),
('Córdoba'),
('Santa Fe'),
('Mendoza'),
('Tucumán'),
('Entre Ríos'),
('Salta'),
('Chaco'),
('Corrientes'),
('Santiago del Estero');

INSERT INTO ciudades (ciudad) VALUES 
('Ciudad de Buenos Aires'),
('Córdoba'),
('Rosario'),
('Mendoza'),
('San Miguel de Tucumán'),
('Paraná'),
('Salta'),
('Resistencia'),
('Corrientes'),
('Santiago del Estero');

INSERT INTO planesInternet (velocidad, precio, descuento) VALUES 
(50, 500.00, 50.00),
(100, 1000.00, 100.00),
(150, 1500.00, 150.00),
(200, 2000.00, 200.00),
(250, 2500.00, 250.00),
(300, 3000.00, 300.00),
(350, 3500.00, 350.00),
(400, 4000.00, 400.00),
(450, 4500.00, 450.00),
(500, 5000.00, 500.00);

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, id_provincia, id_ciudad) VALUES 
('40000001', 'Juan', 'Perez', '1980-01-01', 1, 1),
('40000002', 'Ana', 'Lopez', '1983-02-02', 2, 2),
('40000003', 'Lucas', 'Martinez', '1985-03-03', 3, 3),
('40000004', 'Laura', 'Garcia', '1990-04-04', 4, 4),
('40000005', 'Carla', 'Rodriguez', '1992-05-05', 5, 5),
('40000006', 'Pedro', 'Gomez', '1975-06-06', 6, 6),
('40000007', 'Miguel', 'Rojas', '1978-07-07', 7, 7),
('40000008', 'Sofia', 'Morales', '1983-08-08', 8, 8),
('40000009', 'Jose', 'Paz', '1985-09-09', 9, 9),
('40000010', 'Marina', 'Sanchez', '1988-10-10', 10, 10);

INSERT INTO clientePlan (id_cliente, id_plan, fecha_inicio) VALUES 
(1, 1, '2023-01-01'),
(1, 2, '2023-02-01'),
(2, 2, '2023-01-15'),
(2, 3, '2023-03-01'),
(3, 1, '2023-03-20'),
(3, 4, '2023-04-05'),
(4, 5, '2023-01-01'),
(4, 6, '2023-03-15'),
(5, 7, '2023-02-10'),
(5, 8, '2023-01-20'),
(6, 3, '2023-04-01'),
(6, 9, '2023-02-28'),
(7, 10, '2023-01-01'),
(7, 5, '2023-03-21'),
(8, 6, '2023-01-06'),
(8, 7, '2023-04-11'),
(9, 8, '2023-05-15'),
(9, 9, '2023-02-20'),
(10, 10, '2023-01-25'),
(10, 1, '2023-03-05');

/*Consultas*/

/*1.Listar todos los clientes:*/
SELECT c.id, c.dni, c.nombre , c.apellido , c.fecha_nacimiento , c.id_provincia , c.id_ciudad
FROM Clientes c;

/*2.Obtener todos los planes de internet con un precio mayor a 2000.00*/
SELECT * 
FROM planesInternet WHERE precio > 2000.00;

/*3.Encontrar todos los clientes de una ciudad específica, por ejemplo, 'Córdoba'*/
SELECT c.id, c.nombre, c.apellido, ci.ciudad
FROM Clientes c join Ciudades ci on c.id_ciudad = ci.id
WHERE ci.ciudad = "Cordoba";

/*4.Mostrar todas las provincias:*/
SELECT p.id, p.provincia
FROM Provincias p;

/*5.Mostrar todas las ciudades*/
SELECT c.id, c.ciudad
FROM Ciudades c;

/*6.Consultar los clientes y los planes que poseen:*/
SELECT c.nombre, c.apellido, pi.id, pi.precio, pi.velocidad
FROM Clientes c JOIN ClientePlan cp on c.id = cp.id_cliente JOIN PlanesInternet pi on cp.id_plan = pi.id;

/*7.Buscar clientes cuyo nombre empiece con 'L':*/
SELECT c.id, c.nombre, c.apellido
FROM Clientes c
WHERE c.nombre LIKE "L%";

/*8.Mostrar las velocidades y precios de todos los planes de internet que ofrecen un descuento:*/
SELECT pi.velocidad, pi.precio 
FROM planesInternet pi WHERE descuento > 0;

/*9.Obtener todos los clientes (nombre y apellido), la provincia y ciudad donde residen:*/
SELECT c.nombre, c.apellido, p.provincia, ci.ciudad
FROM Clientes c JOIN Provincias p ON c.id_provincia = p.id JOIN Ciudades ci ON ci.id = c.id_ciudad;

/*10.Listar todos los planes de internet ordenados por precio de mayor a menor:*/
SELECT pi.id, pi.velocidad, pi.precio
 FROM planesInternet pi ORDER BY precio DESC;
    

