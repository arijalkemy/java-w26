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
('A003', 'Haruki Murakami', 'Japonesa');

-- Datos de prueba para la tabla LIBRO
INSERT INTO LIBRO (id_libro, titulo, editorial, area) VALUES
('L001', 'Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
('L002', 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('L003', 'Tokio blues', 'Tusquets', 'Ficción');

-- Datos de prueba para la tabla LIBRO_AUTOR
INSERT INTO LIBRO_AUTOR (id_autor, id_libro) VALUES
('A001', 'L001'),
('A002', 'L002'),
('A003', 'L003');

-- Datos de prueba para la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
('E001', 'Juan', 'Pérez', 'Calle 123', 'Informática', 20),
('E002', 'María', 'Gómez', 'Avenida 456', 'Literatura', 22),
('E003', 'Carlos', 'López', 'Plaza Principal', 'Historia', 21);

-- Datos de prueba para la tabla PRESTAMO
INSERT INTO PRESTAMO (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
('E001', 'L001', '2024-05-01', '2024-05-15', true),
('E002', 'L002', '2024-05-02', NULL, false),
('E003', 'L003', '2024-05-03', NULL, false);

#Listar los datos de los autores.
#Listar nombre y edad de los estudiantes
#¿Qué estudiantes pertenecen a la carrera informática?
#¿Qué autores son de nacionalidad francesa o italiana?
#¿Qué libros no son del área de internet?
#Listar los libros de la editorial Salamandra.
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
#¿Qué libros se prestaron al lector “Filippo Galli”?
#Listar el nombre del estudiante de menor edad.
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
#Listar los libros que pertenecen a la autora J.K. Rowling.
#Listar títulos de los libros que debían devolverse el 16/07/2021.