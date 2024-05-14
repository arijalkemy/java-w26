-- Datos de ejemplo para la tabla 'libro'
INSERT INTO libro (titulo, editorial, area) VALUES
('El Señor de los Anillos', 'Minotauro', 'Fantasía'),
('Cien años de soledad', 'Diana', 'Realismo mágico'),
('1984', 'Debolsillo', 'Ciencia ficción'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('El código Da Vinci', 'Umbriel', 'Misterio'),
('El Principito', 'Salamandra', 'Infantil');

-- Datos de ejemplo para la tabla 'autor'
INSERT INTO autor (nombre, nacionalidad) VALUES
('J.R.R. Tolkien', 'Inglaterra'),
('Gabriel García Márquez', 'Colombia'),
('George Orwell', 'Inglaterra'),
('J.K. Rowling', 'Reino Unido'),
('Dan Brown', 'Estados Unidos'),
('Antoine de Saint-Exupéry', 'Francia');

-- Datos de ejemplo para la tabla 'estudiante'
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Perez', 'Calle 123', 'Informática', 20),
('Maria', 'Gomez', 'Avenida 456', 'Arquitectura', 22),
('Luis', 'Martinez', 'Carrera 789', 'Derecho', 21),
('Ana', 'Rodriguez', 'Calle Principal', 'Medicina', 23),
('Carlos', 'Sanchez', 'Avenida Central', 'Administración', 24);

-- Datos de ejemplo para la tabla 'libroAutor'
INSERT INTO libroAutor (idLibro, idAutor) VALUES
(1, 1), -- El Señor de los Anillos - J.R.R. Tolkien
(2, 2), -- Cien años de soledad - Gabriel García Márquez
(3, 3), -- 1984 - George Orwell
(4, 4), -- Harry Potter y la piedra filosofal - J.K. Rowling
(5, 5), -- El código Da Vinci - Dan Brown
(6, 6); -- El Principito - Antoine de Saint-Exupéry

-- Datos de ejemplo para la tabla 'prestamo'
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2024-05-01 10:00:00', '2024-05-15 10:00:00', 1), -- Juan prestó El Señor de los Anillos
(2, 2, '2024-05-02 10:00:00', '2024-05-16 10:00:00', 0), -- Maria prestó Cien años de soledad (no devuelto aún)
(3, 3, '2024-05-03 10:00:00', '2024-05-17 10:00:00', 1), -- Luis prestó 1984
(4, 4, '2024-05-04 10:00:00', '2024-05-18 10:00:00', 1), -- Ana prestó Harry Potter y la piedra filosofal
(5, 5, '2024-05-05 10:00:00', '2024-05-19 10:00:00', 0); -- Carlos prestó El código Da Vinci (no devuelto aún)

-- Listar los datos de los autores.

SELECT * FROM autor a 

-- Listar nombre y edad de los estudiantes

SELECT e.nombre, e.apellido FROM estudiante e 

-- ¿Qué estudiantes pertenecen a la carrera informática?

SELECT e.nombre, e.apellido FROM estudiante e 
WHERE e.carrera LIKE 'Informática'

-- ¿Qué autores son de nacionalidad francesa o italiana?

SELECT a.nombre FROM autor a 
WHERE a.nacionalidad LIKE 'Francia' OR a.nacionalidad LIKE 'Italia'

-- ¿Qué libros no son del área de internet?

SELECT l.titulo  FROM libro l
WHERE l.area NOT LIKE 'Internet'

-- Listar los libros de la editorial Salamandra.

SELECT l.titulo FROM libro l
WHERE l.editorial LIKE 'Salamandra'

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT * FROM estudiante e 
WHERE e.edad > (SELECT AVG(e2.edad) FROM estudiante e2)

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT e.nombre FROM estudiante e 
WHERE e.nombre LIKE 'G%'

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT a.nombre FROM autor a 
INNER JOIN libroAutor la ON a.idAutor = la.idAutor 
INNER JOIN libro l ON la.idLibro = l.idLibro 
WHERE l.titulo LIKE 'El Universo: Guía de viaje'

-- ¿Qué libros se prestaron al lector “Filippo Galli”?

SELECT l.* FROM libro l 
INNER JOIN prestamo p ON l.idLibro = p.idLibro 
INNER JOIN estudiante e ON p.idLector = e.idLector 
WHERE e.nombre LIKE 'Filippo' AND e.apellido LIKE 'Galli'

-- Listar el nombre del estudiante de menor edad.

SELECT e.nombre FROM estudiante e 
WHERE e.edad = (SELECT MIN(e2.edad) FROM estudiante e2)

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT e.nombre FROM estudiante e 
INNER JOIN prestamo p ON e.idLector = p.idLector 
INNER JOIN libro l ON p.idLibro = l.idLibro 
WHERE l.area LIKE 'Base de Datos'

-- Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT l.titulo FROM libro l 
INNER JOIN libroAutor la ON l.idLibro = la.idLibro 
INNER JOIN autor a ON la.idAutor = a.idAutor 
WHERE a.nombre LIKE 'J.K. Rowling'

-- Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT l.titulo FROM libro l 
INNER JOIN prestamo p ON l.idLibro = p.idLibro 
WHERE p.fechaDevolucion = '2021-07-16'
