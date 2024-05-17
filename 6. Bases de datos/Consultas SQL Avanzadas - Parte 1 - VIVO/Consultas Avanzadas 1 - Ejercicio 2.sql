CREATE DATABASE biblioteca;
USE biblioteca;

-- Creación de la tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(255),
    Nacionalidad VARCHAR(100)
);

-- Creación de la tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(255),
    Editorial VARCHAR(255),
    Area VARCHAR(255)
);

-- Creación de la tabla LIBROAUTOR para gestionar la relación muchos a muchos entre LIBRO y AUTOR
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Creación de la tabla ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(255),
    Apellido VARCHAR(255),
    Dirección VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
);

-- Creación de la tabla PRESTAMO para gestionar los préstamos de libros a estudiantes
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Albert Camus', 'Francesa'),
(2, 'Umberto Eco', 'Italiana'),
(3, 'Gabriel García Márquez', 'Colombiana'),
(4, 'J.K. Rowling', 'Británica');

INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'El extranjero', 'Gallimard', 'Literatura'),
(2, 'El nombre de la rosa', 'DeBolsillo', 'Historia'),
(3, 'Cien años de soledad', 'Sudamericana', 'Literatura'),
(4, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(5, 'El Universo: Guía de viaje', 'Planeta', 'Ciencia');

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(1, 5);

INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Dirección, Carrera, Edad) VALUES
(1, 'Juan', 'Gómez', 'Calle Falsa 123', 'Informática', 20),
(2, 'Ana', 'Pérez', 'Avenida Siempre Viva 45', 'Literatura', 22),
(3, 'Luis', 'García', 'Ronda de Valencia 19', 'Informática', 23),
(4, 'Filippo', 'Galli', 'Via Larga 88', 'Filosofía', 19);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 2, '2021-06-01', '2021-07-01', TRUE),
(4, 5, '2021-06-15', '2021-07-16', FALSE),
(3, 4, '2021-06-20', '2021-07-20', TRUE),
(1, 3, '2021-06-25', '2021-07-25', TRUE);

-- 1. Listar los datos de los autores
SELECT * FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre FROM ESTUDIANTE WHERE Carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre FROM AUTOR WHERE Nacionalidad IN ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT Titulo FROM LIBRO WHERE Area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra
SELECT Titulo FROM LIBRO WHERE Editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT Nombre FROM ESTUDIANTE WHERE Apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres)
SELECT A.Nombre
FROM AUTOR A
JOIN LIBROAUTOR LA ON A.idAutor = LA.idAutor
JOIN LIBRO L ON LA.idLibro = L.idLibro
WHERE L.Titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT L.Titulo
FROM LIBRO L
JOIN PRESTAMO P ON L.idLibro = P.idLibro
JOIN ESTUDIANTE E ON P.idLector = E.idLector
WHERE E.Nombre = 'Filippo' AND E.Apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad
SELECT Nombre FROM ESTUDIANTE WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT DISTINCT E.Nombre
FROM ESTUDIANTE E
JOIN PRESTAMO P ON E.idLector = P.idLector
JOIN LIBRO L ON P.idLibro = L.idLibro
WHERE L.Area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling
SELECT L.Titulo
FROM LIBRO L
JOIN LIBROAUTOR LA ON L.idLibro = LA.idLibro
JOIN AUTOR A ON LA.idAutor = A.idAutor
WHERE A.Nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT L.Titulo
FROM LIBRO L
JOIN PRESTAMO P ON L.idLibro = P.idLibro
WHERE P.FechaDevolucion = '2021-07-16';
