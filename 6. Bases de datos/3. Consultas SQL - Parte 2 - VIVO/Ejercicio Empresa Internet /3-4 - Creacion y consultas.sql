-- Se solicita crear una nueva base de datos llamada “empresa_internet”.
create database empresa_internet;
use empresa_internet;

create table plan_internet (
	id INTEGER PRIMARY KEY NOT NULL,
    velocidad_megas INTEGER,
    precio INTEGER,
    descuento INTEGER
);
create table cliente (
	id INTEGER PRIMARY KEY NOT NULL,
    dni VARCHAR(10),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
    idPlan INTEGER,
    FOREIGN KEY (idPlan) REFERENCES plan_internet(id)
);
-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
insert into plan_internet values
(1,150,50000.00,0),
(2,200,75000.00,10),
(3,250,90000.00,0),
(4,300,100000.00,15),
(5,500,150000.00,20);

insert into cliente values
(1, '41245956','Franco','Moises','2002-07-09','Cordoba','Cordoba', 5),
(2, '42059956','Mateo','Lopez','2002-07-09','Cordoba','Cordoba', 5),
(3, '44452356','Pedro','Perez','2002-07-09','Cordoba','Cordoba', 4),
(4, '44135956','Ignacio','Carraro','2002-07-09','Cordoba','Cordoba', 4),
(5, '44195096','Candelaria','Garcia','2002-07-09','Cordoba','Cordoba', 4),
(6, '44193956','Agustin','Tolosa','2002-07-09','Cordoba','Cordoba', 3),
(7, '33049385','Maximiliano','Fonseca','2002-07-09','Cordoba','Cordoba', 2),
(8, '44134956','Javier','Quinteros','2002-07-09','Cordoba','Cordoba', 2),
(9, '44195936','Oriana','Ficoceli','2002-07-09','Cordoba','Cordoba', 1),
(10, '44195954','Franco','Cortese','2002-07-09','Cordoba','Cordoba', 1);

-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

-- 1 Mostrar nombre y apellido de todos los clientes que contratan 300 megas
select c.nombre, c.apellido
from cliente c join plan_internet p
on c.idPlan = p.id
where p.velocidad_megas = 300;

-- 2 Mostrar nombre y costo de plan de clientes cuyo apellido empieze con la letra C
select c.nombre, c.apellido, p.precio
from cliente c join plan_internet p
on c.idPlan = p.id;
-- where upper(c.apellido) like 'C%';

-- 3 mostrar el top 3 de clientes con mayor gasto (aplicando el descuento)
select c.nombre, c.apellido, p.precio * ((100 - p.descuento))/100 as gasto
from cliente c join plan_internet p
on c.idPlan = p.id
order by gasto desc
limit 3;

-- 4 Mostrar los planes ordenados por precio y luego descuento
select id, velocidad_megas, precio, descuento
from plan_internet
order by precio, descuento;

-- 5 Mostrar todos los clientes
select * from cliente;

-- 6 Mostrar todos los clientes con todos los datos de sus planes
select c.id, c.nombre, c.apellido, c.dni, c.fecha_nacimiento, c.ciudad, 
	p.id as id_plan, p.velocidad_megas, p.precio, p.descuento,  
    p.precio * ((100 - p.descuento))/100 as precio_final
from cliente c join plan_internet p
on c.idPlan = p.id;

-- 7 Mostrar todos los clientes nacidos entre 1995 y 2003
select nombre, apellido, fecha_nacimiento
from cliente
where year(fecha_nacimiento) between 1995 and 2003;

-- 8 Mostrar todos los planes cuyo valor sea menor a 100000
select id, velocidad_megas, precio, descuento
from plan_internet
where precio < 100000;

-- 9 Mostrar todos los planes que no poseen descuento 
select id, velocidad_megas, precio, descuento
from plan_internet
where descuento <= 0;

-- 10 Mostrar todos los planes que poseen descuento
select id, velocidad_megas, precio, descuento
from plan_internet
where descuento > 0;
