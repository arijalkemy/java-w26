CREATE DATABASE biblioteca;
USE BIBLIOTECA;

CREATE TABLE Libro(
	idLibro INTEGER PRIMARY KEY NOT NULL,
	titulo VARCHAR(200) NOT NULL,
	editorial VARCHAR(200) NOT NULL,
	area VARCHAR(200) NOT NULL
);

CREATE TABLE Autor(
	idAutor INTEGER PRIMARY KEY NOT NULL,
	nombre VARCHAR(200) NOT NULL,
	nacionalidad VARCHAR(200) NOT NULl
);

CREATE TABLE LibroAutor(
	idAutor INTEGER NOT NULL,
	idLibro INTEGER NOT NULL,
	FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
	FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

CREATE TABLE Prestamo(
	idLector INTEGER NOT NULL,
	idLibro INTEGER NOT NULL,
	FechaPrestamo VARCHAR(100) NOT NULL,
	FechaDevolucion VARCHAR(100) NOT NULL,
	Devuelto VARCHAR(100) NOT NULL,
	CONSTRAINT prestamo_pk PRIMARY KEY (idLector),
	CONSTRAINT prestamo_libro_fk FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

CREATE TABLE Estudiante(
	idLector INTEGER NOT NULL,
	Nombre VARCHAR (100) NOT NULL,
	Apellido VARCHAR (100) NOT NULL,
	Direccion VARCHAR (120) NOT NULL,
	Carrera VARCHAR (100) NOT NULL,
	Edad INTEGER NOT NULL,
	CONSTRAINT estudiante_pk PRIMARY KEY (idLector)
);

INSERT INTO Autor (idAutor, nombre, nacionalidad)
VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Antoine de Saint-Exupéry', 'Francés'),
(3, 'George Orwell', 'Británica'),
(4, 'Jane Austen', 'Británica'),
(5, 'J.K. Rowling', 'Británica'),
(6, 'Patrick Rothfuss', 'Estadounidense'),
(7, 'Paulo Coelho', 'Brasileña'),
(8, 'Patrick Süskind', 'Alemán'),
(9, 'Carlos Ruiz Zafón', 'Española'),
(10, 'Gabriel García Márquez', 'Colombiana');


INSERT INTO Estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Literatura', 20),
(2, 'María', 'García', 'Avenida 456', 'Historia', 22),
(3, 'Carlos', 'López', 'Plaza Principal', 'Derecho', 21),
(4, 'Ana', 'Martínez', 'Calle Mayor', 'Psicología', 23),
(5, 'Pedro', 'Rodríguez', 'Avenida Central', 'Ingeniería', 20),
(6, 'Laura', 'Sánchez', 'Calle Secundaria', 'Medicina', 22),
(7, 'Diego', 'Fernández', 'Boulevard Norte', 'Economía', 21),
(8, 'Sofía', 'Hernández', 'Avenida Sur', 'Arquitectura', 23),
(9, 'Jorge', 'Díaz', 'Calle Este', 'Biología', 20),
(10, 'Marta', 'Ruiz', 'Plaza Oeste', 'Informática', 22);

INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES
(1, 'Cien años de soledad', 'Sudamericana', 'Ficción'),
(2, 'El principito', 'Salvat', 'Infantil'),
(3, '1984', 'Debolsillo', 'Ciencia Ficción'),
(4, 'Orgullo y prejuicio', 'Penguin Clásicos', 'Romance'),
(5, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(6, 'El nombre del viento', 'Plaza & Janés', 'Fantasía'),
(7, 'El alquimista', 'HarperCollins', 'Ficción'),
(8, 'El perfume', 'Seix Barral', 'Ficción'),
(9, 'La sombra del viento', 'Planeta', 'Ficción'),
(10, 'Crónica de una muerte anunciada', 'Literatura Random House', 'Ficción');

INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES
(11, 'Quibole', 'Sudamericana', 'Internet'),
(12, 'AppleSwift', 'Plaza & Janés', 'Internet');


INSERT INTO LibroAutor (idAutor, idLibro)
VALUES
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

INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES
(1, 1, '2024-05-01', '2024-05-15', 'Sí'),
(2, 5, '2024-05-02', '2024-05-16', 'Sí'),
(3, 8, '2024-05-03', '2024-05-17', 'No'),
(4, 4, '2024-05-04', '2024-05-18', 'Sí'),
(5, 3, '2024-05-05', '2024-05-19', 'No'),
(6, 6, '2024-05-06', '2024-05-20', 'Sí'),
(7, 2, '2024-05-07', '2024-05-21', 'No'),
(8, 9, '2024-05-08', '2024-05-22', 'Sí'),
(9, 7, '2024-05-09', '2024-05-23', 'No'),
(10, 10, '2024-05-10', '2024-05-24', 'Sí');


-- Listar los datos de los autores.
SELECT * FROM Autor a ;

-- Listar nombre y edad de los estudiantes

SELECT e.Nombre , e.Edad  FROM Estudiante e;

-- ¿Qué estudiantes pertenecen a la carrera informática?

SELECT e.Nombre FROM Estudiante e WHERE e.Carrera = "Informática";

-- ¿Qué autores son de nacionalidad Británica o Colombiana?

SELECT DISTINCT  a.nombre FROM Autor a WHERE a.nacionalidad = "Británica" OR  a.nacionalidad = 'Colombiana';

-- ¿Qué libros no son del área de internet?

SELECT l.titulo FROM Libro l WHERE l.area <> 'Internet' ;

-- Listar los libros de la editorial Salamandra

SELECT l.titulo  FROM Libro l WHERE l.editorial = 'Salamandra' ;

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.


SELECT AVG(e.edad) FROM Estudiante e ;

SELECT * FROM Estudiante e
WHERE e.Edad > (SELECT AVG(e2.Edad) FROM Estudiante e2)

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra M.

SELECT * FROM Estudiante e WHERE e.Nombre LIKE "M%";

-- Listar los autores del libro “Crónica de una muerte anunciada”. (Se debe listar solamente los nombres).

SELECT a.nombre  FROM Autor a
JOIN LibroAutor la ON la.idAutor = a.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE l.titulo = "Crónica de una muerte anunciada";


-- Listar el nombre del estudiante de menor edad

SELECT e.Nombre, MIN(e.Edad) AS min_edad FROM Estudiante e GROUP BY e.Nombre ORDER BY min_edad ASC LIMIT 1;


-- Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT l.titulo  FROM Libro l
JOIN LibroAutor la ON la.idLibro = l.idLibro
JOIN Autor a ON a.idAutor = la.idAutor
WHERE a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 2024-05-19

SELECT l.titulo FROM Libro l
JOIN Prestamo p ON p.idLibro = l.idLibro
WHERE p.Devuelto = 'No' AND p.FechaDevolucion < '2024-05-19'
