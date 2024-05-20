CREATE TABLE AUTOR (
	id_autor VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE LIBRO (
	id_libro VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(50),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

CREATE TABLE LIBRO_AUTOR (
    id_autor VARCHAR(10),
    id_libro VARCHAR(10),
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES AUTOR(id_autor),
    FOREIGN KEY (id_libro) REFERENCES LIBRO(id_libro)
);

CREATE TABLE ESTUDIANTE (
    id_lector VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(100),
    carrera VARCHAR(50),
    edad INT
);

CREATE TABLE PRESTAMO (
    id_lector VARCHAR(10),
    id_libro VARCHAR(10),
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (id_lector, id_libro),
    FOREIGN KEY (id_lector) REFERENCES ESTUDIANTE(id_lector),
    FOREIGN KEY (id_libro) REFERENCES LIBRO(id_libro)
);

-- Datos de prueba para la tabla AUTOR
INSERT INTO AUTOR (id_autor, nombre, nacionalidad) VALUES
('A001', 'Gabriel García Márquez', 'Colombiana'),
('A002', 'J.K. Rowling', 'Británica'),
('A003', 'Haruki Murakami', 'Japonesa'),
('A004', 'Charles Perault', 'Francesa');

-- Datos de prueba para la tabla AUTOR
INSERT INTO AUTOR (id_autor, nombre, nacionalidad) VALUEs
('A005', 'Mark A. Garlick', 'Britanica'),
('A006', 'Valerie Stimac', 'Americana'),
('A007', 'Oliver Berry', 'Britanica'),
('A008', 'Mark Mackenzie', 'Americana');


-- Datos de prueba para la tabla LIBRO
INSERT INTO LIBRO (id_libro, titulo, editorial, area) VALUES
('L004', 'Clean Code', 'ElonMusk', 'Internet');


-- Datos de prueba para la tabla LIBRO
INSERT INTO LIBRO (id_libro, titulo, editorial, area) VALUES
('L005', 'El Universo: Guía de viaje', 'ElonMusk', 'Internet');

-- Datos de prueba para la tabla LIBRO
INSERT INTO LIBRO (id_libro, titulo, editorial, area) VALUES
('L001', 'Cien años de soledad', 'n-a', 'Internet'),
('L002', 'El coronel no tiene quien le escriba', 'Elon', 'Internet'),
('L003', 'Tu cuerpo te ama', 'Musk', 'Internet');

-- Datos de prueba para la tabla LIBRO_AUTOR
INSERT INTO LIBRO_AUTOR (id_autor, id_libro) VALUES
('A001', 'L001'),
('A002', 'L002'),
('A003', 'L003');


-- Datos de prueba para la tabla LIBRO_AUTOR
INSERT INTO LIBRO_AUTOR (id_autor, id_libro) VALUES
('A005', 'L005'),
('A006', 'L005'),
('A007', 'L005'),
('A008', 'L005');

-- Datos de prueba para la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
('E001', 'Juan', 'Pérez', 'Calle 123', 'Informática', 20),
('E002', 'María', 'Gómez', 'Avenida 456', 'Literatura', 22),
('E003', 'Carlos', 'López', 'Plaza Principal', 'Historia', 21),
('E004', 'Monica', 'López', 'calle 15', 'Matematicas', 23);

-- Datos de prueba para la tabla PRESTAMO
INSERT INTO PRESTAMO (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
('E001', 'L001', '2024-05-01', '2024-05-15', true),
('E002', 'L002', '2024-05-02', NULL, false),
('E003', 'L003', '2024-05-03', NULL, false);

#1.Listar los datos de los autores.

SELECT id_autor, nombre, nacionalidad
FROM AUTOR;

#2.Listar nombre y edad de los estudiantes

SELECT nombre, edad
FROM ESTUDIANTE;

#3.¿Qué estudiantes pertenecen a la carrera informática?

SELECT nombre, apellido
FROM ESTUDIANTE
WHERE carrera = 'Informatica';

#4.¿Qué autores son de nacionalidad francesa o italiana?

SELECT nombre
FROM AUTOR
WHERE nacionalidad IN ('Francesa', 'Italiana');

#5.¿Qué libros no son del área de internet?

SELECT titulo
FROM LIBRO
WHERE area != 'Internet';

#6.Listar los libros de la editorial Salamandra.

SELECT titulo
FROM LIBRO
WHERE editorial = 'Salamandra';

#7.Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT * FROM (
SELECT e.nombre, e.apellido, e.edad, e.direccion, e.carrera, (select AVG(e2.edad) from ESTUDIANTE e2) as promedio
FROM ESTUDIANTE e) subconsulta
WHERE edad > promedio;

#8.Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT apellido
FROM ESTUDIANTE
WHERE apellido LIKE "G%";

#9.Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre, l.titulo
FROM LIBRO_AUTOR la
INNER JOIN autor a ON la.id_autor = a.id_autor
INNER JOIN libro l ON la.id_libro = l.id_libro
WHERE titulo LIKE "%El Universo: Guía de viaje%";

#10.¿Qué libros se prestaron al lector Juan Perez”?
SELECT l.titulo
FROM LIBRO l
INNER JOIN prestamo p ON l.id_libro = p.id_libro
INNER JOIN estudiante e ON p.id_lector = e.id_lector
WHERE nombre LIKE "Juan" AND apellido LIKE "Pérez";

#11.Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido, e.edad
FROM estudiante e
WHERE edad = (SELECT MIN(edad) FROM estudiante);


#12.Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.


#13Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM LIBRO l
INNER JOIN libro_autor la ON l.id_libro = la.id_libro
INNER JOIN autor a ON la.id_autor = a.id_autor
WHERE nombre LIKE "J.K. Rowling";


#14Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM LIBRO l
INNER JOIN prestamo p ON l.id_libro = p.id_libro
INNER JOIN estudiante e ON p.id_lector = e.id_lector
WHERE FECHA_DEVOLUCION LIKE "2024-05-15"