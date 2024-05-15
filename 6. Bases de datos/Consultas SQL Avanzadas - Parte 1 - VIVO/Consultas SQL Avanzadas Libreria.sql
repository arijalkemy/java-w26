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
    ('Cien años de soledad', 'Diana', 'Realismo mágico'),
    ('El Príncipe Nicolás Maquiavelo', 'Sabana', 'Filosofía'), 
    ('Padre Rico Padre Pobre', 'Mitchel', 'Crecimiento'),
    ('El Universo: Guía de viaje', 'Mitchel', 'Fantasía');

-- Insertar datos en la tabla AUTOR
INSERT INTO AUTOR (nombre, nacionalidad) VALUES
    ('J.R.R. Tolkien', 'Británica'),
    ('J.K. Rowling', 'Británica'),
    ('Gabriel García', 'Colombiana'),
    ('Nicolás Maquiavelo ', 'Italiana'),
    ('Kiyosaki Robert', 'Japonesa');

-- Insertar datos en la tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
	(6, 1),
    (6, 2),
    (6, 3);
    
-- Insertar datos en la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (nombre, apellido, direccion, carrera, edad) VALUES
    ('Juan', 'Pérez', 'Calle 123', 'Informática', 22),
    ('María', 'González', 'Av. Libertador', 'Medicina', 25),
    ('Luis', 'Sánchez', 'Calle 456', 'Informática', 23),
    ('Julio', 'Perez', 'Calle 345', 'Informática', 23),
    ('Marina', 'Jimenez', 'Calle 34', 'Medicina', 21);

# 1. Listar los datos de los autores.
SELECT * FROM AUTOR;

# 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM ESTUDIANTE;

# 3. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM ESTUDIANTE WHERE apellido LIKE 'G%';

# 4. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT au.nombre
FROM AUTOR au
INNER JOIN LIBROAUTOR liau
ON liau.idAutor = au.idAutor
INNER JOIN LIBRO li
ON li.idLibro = liau.idLibro
WHERE li.titulo = 'El Universo: Guía de viaje';


