USE biblioteca;

-- Inserts para la tabla libro
INSERT INTO libro (titulo, editorial, area) VALUES
('El principito', 'Salamandra', 'Literatura'),
('Cien años de soledad', 'Debolsillo', 'Literatura'),
('Introducción a la inteligencia artificial', 'McGraw-Hill', 'Informática'),
('La Divina Comedia', 'Penguin Clásicos', 'Literatura'),
('El Perfume', 'Seix Barral', 'Literatura');

-- Inserts para la tabla autor
INSERT INTO autor (nombre, nacionalidad) VALUES
('Antoine de Saint-Exupéry', 'Francesa'),
('Gabriel García Márquez', 'Colombiana'),
('Dan Brown', 'Estadounidense'),
('Dante Alighieri', 'Italiana'),
('Patrick Süskind', 'Austriaca');

-- Inserts para la tabla estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Gómez', 'Calle 123', 'Ingeniería Civil', 20),
('María', 'Martínez', 'Avenida 456', 'Arquitectura', 22),
('Carlos', 'López', 'Calle Principal', 'Medicina', 21),
('Ana', 'Rodríguez', 'Calle Secundaria', 'Derecho', 23),
('Pedro', 'González', 'Avenida Central', 'Informática', 19);

-- Inserts para la tabla libroAutor
INSERT INTO libroAutor (idLibro, idAutor) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserts para la tabla prestamo
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2024-05-01', '2024-05-15', TRUE),
(2, 2, '2024-05-03', '2024-05-17', TRUE),
(3, 3, '2024-05-05', '2024-05-19', TRUE),
(4, 4, '2024-05-07', '2024-05-21', TRUE),
(5, 5, '2024-05-09', '2024-05-23', TRUE);


INSERT INTO autor (nombre, nacionalidad) VALUES ('Brian Greene', 'Estadounidense');
INSERT INTO libro (titulo, editorial, area) VALUES ('El universo: guía de viaje', 'Vintage Español', 'Ciencia');
INSERT INTO libroAutor (idLibro, idAutor) VALUES ((SELECT idLibro FROM libro WHERE titulo = 'El universo: guía de viaje'), (SELECT idAutor FROM autor WHERE nombre = 'Brian Greene'));
INSERT INTO autor (nombre, nacionalidad) VALUES ('Stephen Hawking', 'Británica');
INSERT INTO libroAutor (idLibro, idAutor) VALUES 
((SELECT idLibro FROM libro WHERE titulo = 'El universo: guía de viaje'), (SELECT idAutor FROM autor WHERE nombre = 'Stephen Hawking'));

SELECT * FROM autor;

SELECT nombre, edad FROM estudiante;

SELECT * FROM estudiante WHERE carrera LIKE "Informática";

SELECT * FROM autor WHERE nacionalidad LIKE "Francesa" OR nacionalidad LIKE "Italiana";

SELECT * FROM libro WHERE area NOT LIKE "Internet";

SELECT * FROM libro WHERE editorial LIKE "Salamandra";

SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

SELECT * FROM estudiante WHERE nombre LIKE "C%";

SELECT a.nombre, a.nacionalidad
FROM autor AS a 
INNER JOIN libroAutor AS la ON a.idAutor = la.idAutor
INNER JOIN libro AS l ON l.idLibro = la.idLibro
WHERE l.titulo LIKE "El universo: guía de viaje";

SELECT l.titulo, l.editorial
FROM libro AS l
INNER JOIN prestamo AS p ON p.idLibro = l.idLibro
INNER JOIN estudiante AS e ON p.idLector = e.idLector
WHERE e.nombre LIKE "Pedro" AND e.apellido LIKE "González";

SELECT nombre, apellido, edad FROM estudiante ORDER BY edad LIMIT 1;