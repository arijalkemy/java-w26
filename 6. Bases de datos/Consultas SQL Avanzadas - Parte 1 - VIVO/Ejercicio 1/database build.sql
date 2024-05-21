-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS biblioteca;
-- Usar la base de datos
USE biblioteca;
-- Tabla libro
CREATE TABLE IF NOT EXISTS libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    editorial VARCHAR(255),
    area VARCHAR(255)
);
-- Tabla autor
CREATE TABLE IF NOT EXISTS autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    nacionalidad VARCHAR(255)
);
-- Tabla libro_autor (relación muchos a muchos entre libro y autor)
CREATE TABLE IF NOT EXISTS libro_autor (
    idAutor INT,
    idLibro INT,
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro),
    PRIMARY KEY (idAutor, idLibro)
);
-- Tabla prestamo
CREATE TABLE IF NOT EXISTS prestamo (
    idLector INT,
    idLibro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);
-- Tabla estudiante
CREATE TABLE IF NOT EXISTS estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    direccion VARCHAR(255),
    carrera VARCHAR(255),
    edad INT
);
10:42
-- Insertar datos en la tabla libro
INSERT INTO libro (titulo, editorial, area) VALUES
('El señor de los anillos', 'Minotauro', 'Fantasía'),
('Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía');
-- Insertar datos en la tabla autor
INSERT INTO autor (nombre, nacionalidad) VALUES
('J.R.R. Tolkien', 'Británica'),
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica');
-- Insertar datos en la tabla libro_autor
INSERT INTO libro_autor (idLibro, idAutor) VALUES
(1, 1), -- El señor de los anillos - J.R.R. Tolkien
(2, 2), -- Cien años de soledad - Gabriel García Márquez
(3, 3); -- Harry Potter y la piedra filosofal - J.K. Rowling
-- Insertar datos en la tabla estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle 123', 'Informática', 20),
('María', 'Gómez', 'Avenida Principal', 'Literatura', 22),
('Carlos', 'López', 'Carrera 45', 'Historia', 21),
('Laura', 'Martínez', 'Calle 56', 'Biología', 19),
('Pedro', 'Sánchez', 'Avenida Central', 'Arquitectura', 23),
('Ana', 'Rodríguez', 'Calle 78', 'Informática', 20),
('Miguel', 'García', 'Carrera 89', 'Medicina', 24),
('Sofía', 'Hernández', 'Avenida Norte', 'Psicología', 22),
('Diego', 'Martín', 'Calle Sur', 'Ingeniería Civil', 25),
('Elena', 'López', 'Carrera 10', 'Historia', 21);
-- Insertar datos en la tabla prestamo (añado algunos prestamos para estos estudiantes)
INSERT INTO prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2024-05-01', '2024-05-15', true), -- Juan presta El señor de los anillos
(2, 2, '2024-05-03', '2024-05-17', true), -- María presta Cien años de soledad
(3, 3, '2024-05-05', NULL, false), -- Carlos presta Harry Potter y la piedra filosofal
(4, 1, '2024-05-07', '2024-05-21', true), -- Laura presta El señor de los anillos
(5, 2, '2024-05-09', NULL, false), -- Pedro presta Cien años de soledad
(6, 3, '2024-05-11', '2024-05-25', true), -- Ana presta Harry Potter y la piedra filosofal
(7, 1, '2024-05-13', NULL, false), -- Miguel presta El señor de los anillos
(8, 2, '2024-05-15', '2024-05-29', true), -- Sofía presta Cien años de soledad
(9, 3, '2024-05-17', NULL, false), -- Diego presta Harry Potter y la piedra filosofal
(10, 1, '2024-05-19', NULL, false); -- Elena presta El señor de los anillos