INSERT INTO Autor (nombre, nacionalidad) VALUES
('J.K. Rowling', 'británica'),
('Gabriel García Márquez', 'colombiana'),
('Isabel Allende', 'chilena'),
('Stephen King', 'estadounidense'),
('Haruki Murakami', 'japonesa'),
('Victor Hugo', 'francesa'),
('Albert Camus', 'francesa'),
('Marcel Proust', 'francesa'),
('Dante Alighieri', 'italiana'),
('Umberto Eco', 'italiana'),
('Italo Calvino', 'italiana'),
('Neil deGrasse Tyson', 'estadounidense'),
('Stephen Hawking', 'británica'),
('Carl Sagan', 'estadounidense');

INSERT INTO Estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'González', 'Calle 123', 'Informática', 20),
('María', 'López', 'Avenida 456', 'Derecho', 22),
('Carlos', 'Martínez', 'Carrera 789', 'Informática', 21),
('Laura', 'Pérez', 'Calle Principal', 'Medicina', 23),
('Ana', 'Sánchez', 'Calle Secundaria', 'Informática', 19),
('Filippo', 'Galli', 'Calle Principal', 'Informática', 21),
('Juan', 'Perez', 'Calle 123', 'Informática', 16),
('María', 'González', 'Avenida 456', 'Medicina', 17),
('Pedro', 'Martínez', 'Carrera 789', 'Derecho', 15);

INSERT INTO Libro (titulo, editorial, area) VALUES
('Cien años de soledad', 'Salamandra', 'Ficción'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('La Casa de los Espíritus', 'Penguin Random House', 'Ficción'),
('It', 'Penguin Random House', 'Terror'),
('Norwegian Wood', 'Vintage Books', 'Ficción'),
('Redes de Computadoras', 'McGraw-Hill', 'Internet'),
('Introducción a la Programación Web', 'Pearson', 'Internet'),
('Seguridad en Redes', "O'Reilly", 'Internet'),
('Diseño de Interfaces Web', 'Wiley', 'Internet'),
('Comercio Electrónico', 'Elsevier', 'Internet'),
('El Universo: Guía de viaje', 'National Geographic', 'Ciencia'),
('Fundamentos de Bases de Datos', 'Pearson', 'Base de Datos'),
('SQL Cookbook', 'O''Reilly', 'Base de Datos'),
('Database Design for Mere Mortals', 'Addison-Wesley', 'Base de Datos'),
('MySQL 8 Cookbook', 'Packt Publishing', 'Base de Datos'),
('Learning SQL', 'O''Reilly', 'Base de Datos'),
('Harry Potter y la cámara secreta', 'Salamandra', 'Fantasía'),
('Harry Potter y el prisionero de Azkaban', 'Salamandra', 'Fantasía');

INSERT INTO Prestamo (idLibro, idLector, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2024-05-01', '2024-05-15', 1),
(2, 2, '2024-04-20', '2024-05-10', 1),
(3, 3, '2024-05-05', '2024-05-20', 1),
(4, 4, '2024-04-15', '2024-04-30', 1),
(5, 5, '2024-04-25', '2024-05-05', 1),
(1, 6, '2024-04-10', '2024-04-25', 1),
(2, 6, '2024-03-20', '2024-04-10', 1),
(3, 6, '2024-04-05', '2024-04-20', 1),
(4, 6, '2024-03-15', '2024-03-30', 1),
(5, 6, '2024-03-25', '2024-04-05', 1),
(12, 1, '2024-05-01', '2024-05-15', 1),
(13, 3, '2024-04-20', '2024-05-10', 1),
(14, 5, '2024-05-05', '2024-05-20', 1),
(15, 6, '2024-04-15', '2024-04-30', 1),
(16, 6, '2024-04-25', '2024-05-05', 1),
(5, 1, '2021-07-01', '2021-07-16', 0),
(7, 2, '2021-07-05', '2021-07-16', 0);

INSERT INTO LibroAutor (idLibro, idAutor) VALUES
(1, 2),
(2, 1),
(17, 1),
(18, 1),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 12),
(11, 13),
(11, 14),
(11, 11); 

-- 1. Listar los datos de los autores.

SELECT * FROM autor;

-- 2. Listar nombre y edad de los estudiantes

SELECT nombre, apellido FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?

SELECT * FROM estudiante
WHERE carrera = 'informatica';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?

SELECT * FROM autor 
WHERE nacionalidad IN ('francesa', 'italiana');

-- 5. ¿Qué libros no son del área de internet?

SELECT * FROM libro 
WHERE area != 'internet';

-- 6. Listar los libros de la editorial Salamandra.

SELECT * FROM libro 
WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT * FROM estudiante
WHERE edad > (
	SELECT avg(edad) from estudiante
);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT nombre, apellido FROM estudiante
WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT nombre FROM libroautor lba
JOIN libro lb ON lb.idLibro = lba.idlibro
JOIN autor au ON au.idAutor = lba.idAutor
WHERE titulo LIKE '%guia de viaje%';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?

SELECT titulo, editorial, area FROM prestamo pr
JOIN estudiante et ON pr.idLector = et.idLector
JOIN libro lb ON lb.idLibro = pr.idLibro
WHERE nombre = 'Filippo' and apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.

SELECT nombre, apellido FROM estudiante 
WHERE edad < 18;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT nombre, apellido FROM prestamo pr
JOIN estudiante et ON pr.idLector = et.idLector
JOIN libro lb ON lb.idLibro = pr.idLibro
WHERE lb.area = 'Base de datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT titulo, area FROM libroAutor lba
JOIN libro lb ON lb.idLibro = lba.idLibro
JOIN autor au ON au.idAutor = lba.idAutor
WHERE nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT titulo FROM prestamo pr
JOIN libro lb ON lb.idLibro = pr.idLibro
WHERE fechaDevolucion = '2021-07-16';
