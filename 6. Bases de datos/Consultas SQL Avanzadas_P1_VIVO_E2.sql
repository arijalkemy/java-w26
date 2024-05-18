#Esquema BD para la gestión de libros de una biblioteca
drop database if exists biblioteca_db;
create database biblioteca_db;

use biblioteca_db;

create table Libro
(
id int primary key auto_increment,
titulo varchar(200) , #El titulo de un libro es unico?
editorial varchar(200),
area varchar(100)
);

create table Autor
(
id int primary key auto_increment,
nombre varchar(255) not null,
nacionalidad varchar(100)
);

create table LibroAutor
(
id_libro int,
id_autor int,
constraint id primary key (id_libro, id_autor),#(Autor1, Libro1), (Autor1, Libro1)
foreign key(id_libro) references Libro(id) 
	on delete restrict
    on update cascade,
foreign key(id_autor) references Autor(id) 
	on delete restrict
    on update cascade
);

create table Estudiante
(
id int primary key,
nombre varchar(200),
apellido varchar(200),
direccion varchar(200),
carrera varchar(200),
edad int
);

create table Prestamo
(
id_libro int not null,
id_lector int not null,
fecha_prestamo datetime,
fecha_devolucion datetime,
devuelto bit,
constraint id primary key(id_libro, id_lector),
foreign key(id_libro) references Libro(id)
	on delete restrict
    on update cascade,
foreign key(id_lector) references Estudiante(id)
	on delete restrict
    on update cascade
);

#Insección de datos

INSERT INTO Libro (titulo, editorial, area) VALUES
('Cien Años de Soledad', 'Editorial Sudamericana', 'Novela'),
('Don Quijote de la Mancha', 'Francisco de Robles', 'Novela'),
('El Aleph', 'Editorial Losada', 'Cuento'),
('Ficciones', 'Editorial Sur', 'Cuento'),
('Rayuela', 'Editorial Sudamericana', 'Novela'),
('El Universo: Guía de viaje', 'Salamandra', 'Ciencia'),
('Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía'),
('El Señor de los Anillos', 'Minotauro', 'Fantasía'),
('Introducción a la Informática', 'Alianza Editorial', 'Informática'),
('Base de Datos', 'Pearson', 'Informática');

#Autores
INSERT INTO Autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Miguel de Cervantes', 'Española'),
('Jorge Luis Borges', 'Argentina'),
('Julio Cortázar', 'Argentina'),
('J.K. Rowling', 'Británica'),
('J.R.R. Tolkien', 'Británica'),
('Pierre Simon', 'Francesa'),
('Marco Rossi', 'Italiana');

INSERT INTO LibroAutor (id_libro, id_autor) VALUES
(1, 1),  -- 'Cien Años de Soledad' por 'Gabriel García Márquez'
(2, 2),  -- 'Don Quijote de la Mancha' por 'Miguel de Cervantes'
(3, 3),  -- 'El Aleph' por 'Jorge Luis Borges'
(4, 3),  -- 'Ficciones' por 'Jorge Luis Borges'
(5, 4),  -- 'Rayuela' por 'Julio Cortázar'
(6, 7),  -- 'El Universo: Guía de viaje' por 'Pierre Simon'
(7, 5),  -- 'Harry Potter y la Piedra Filosofal' por 'J.K. Rowling'
(8, 6),  -- 'El Señor de los Anillos' por 'J.R.R. Tolkien'
(9, 8),  -- 'Introducción a la Informática' por 'Marco Rossi'
(10, 8); -- 'Base de Datos' por 'Marco Rossi'


INSERT INTO Estudiante (id, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 21),
(2, 'María', 'González', 'Avenida Siempre Viva 456', 'Medicina', 23),
(3, 'Luis', 'Martínez', 'Calle Luna 789', 'Derecho', 22),
(4, 'Ana', 'Rodríguez', 'Pasaje Estrella 101', 'Arquitectura', 20),
(5, 'Pedro', 'López', 'Boulevard Sol 102', 'Economía', 24),
(6, 'Carla', 'Gómez', 'Calle Sol 104', 'Informática', 22),
(7, 'José', 'Fernández', 'Calle Estrella 105', 'Informática', 25),
(8, 'Filippo', 'Galli', 'Via Roma 206', 'Informática', 21);


INSERT INTO Prestamo (id_libro, id_lector, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2024-01-01 10:00:00', '2024-01-15 10:00:00', 1),  -- 'Cien Años de Soledad' prestado y devuelto
(2, 2, '2024-02-01 12:00:00', '2024-02-15 12:00:00', 0),  -- 'Don Quijote de la Mancha' prestado y no devuelto
(3, 3, '2024-03-01 14:00:00', '2024-03-10 14:00:00', 1),  -- 'El Aleph' prestado y devuelto
(4, 3, '2024-04-01 16:00:00', '2024-04-20 16:00:00', 0),  -- 'Ficciones' prestado y no devuelto
(5, 4, '2024-05-01 18:00:00', '2024-05-10 18:00:00', 1),  -- 'Rayuela' prestado y devuelto
(6, 8, '2024-06-01 10:00:00', '2024-06-15 10:00:00', 0),  -- 'El Universo: Guía de viaje' prestado a Filippo Galli
(10, 8, '2021-07-01 10:00:00', '2021-07-16 10:00:00', 1); -- 'Base de Datos' prestado y devuelto

#Consultas

#1
select * from Autor;

#2
select nombre, edad from Estudiante;

#3
select nombre, edad from Estudiante
where carrera = "informática";

#4
select nombre,nacionalidad from Autor
where nacionalidad = "Francesa" or nacionalidad = "Italiana";

#5
select * from Libro
where area <> "Internet";

#6
select * from Libro
where editorial = "Salamandra";

#7
select avg(edad) from Estudiante;
select * from Estudiante
where edad > (select avg(edad) from Estudiante);

#8

select nombre, edad, apellido from Estudiante
where apellido like "G%";

#9

select nombre, nacionalidad 
from LibroAutor al
	inner join Libro on al.id_libro = Libro.id
    inner join Autor on al.id_autor = Autor.id
where Libro.titulo = "El Universo: Guía de viaje";

#10

select apellido, nombre, titulo, editorial, area 
from Estudiante
	inner join Prestamo on Prestamo.id_lector = estudiante.id
	inner join Libro on Libro.id = Prestamo.id_libro
where nombre = "Filippo" and apellido = "Galli";

#11

select nombre, edad from Estudiante
order by edad asc
limit 1;

#12

select apellido, nombre, titulo, editorial, area 
from Estudiante
	inner join Prestamo on Prestamo.id_lector = estudiante.id
	inner join Libro on Libro.id = Prestamo.id_libro
where titulo like "Base de datos%";

#13

select nombre as Autor, titulo as Libro 
from Autor
	inner join LibroAutor on Autor.id = LibroAutor.id_autor
    inner join Libro on Libro.id = LibroAutor.id_libro
where nombre = "J.K. Rowling";

#14

select titulo, fecha_devolucion
from Prestamo
	inner join Libro on Prestamo.id_libro = Libro.id
where date(fecha_devolucion) = str_to_date("16/07/2021", "%d/%m/%Y"); # Validate date: select str_to_date("16/07/2021", "%d/%m/%Y");



