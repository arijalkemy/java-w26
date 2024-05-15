CREATE DATABASE IF NOT EXISTS biblioteca_db;

USE biblioteca_db;

CREATE TABLE libro (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    editorial VARCHAR(255) NOT NULL,
    area VARCHAR(100) NOT NULL
);

CREATE TABLE autor (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(100) NOT NULL
);

CREATE TABLE libro_autor (
    id_libro INT UNSIGNED,
    id_autor INT UNSIGNED,
    FOREIGN KEY (id_libro) REFERENCES libro(id),
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);

CREATE TABLE estudiante (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT UNSIGNED
);

CREATE TABLE prestamo (
    id_estudiante INT UNSIGNED,
    id_libro INT UNSIGNED,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (id_estudiante) REFERENCES estudiante(id),
    FOREIGN KEY (id_libro) REFERENCES libro(id)
);


INSERT INTO autor (nombre, nacionalidad) VALUES
    ('Gabriel García Márquez', 'Colombiana'),
    ('J.K. Rowling', 'Británica'),
    ('Stephen King', 'Estadounidense'),
    ('Albert Camus', 'Francesa'),
    ('Italo Calvino', 'Italiana'),
    ('Oliver Berry', 'Británica'),
    ('Mark A. Garlick', 'Británica'),
    ('Mark Mackenzie', 'Estadounidense'),
    ('Valerie Stimac', 'Estadounidense'),
    ('Abraham Silberschatz', 'Estadounidense'),
    ('Henry F. Korth', 'Estadounidense'),
    ('S. Sudarshan', 'Indio'),
    ('Anthony Molinaro', 'Estadounidense');

INSERT INTO libro (titulo, editorial, area) 
VALUES
    ('Cien años de soledad', 'Salamandra', 'Ficción'),
    ('El amor en los tiempos del cólera', 'Planeta', 'Romance'),
    ('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
    ('Harry Potter y la cámara secreta', 'Salamandra', 'Fantasía'),
    ('Harry Potter y el prisionero de Azkaban', 'Salamandra', 'Fantasía'),
    ('It', 'Penguin Random House', 'Terror'),
    ('El resplandor', 'DeBolsillo', 'Terror'),
    ('La peste', 'Alianza Editorial', 'Novela'),
    ('El extranjero', 'Gallimard', 'Novela'),
    ('Las ciudades invisibles', 'Siruela', 'Ficción'),
    ('Si una noche de invierno un viajero', 'DeBolsillo', 'Ficción'),
    ('El Universo: Guía de viaje', 'Cosmos', 'Ciencia'),
    ('Database System Concepts', 'McGraw-Hill', 'Bases de datos'),
    ('SQL Cookbook', 'O''Reilly Media', 'Bases de datos');


INSERT INTO libro_autor (id_libro, id_autor) VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 2),
    (5, 2),
    (6, 3),
    (7, 3),
    (8, 4),
    (9, 4),
    (10, 5),
    (11, 5),
    (12, 6),
    (12, 7),
    (12, 8),
    (12, 9),
    (13, 10),
    (13, 11),
    (13, 12),
    (14, 13);


INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
    ('Juan', 'Gómez', 'Calle 123', 'Informática', 22),
    ('María', 'López', 'Av. Principal', 'Derecho', 20),
    ('Pedro', 'Martínez', 'Carrera 45', 'Ingeniería Civil', 21),
    ('Filippo', 'Galli', 'Calle 67', 'Medicina', 23),
    ('Ana', 'Fernández', 'Av. Central', 'Arquitectura', 24),
    ('David', 'Pérez', 'Calle 89', 'Informática', 22);


INSERT INTO prestamo (id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
    (1, 1, '2021-06-15', '2021-07-15', TRUE),
    (1, 2, '2021-07-01', '2021-07-16', TRUE),
    (2, 3, '2021-05-20', '2021-07-10', TRUE),
    (3, 4, '2021-06-10', '2021-07-20', TRUE),
    (4, 5, '2021-07-05', '2021-07-15', TRUE),
    (5, 6, '2021-06-25', '2021-07-30', TRUE),
    (6, 7, '2021-07-10', '2021-07-25', TRUE),
    (2, 8, '2021-06-20', '2021-07-16', TRUE),
    (3, 9, '2021-05-15', '2021-07-18', TRUE),
    (4, 10, '2021-06-30', '2021-07-12', TRUE),
    (5, 11, '2021-07-05', '2021-07-22', TRUE),
    (6, 12, '2021-07-10', '2021-07-20', TRUE),
    (1, 6, '2021-07-15', '2021-07-30', TRUE),
    (2, 7, '2021-06-18', '2021-07-23', TRUE),
    (3, 8, '2021-05-25', '2021-07-10', TRUE),
    (4, 9, '2021-06-15', '2021-07-25', TRUE),
    (5, 10, '2021-07-01', '2021-07-18', TRUE),
    (6, 11, '2021-07-07', '2021-07-22', TRUE),
    (1, 12, '2021-07-20', '2021-07-30', FALSE),
    (2, 1, '2021-06-22', '2021-07-27', FALSE),
    (3, 2, '2021-05-28', '2021-07-14', FALSE),
    (4, 3, '2021-06-18', '2021-07-28', FALSE),
    (5, 4, '2021-07-05', '2021-07-20', FALSE),
    (6, 5, '2021-07-12', '2021-07-25', FALSE),
    (1, 13, '2021-06-15', '2021-07-15', TRUE),
    (1, 14, '2021-07-01', '2021-07-16', TRUE),
    (2, 13, '2021-05-20', '2021-07-10', TRUE),
    (3, 14, '2021-06-10', '2021-07-20', TRUE),
    (4, 13, '2021-07-05', '2021-07-15', TRUE),
    (5, 14, '2021-06-25', '2021-07-30', TRUE),
    (6, 13, '2021-07-10', '2021-07-25', TRUE);
