# Creacion
create database biblioteca;

CREATE TABLE autor (
    idAutor      integer auto_increment primary key,
    nombre       varchar(20) not null,
    nacionalidad varchar(20) not null
);

CREATE TABLE libro (
    idLibro   integer auto_increment primary key,
    titulo    varchar(50) not null,
    editorial varchar(50) not null,
    area      varchar(50) not null
);

CREATE TABLE libro_autor (
    idAutor integer not null,
    idLibro integer not null,
    foreign key (idAutor) references autor (idAutor),
    foreign key (idLibro) references libro (idLibro)
);

CREATE TABLE estudiante (
    idLector  integer auto_increment primary key,
    nombre    varchar(20) not null,
    apellido  varchar(20) not null,
    direccion varchar(20) not null,
    carrera   varchar(20) not null,
    edad      integer     not null
);

CREATE TABLE prestamo (
    idLector        integer not null,
    idLibro         integer not null,
    fechaPrestamo   date    not null,
    fechaDevolucion date    not null,
    devuelto        boolean default false,
    foreign key (idLector) references estudiante (idLector),
    foreign key (idLibro) references libro (idLibro)
);

# Inserción de datos

INSERT INTO autor (nombre, nacionalidad) VALUES
	('Edwin', 'Francesa'),
	('Matias', 'Argentina'),
	('Daniel', 'Mexico'),
	('J.K. Rowling', 'Estados Unidos');

INSERT INTO libro (titulo, editorial, area) VALUES
	('Harry Potter', 'Salamandra', 'Internet'),
	('Java', 'El mundo', 'Biblioteca'),
	('El Universo: Guía de viaje', 'Espectador', 'Internet'),
	('Hola Mundo', 'Universal', 'Sistemas');

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
	('Camilo', 'Cordoba', 'calle 1', 'Informatica', 18),
	('Marcos', 'Gomez', 'calle 2', 'Electronica', 22),
	('Brenda', 'Perez', 'calle 3', 'Informatica', 20),
	('Agustin', 'Bolaños', 'calle 4', 'Mecanica', 26),
	('Filippo', 'Galli', 'calle 5', 'Quimica', 20);

INSERT INTO libro_autor (idAutor, idLibro) VALUES
	(1, 4),
	(2, 3),
	(3, 2),
	(4, 1);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
	(5, 3, '2024-05-13', '2024-05-14', 0),
	(3, 2, '2021-07-09', '2021-07-16', 1);

# Querys

# 1. Listar los datos de los autores.
SELECT * FROM autor;

# 2. Listar nombre y edad de los estudiantes
SELECT nombre,edad FROM estudiante;

# 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informatica';

# 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad IN ('Francesa', 'Italiana');

# 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != 'Internet';

# 6. Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

# 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

# 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre  FROM estudiante WHERE apellido LIKE "G%";

# 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a
INNER JOIN libro_autor la ON a.idAutor = la.idAutor
INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";

# 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
INNER JOIN estudiante e ON e.idLector = p.idLector
WHERE CONCAT(e.nombre, CONCAT(" ",e.apellido)) = "Filippo Galli";

# 11. Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

# 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido FROM estudiante e
INNER JOIN prestamo p ON p.idLector = e.idLector;

# 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * FROM libro l
INNER JOIN libro_autor la ON l.idLibro = la.idLibro
INNER JOIN autor a ON a.idAutor = la.idAutor
WHERE a.nombre = "J.K. Rowling";


# 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = "2021-07-16";
