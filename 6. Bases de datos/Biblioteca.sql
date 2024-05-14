CREATE DATABASE biblioteca;

use biblioteca;

-- Crear la tabla de libros
CREATE TABLE Libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    editorial VARCHAR(255),
    area VARCHAR(100)
);

-- Crear la tabla de autores
CREATE TABLE Autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(100)
);

-- Crear la tabla de relación entre libros y autores
CREATE TABLE LibroAutor (
    idLibro INT,
    idAutor INT,
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
    PRIMARY KEY (idLibro, idAutor)
);

-- Crear la tabla de préstamos
CREATE TABLE Prestamo (
    idPrestamo INT AUTO_INCREMENT PRIMARY KEY,
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

-- Crear la tabla de estudiantes
CREATE TABLE Estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
);

-- Insertar algunos registros de ejemplo
INSERT INTO Libro (titulo, editorial, area) VALUES
('El Señor de los Anillos', 'Minotauro', 'Fantasía'),
('Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
('Don Quijote de la Mancha', 'Editorial Planeta', 'Novela'),
('1984', 'Debolsillo', 'Ciencia ficción'),
('Harry Potter y la Piedra Filosofal', 'Salamanca', 'Fantasía');

INSERT INTO Autor (nombre, nacionalidad) VALUES
('J.R.R. Tolkien', 'Inglaterra'),
('Gabriel García Márquez', 'Colombia'),
('Miguel de Cervantes', 'España'),
('George Orwell', 'Inglaterra'),
('J.K. Rowling', 'Reino Unido');

INSERT INTO LibroAutor (idLibro, idAutor) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Juan', 'Pérez', 'Calle 123', 'Ingeniería', 20),
('María', 'Gómez', 'Avenida 456', 'Medicina', 22),
('Carlos', 'López', 'Calle Principal', 'Derecho', 21);

INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2024-05-01', '2024-05-15', TRUE),
(2, 3, '2024-04-20', '2024-05-05', FALSE),
(3, 5, '2024-05-10', NULL, FALSE);


commit ;
