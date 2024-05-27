USE biblioteca;

-- Insertar datos en la tabla libro
INSERT INTO libro (idLibro, titulo, editorial, Area) VALUES
(1, 'Cien años de soledad', 'Sudamericana', 'Literatura'),
(2, 'El nombre de la rosa', 'Planeta', 'Filosofía'),
(3, 'El origen de las especies', 'Penguin Books', 'Ciencia'),
(4, '1984', 'Secker & Warburg', 'Ficción'),
(5, 'Don Quijote de la Mancha', 'Francisco de Robles', 'Literatura'),
(6, 'El Universo: Guía de viaje', 'Salamandra', 'Ciencia'),
(7, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(8, 'Introducción a Base de Datos', 'Salamandra', 'Base de Datos');

-- Insertar datos en la tabla autor
INSERT INTO autor (idAutor, nombre, nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Umberto Eco', 'Italiana'),
(3, 'Charles Darwin', 'Británica'),
(4, 'George Orwell', 'Británica'),
(5, 'Miguel de Cervantes', 'Española'),
(6, 'Autor Francés', 'Francesa'),
(7, 'J.K. Rowling', 'Británica');

-- Insertar datos en la tabla LibroAutor
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(7, 6),
(7, 7),
(7, 8);

-- Insertar datos en la tabla estudiante
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 21),
(2, 'María', 'González', 'Avenida Siempre Viva 456', 'Informática', 22),
(3, 'Carlos', 'Rodríguez', 'Boulevard de los Sueños Rotos 789', 'Derecho', 23),
(4, 'Ana', 'Martínez', 'Camino Real 101', 'Arquitectura', 24),
(5, 'Luis', 'Hernández', 'Paseo de la Reforma 202', 'Economía', 25),
(6, 'Filippo', 'Galli', 'Via Roma 300', 'Informática', 20);

-- Insertar datos en la tabla prestamo
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2024-05-01 10:00:00', '2024-05-15 10:00:00', FALSE),
(2, 2, '2024-05-02 11:00:00', '2024-05-16 11:00:00', TRUE),
(3, 3, '2024-05-03 12:00:00', '2024-05-17 12:00:00', FALSE),
(4, 4, '2024-05-04 13:00:00', '2024-05-18 13:00:00', TRUE),
(5, 5, '2024-05-05 14:00:00', '2024-05-19 14:00:00', FALSE),
(6, 6, '2024-05-10 15:00:00', '2024-05-24 15:00:00', TRUE),
(6, 8, '2021-07-01 16:00:00', '2021-07-16 16:00:00', FALSE);


