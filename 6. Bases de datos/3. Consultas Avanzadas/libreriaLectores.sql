CREATE DATABASE libreria;

CREATE TABLE LIBRO(
	idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50),
    editorial VARCHAR(20),
    area VARCHAR(20)
);

CREATE TABLE AUTOR(
	idAutor  INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    nacionalidad VARCHAR(20)
);

CREATE TABLE LIBROAUTOR(
	idAutor INT,
    idLibro INT,
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE ESTUDIANTE(
	idLector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    direccion VARCHAR(20),
    carrera VARCHAR(20),
    edad INT
);

CREATE TABLE PRESTAMO(
	idLector INT,
    idLibro INT,
    fechaDePrestamo DATE,
    fechaDeDevolucion DATE,
    Devuelto BOOLEAN,
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Insertar datos en la tabla LIBRO
INSERT INTO LIBRO (titulo, editorial, area) VALUES
    ('El Señor de los Anillos', 'Minotauro', 'Fantasía'),
    ('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
    ('Cien años de soledad', 'Diana', 'Realismo mágico');

-- Insertar datos en la tabla AUTOR
INSERT INTO AUTOR (nombre, nacionalidad) VALUES
    ('J.R.R. Tolkien', 'Británica'),
    ('J.K. Rowling', 'Británica'),
    ('Gabriel García', 'Colombiana');

-- Insertar datos en la tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
    (1, 1),
    (2, 2),
    (3, 3);
-- Insertar datos en la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (nombre, apellido, direccion, carrera, edad) VALUES
    ('Juan', 'Pérez', 'Calle 123', 'Informática', 22),
    ('María', 'González', 'Av. Libertador', 'Medicina', 25),
    ('Luis', 'Sánchez', 'Calle 456', 'Informática', 23);
    
-- 1. Listar los datos de los autores
SELECT * FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido FROM ESTUDIANTE WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre FROM AUTOR WHERE nacionalidad IN ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT titulo FROM LIBRO WHERE area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra
SELECT titulo FROM LIBRO WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio
SELECT * FROM ESTUDIANTE WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT nombre, apellido FROM ESTUDIANTE WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”
SELECT a.nombre
FROM AUTOR a
JOIN LIBROAUTOR la ON a.idAutor = la.idAutor
JOIN LIBRO l ON la.idLibro = l.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM LIBRO l
JOIN PRESTAMO p ON l.idLibro = p.idLibro
JOIN ESTUDIANTE e ON p.idEstudiante = e.idEstudiante
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad
SELECT nombre, apellido
FROM ESTUDIANTE
ORDER BY edad ASC
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT DISTINCT e.nombre, e.apellido
FROM ESTUDIANTE e
JOIN PRESTAMO p ON e.idEstudiante = p.idEstudiante
JOIN LIBRO l ON p.idLibro = l.idLibro
WHERE l.area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling
SELECT l.titulo
FROM LIBRO l
JOIN LIBROAUTOR la ON l.idLibro = la.idLibro
JOIN AUTOR a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT l.titulo
FROM LIBRO l
JOIN PRESTAMO p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = '2021-07-16';



