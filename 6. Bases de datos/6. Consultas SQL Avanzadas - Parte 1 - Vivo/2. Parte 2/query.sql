-- 1: Creacion de la base de datos 
CREATE DATABASE LIBROS; 

USE LIBROS; 

create table libro(
	idLibro integer primary key not null, 
    titulo varchar(250) not null, 
    editorial varchar(250) not null, 
    `area` varchar(250) not null
); 

create table estudiante(
	idLector integer primary key not null, 
    nombre varchar(250) not null, 
    apellido varchar(250) not null, 
    direccion varchar(250) not null, 
    carrera varchar(250) not null, 
    edad varchar(250) not null
);

create table autor(
	idAutor integer primary key not null, 
    nombre varchar(250) not null, 
    nacionalidad varchar(250) not null
);

create table libroAutor(
	idAutor integer not null, 
    idLibro integer not null, 
	foreign key (idAutor) references autor(idAutor), 
    foreign key (idLibro) references libro(idLibro)
);

create table prestamo(
	idLector integer not null, 
    idLibro integer not null, 
    fechaPrestamo date not null, 
    fechaDevolucion date not null, 
    devuelto boolean not null, 
    foreign key (idLector) references estudiante(idLector), 
    foreign key (idLibro) references libro(idLibro)
);

-- 2: Inseracion de datos
-- Datos de inserción para la tabla de autores
INSERT INTO autor (idAutor, nombre, nacionalidad) VALUES
(1, 'J.R.R. Tolkien', 'Británica'),
(2, 'Gabriel García Márquez', 'Colombiana'),
(3, 'George Orwell', 'Británica'),
(4, 'Miguel de Cervantes', 'Española'),
(5, 'J.K. Rowling', 'Británica'),
(6, 'Jane Austen', 'Británica'),
(7, 'Albert Camus', 'Francesa'),
(8, 'Italo Calvino', 'Italiana'),
(9, 'Marcel Proust', 'Francesa'),
(10, 'Umberto Eco', 'Italiana');

-- Datos de inserción para la tabla de estudiantes
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Perez', 'Calle 123', 'Ingenieria Informatica', 21),
(2, 'Maria', 'Gonzalez', 'Avenida 456', 'Medicina', 20),
(3, 'Luis', 'Martinez', 'Carrera 789', 'Derecho', 22),
(4, 'Ana', 'Lopez', 'Calle Principal', 'Historia del Arte', 23),
(5, 'Pedro', 'Sanchez', 'Avenida Central', 'Administracion de Empresas', 24),
(6, 'Laura', 'Rodriguez', 'Calle Secundaria', 'Psicologia', 21),
(7, 'Carlos', 'Fernandez', 'Paseo Maritimo', 'Biologia', 22),
(8, 'Sofia', 'Hernandez', 'Plaza Mayor', 'Economia', 23),
(9, 'Filippo', 'Galli', 'Via Roma', 'Ingenieria Informatica', 25),
(10, 'Giuseppe', 'Giorgio', 'Piazza Navona', 'Ingenieria Informatica', 19);

-- Datos de inserción para la tabla de libros
INSERT INTO libro (idLibro, titulo, editorial, `area`) VALUES
(1, 'El señor de los anillos', 'Minotauro', 'Fantasía'),
(2, 'Cien años de soledad', 'Editorial Sudamericana', 'Realismo mágico'),
(3, '1984', 'Debolsillo', 'Ciencia ficción'),
(4, 'Don Quijote de la Mancha', 'Real Academia Española', 'Novela'),
(5, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(6, 'Orgullo y prejuicio', 'Alba Editorial', 'Romance'),
(7, 'El amor en los tiempos del cólera', 'Oveja Negra', 'Romance'),
(8, 'La Odisea', 'Alianza Editorial', 'Epopeya'),
(9, 'El Universo: Guía de viaje', 'Editorial Planetaria', 'Ciencia'),
(10, 'Bases de Datos Avanzadas', 'Ediciones Técnicas', 'Informática');

-- Datos de inserción para la tabla de préstamo
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2023-01-05', '2023-02-05', true),
(2, 2, '2023-02-10', '2023-03-10', true),
(3, 3, '2023-03-15', '2023-04-15', true),
(4, 4, '2023-04-20', '2023-05-20', true),
(5, 5, '2023-05-25', '2023-06-25', true),
(6, 6, '2023-06-30', '2023-07-30', true),
(7, 7, '2023-07-05', '2023-08-05', true),
(8, 8, '2023-08-10', '2023-09-10', true),
(9, 9, '2023-09-15', '2023-10-15', true),
(10, 10, '2023-10-20', '2023-11-20', true),
(1, 1, '2021-06-15', '2021-07-16', false),
(2, 2, '2021-06-20', '2021-07-16', false), 
(3, 3, '2021-06-25', '2021-07-16', false); 

-- Datos de inserción para la tabla de libroAutor
INSERT INTO libroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- 3: Queries 
use biblioteca; 

-- 1: Listar los datos d elos autores 
select * from autor; 

-- 2: Listar nombre y edad de los estudiantes 
select nombre, edad, carrera from estudiante; 

-- 3: Que estudiantes pertenecen a la carrera informatica? 
select nombre from estudiante where carrera = 'Ingenieria Informatica';

-- 4: ¿Qué autores son de nacionalidad francesa o italiana?
select nombre, nacionalidad from autor where lower(nacionalidad) = 'francesa' or lower(nacionalidad) = 'italiana';

-- 5: ¿Qué libros no son del área de internet?
select titulo from libro where lower(area) != 'internet';

-- 6: Listar los libros de la editorial Salamandra.
select * from libro where lower(editorial) = 'salamandra';

-- 7: Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- 8: Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante where lower(apellido) like 'g%';

-- 9: Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from autor a 
inner join libroAutor la on a.idAutor = la.idAutor 
inner join libro l on l.idLibro = la.idLibro
where l.titulo = 'El Universo: Guía de viaje';

-- 10: ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.titulo from libro l
inner join prestamo p on l.idLibro = p.idLibro 
inner join estudiante e on e.idLector = p.idLector 
where lower(e.nombre) = 'filippo' and lower(e.apellido) = 'galli';

-- 11: Listar el nombre del estudiante de menor edad.
select nombre from estudiante
where edad = (select min(edad) from estudiante);

-- 12: Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre from estudiante e
inner join prestamo p on p.idLector = e.idLector 
inner join libro l on l.idLibro = p.idLibro
where lower(l.titulo) like '%bases de datos%';

-- 13: Listar los libros que pertenecen a la autora J.K. Rowling. 
select l.titulo, l.editorial from libro l
inner join libroAutor la on l.idLibro = la.idLibro
inner join autor a on a.idAutor = la.idAutor
where lower(a.nombre) = 'j.k. rowling';

-- 14: Listar títulos de los libros que debían devolverse el 16/07/2021
select l.titulo from libro l
inner join prestamo p on l.idLibro = p.idLibro 
where p.fechaDevolucion = '2021/07/16';


