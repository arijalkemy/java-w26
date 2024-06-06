-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM ESTUDIANTE;

-- Listar nombre y edad de los estudiantes
SELECT * FROM ESTUDIANTE WHERE Carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM ACTOR WHERE Nacionalidad = "France";

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE Area != "internet";

-- Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO WHERE editorial = "Salamandra";

-- Listar todos los estudiantes cuya edad sea mayor al promedio
SELECT * FROM ESTUDIANTE WHERE edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- Listar el nombre de todos los estudiantes cuyo apellidio comience con la letra G
SELECT nombre FROM ESTUDIANTE WHERE apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT AUTOR.Nombre FROM AUTOR JOIN LIBROAUTOR ON AUTOR.idAutor = LIBROAUTOR.idAutor JOIN LIBRO ON LIBROAUTOR.idLibro = LIBRO.idLibro WHERE LIBRO.Título = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT LIBRO.Título
FROM LIBRO
JOIN PRESTAMO ON LIBRO.idLibro = PRESTAMO.idLibro
JOIN ESTUDIANTE ON PRESTAMO.idLector = ESTUDIANTE.idLector
WHERE ESTUDIANTE.Nombre = 'Filippo' AND ESTUDIANTE.Apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT Nombre, Apellido
FROM ESTUDIANTE
WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT ESTUDIANTE.Nombre, ESTUDIANTE.Apellido
FROM ESTUDIANTE
JOIN PRESTAMO ON ESTUDIANTE.idLector = PRESTAMO.idLector
JOIN LIBRO ON PRESTAMO.idLibro = LIBRO.idLibro
WHERE LIBRO.Area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT LIBRO.Título
FROM LIBRO
JOIN LIBROAUTOR ON LIBRO.idLibro = LIBROAUTOR.idLibro
JOIN AUTOR ON LIBROAUTOR.idAutor = AUTOR.idAutor
WHERE AUTOR.Nombre = 'J.K.' AND AUTOR.Apellido = 'Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT LIBRO.Título
FROM LIBRO
JOIN PRESTAMO ON LIBRO.idLibro = PRESTAMO.idLibro
WHERE PRESTAMO.FechaDevolucion = '2021-07-16';

-- PARTE 2

CREATE DATABASE IF NOT EXISTS LIBRARY;
USE LIBRARY;

-- Tabla AUTOR
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Nacionalidad VARCHAR(255)
);

-- Tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Editorial VARCHAR(255),
    Area VARCHAR(255)
);

-- Tabla ESTUDIANTE
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Apellido VARCHAR(255) NOT NULL,
    Direccion VARCHAR(255),
    Carrera VARCHAR(255),
    Edad INT
);

-- Tabla LIBROAUTOR
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Tabla PRESTAMO
CREATE TABLE PRESTAMO (
    idPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- AUTOR
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad)
VALUES
    (1, 'J.K. Rowling', 'Británica'),
    (2, 'George R.R. Martin', 'Estadounidense'),
    (3, 'Stephen King', 'Estadounidense'),
    (4, 'Gabriel García Márquez', 'Colombiano'),
    (5, 'Haruki Murakami', 'Japonés');


-- LIBRO
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area)
VALUES
    (1, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
    (2, 'Juego de Tronos', 'Gigamesh', 'Fantasía'),
    (3, 'It (Eso)', 'Debolsillo', 'Terror'),
    (4, 'Cien años de soledad', 'Alfaguara', 'Realismo mágico'),
    (5, 'Tokio Blues (Norwegian Wood)', 'Tusquets', 'Ficción contemporánea');


-- ESTUDIANTE
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES
    (1, 'Juan', 'Pérez', 'Calle 123', 'Ingeniería', 22),
    (2, 'María', 'Gómez', 'Avenida 456', 'Medicina', 20),
    (3, 'Carlos', 'López', 'Plaza 789', 'Derecho', 23),
    (4, 'Ana', 'Rodríguez', 'Paseo 012', 'Arte', 21),
    (5, 'Pedro', 'Sánchez', 'Bulevar 345', 'Economía', 19);


-- LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);


-- PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion)
VALUES
    (1, 1, '2024-05-15', '2024-06-15'),
    (2, 3, '2024-04-20', '2024-05-20'),
    (3, 5, '2024-06-01', '2024-07-01'),
    (4, 2, '2024-05-10', '2024-06-10'),
    (5, 4, '2024-05-28', '2024-06-28');
