-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS library_db;

-- Use the created database
USE library_db;

-- Tabla Libro
CREATE TABLE Libro (
    id_libro INT PRIMARY KEY,
    titulo VARCHAR(100),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

-- Tabla Autor
CREATE TABLE Autor (
    id_autor INT PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE Libro_Autor (
    id_autor INT,
    id_libro INT,
    FOREIGN KEY (id_autor) REFERENCES Autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro),
    PRIMARY KEY (id_autor, id_libro)
);

-- Tabla Estudiante
CREATE TABLE Estudiante (
    id_lector INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(100),
    carrera VARCHAR(50),
    edad INT
);

-- Tabla Prestamo
CREATE TABLE Prestamo (
    id_lector INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (id_lector) REFERENCES Estudiante(id_lector),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
);

-- Insertar datos de ejemplo
INSERT INTO Libro (id_libro, titulo, editorial, area) VALUES
(1, 'La Odisea', 'Alianza Editorial', 'Internet'),
(2, 'Cien años de soledad', 'Salamandra', 'Realismo mágico'),
(3, 'Introducción a la inteligencia artificial', 'MIT Press', 'Base de Datos'),
(4, 'El Universo: Guía de viaje', 'Salamandra', 'Fantasía'),
(5, 'Breve historia del tiempo', 'Salamandra', 'Internet');

INSERT INTO Autor (id_autor, nombre, nacionalidad) VALUES
(1, 'Homero', 'Francesa'),
(2, 'Gabriel García Márquez', 'Argentina'),
(3, 'Stuart Russell', 'Italiana'),
(4, 'J.K. Rowling', 'Colombiana'),
(5, 'Stephen Hawking', 'Francesa');

INSERT INTO Libro_Autor (id_autor, id_libro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO Estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Principal 123', 'Informática', 17),
(2, 'María', 'González', 'Avenida Libertad 456', 'Medicina', 22),
(3, 'Filippo', 'Galli', 'Calle Mayor 789', 'Informática', 21),
(4, 'Laura', 'Martínez', 'Paseo de la Reforma 101', 'Arquitectura', 23),
(5, 'Ana', 'Hernández', 'Carrera 7 205', 'Economía', 20);

INSERT INTO Prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2024-05-01', '2021-07-16', TRUE),
(2, 2, '2024-04-20', '2024-05-05', TRUE),
(3, 3, '2024-05-10', '2021-07-16', FALSE),
(4, 4, '2024-05-05', '2024-05-20', TRUE),
(5, 5, '2024-04-25', '2024-05-10', TRUE);

-- Queries

/* Listar los datos de los autores. */
SELECT * FROM autor;

/* Listar nombre y edad de los estudiantes */
SELECT e.nombre, e.edad FROM estudiante e;

/* ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT e.nombre, e.edad
FROM estudiante e
WHERE e.carrera LIKE 'Informática'
;

/* ¿Qué autores son de nacionalidad francesa o italiana? */
SELECT a.*
FROM autor a
WHERE a.nacionalidad = 'Francesa'
	OR a.nacionalidad = 'Italiana';

/* ¿Qué libros no son del área de internet? */
SELECT l.*
FROM libro l
WHERE l.area != 'Internet';

/* Listar los libros de la editorial Salamandra. */
SELECT l.*
FROM libro l
WHERE l.editorial = 'Salamandra';

/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */
SELECT e.*
FROM estudiante e
WHERE e.edad > (SELECT AVG(edad) FROM estudiante)
;

/* Listar los nombres de los estudiantes cuyo apellido
comience con la letra G. */
SELECT e.nombre, e.apellido
FROM estudiante e
WHERE e.apellido LIKE 'G%'
;

/* Listar los autores del libro “El Universo: Guía de viaje”.
(Se debe listar solamente los nombres). */
SELECT a.nombre
FROM autor a
JOIN libro_autor la ON a.id_autor = la.id_autor
JOIN libro l ON l.id_libro = la.id_libro
WHERE l.titulo = 'El Universo: Guía de viaje'
;

/* ¿Qué libros se prestaron al lector “Filippo Galli”? */
SELECT l.id_libro, l.titulo
FROM libro l
JOIN prestamo p ON p.id_libro = l.id_libro
JOIN estudiante e ON p.id_lector = e.id_lector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli'
;

/* Listar el nombre del estudiante de menor edad. */
SELECT e.nombre, e.apellido
FROM estudiante e
ORDER BY e.edad
LIMIT 1
;

/* Listar nombres de los estudiantes a los que se prestaron
libros de Base de Datos. */
SELECT e.nombre, e.apellido
FROM estudiante e
JOIN prestamo p ON p.id_lector= e.id_lector
JOIN libro l ON p.id_libro = l.id_libro
WHERE l.area = 'Base de Datos'
;

/* Listar los libros que pertenecen a la autora J.K. Rowling. */
SELECT l.titulo
FROM libro l
JOIN libro_autor la ON la.id_libro= l.id_libro
JOIN autor a ON a.id_autor = la.id_autor
WHERE a.nombre = 'J.K. Rowling'
;

/* Listar títulos de los libros que debían devolverse el 16/07/2021. */
SELECT l.titulo
FROM libro l
JOIN prestamo p ON p.id_libro = l.id_libro
WHERE p.fecha_devolucion = '2021-07-16'
;







