# Creacion
create database biblioteca;

use biblioteca;

create table autor
(
    idAutor      integer auto_increment primary key,
    nombre       varchar(20) not null,
    nacionalidad varchar(20) not null
);

create table libro
(
    idLibro   integer auto_increment primary key,
    titulo    varchar(50) not null,
    editorial varchar(50) not null,
    area      varchar(50) not null
);

create table libro_autor
(
    idAutor integer not null,
    idLibro integer not null,
    foreign key (idAutor) references autor (idAutor),
    foreign key (idLibro) references libro (idLibro)
);


create table estudiante
(
    idLector  integer auto_increment primary key,
    nombre    varchar(20) not null,
    apellido  varchar(20) not null,
    direccion varchar(20) not null,
    carrera   varchar(20) not null,
    edad      integer     not null
);

create table prestamo
(
    idLector        integer not null,
    idLibro         integer not null,
    fechaPrestamo   date    not null,
    fechaDevolucion date    not null,
    devuelto        boolean default false,
    foreign key (idLector) references estudiante (idLector),
    foreign key (idLibro) references libro (idLibro)
);

# Data

INSERT INTO biblioteca.autor (idAutor, nombre, nacionalidad) VALUES (1, 'Edwin', 'Francesa');
INSERT INTO biblioteca.autor (idAutor, nombre, nacionalidad) VALUES (2, 'Matias', 'Argentina');
INSERT INTO biblioteca.autor (idAutor, nombre, nacionalidad) VALUES (3, 'Daniel', 'Mexico');
INSERT INTO biblioteca.autor (idAutor, nombre, nacionalidad) VALUES (4, 'J.K. Rowling', 'Estados Unidos');


INSERT INTO biblioteca.libro (idLibro, titulo, editorial, area) VALUES (1, 'Harry Potter', 'Salamandra', 'Internet');
INSERT INTO biblioteca.libro (idLibro, titulo, editorial, area) VALUES (2, 'Java', 'El mundo', 'Biblioteca');
INSERT INTO biblioteca.libro (idLibro, titulo, editorial, area) VALUES (3, 'El Universo: Guía de viaje', 'Espectador', 'Internet');
INSERT INTO biblioteca.libro (idLibro, titulo, editorial, area) VALUES (4, 'Hola Mundo', 'Universal', 'Sistemas');

INSERT INTO biblioteca.estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (1, 'Camilo', 'Cordoba', 'calle 1', 'Informatica', 18);
INSERT INTO biblioteca.estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (2, 'Marcos', 'Gomez', 'calle 2', 'Electronica', 22);
INSERT INTO biblioteca.estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (3, 'Brenda', 'Perez', 'calle 3', 'Informatica', 20);
INSERT INTO biblioteca.estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (4, 'Agustin', 'Bolaños', 'calle 4', 'Mecanica', 26);
INSERT INTO biblioteca.estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (5, 'Filippo', 'Galli', 'calle 5', 'Quimica', 20);

INSERT INTO biblioteca.libro_autor (idAutor, idLibro) VALUES (1, 4);
INSERT INTO biblioteca.libro_autor (idAutor, idLibro) VALUES (2, 3);
INSERT INTO biblioteca.libro_autor (idAutor, idLibro) VALUES (3, 2);
INSERT INTO biblioteca.libro_autor (idAutor, idLibro) VALUES (4, 1);

INSERT INTO biblioteca.prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (5, 3, '2024-05-13', '2024-05-14', 0);
INSERT INTO biblioteca.prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (3, 2, '2021-07-09', '2021-07-16', 1);

# Querys

# Listar los datos de los autores.
SELECT *
FROM autor;

# Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad
FROM estudiante e;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera LIKE 'Informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE nacionalidad IN ('Francesa', 'Italiana');

# ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE area != 'Internet';

# Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE libro.editorial LIKE 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.*
FROM estudiante e
WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.*
FROM estudiante e
WHERE e.apellido LIKE 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM libro_autor la
         INNER JOIN libro l on la.idLibro = l.idLibro
         INNER JOIN autor a on la.idAutor = a.idAutor
WHERE l.titulo LIKE 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM prestamo p
         INNER JOIN estudiante e on p.idLector = e.idLector
         INNER JOIN libro l on p.idLibro = l.idLibro
WHERE CONCAT(e.nombre, CONCAT(' '), e.apellido) LIKE 'Filippo Galli';

# Listar el nombre del estudiante de menor edad.
SELECT e.nombre
FROM estudiante e
WHERE edad = (SELECT MIN(edad) FROM estudiante);

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM prestamo p
         INNER JOIN estudiante e on p.idLector = e.idLector;

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM libro_autor la
         INNER JOIN libro l on la.idLibro = l.idLibro
         INNER JOIN autor a on la.idAutor = a.idAutor
WHERE a.nombre LIKE 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM prestamo p
         INNER JOIN libro l on p.idLibro = l.idLibro
WHERE p.fechaDevolucion = '2021-07-16';
