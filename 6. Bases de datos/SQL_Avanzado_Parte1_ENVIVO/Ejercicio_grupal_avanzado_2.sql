USE Ejercicio_SQL_Avanzado;

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Editorial VARCHAR(255) NOT NULL,
    Area VARCHAR(255) NOT NULL
);
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Nacionalidad VARCHAR(255) NOT NULL
);
CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Apellido VARCHAR(255) NOT NULL,
    Direccion VARCHAR(255) NOT NULL,
    Carrera VARCHAR(255) NOT NULL,
    Edad INT NOT NULL
);
CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE,
    Devuelto BOOLEAN NOT NULL,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Inserciones para la tabla LIBRO
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (1, 'Cien Años de Soledad', 'Sudamericana', 'Literatura');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (2, 'El Quijote', 'Santillana', 'Literatura');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (3, 'Introducción a la Programación', 'Pearson', 'Tecnología');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (4, 'Estructuras de Datos', 'McGraw-Hill', 'Tecnología');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (5, 'La Odisea', 'Penguin', 'Clásicos');
-- Inserciones para la tabla AUTOR
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (1, 'Gabriel García Márquez', 'Colombiana');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (2, 'Miguel de Cervantes', 'Española');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (3, 'Dennis Ritchie', 'Estadounidense');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (4, 'Thomas H. Cormen', 'Estadounidense');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (5, 'Homero', 'Griega');
-- Inserciones para la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (1, 'Carlos', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 21);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (2, 'Ana', 'García', 'Av. Siempre Viva 742', 'Literatura', 22);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (3, 'Luis', 'Martínez', 'Boulevard de los Sueños 456', 'Matemáticas', 23);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (4, 'María', 'Rodríguez', 'Calle de la Luz 789', 'Física', 24);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (5, 'Jorge', 'Hernández', 'Plaza Mayor 101', 'Química', 25);
-- Inserciones para la tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (1, 1);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (2, 2);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (3, 3);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (4, 4);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (5, 5);
-- Inserciones para la tabla PRESTAMO
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (1, 1, '2024-05-01', '2024-05-10', TRUE);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (2, 2, '2024-05-03', '2024-05-12', TRUE);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (3, 3, '2024-05-05', NULL, FALSE);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (4, 4, '2024-05-07', NULL, FALSE);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (5, 5, '2024-05-09', NULL, FALSE);

-- Listar los datos de los autores.
SELECT *
FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad
FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre
FROM ESTUDIANTE
WHERE Carrera = 'Ingeniería';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre
FROM AUTOR
WHERE Nacionalidad = 'Colombiana' OR Nacionalidad = 'Estadounidense';

-- ¿Qué libros no son del área de internet?
SELECT Titulo
FROM LIBRO
WHERE NOT Area = 'Internet';

-- Listar los libros de la editorial Sudamericana.
SELECT Titulo
FROM LIBRO
WHERE Editorial = 'Sudamericana';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM ESTUDIANTE
WHERE Edad > (SELECT avg(Edad)
FROM ESTUDIANTE);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre
FROM ESTUDIANTE
WHERE Apellido LIKE 'G%';

/*Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

¿Qué libros se prestaron al lector “Filippo Galli”?
Listar el nombre del estudiante de menor edad.
Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
Listar los libros que pertenecen a la autora J.K. Rowling.
Listar títulos de los libros que debían devolverse el 16/07/2021.
*/
