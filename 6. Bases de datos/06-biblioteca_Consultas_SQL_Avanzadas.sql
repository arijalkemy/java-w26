-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM ESTUDIANTE;

-- Listar nombre y edad de los estudiantes
SELECT * FROM ESTUDIANTE WHERE Carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM ACTOR WHERE Nacionalidad = "France";

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE Area != "internet";

-- Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO WHERE editorial = "Salamandra";

-- Listar todos los estudiantes cuya edad sea mayor al promedio
SELECT * FROM ESTUDIANTE WHERE edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- Listar el nombre de todos los estudiantes cuyo apellidio comience con la letra G
SELECT nombre FROM ESTUDIANTE WHERE apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT AUTOR.Nombre FROM AUTOR JOIN LIBROAUTOR ON AUTOR.idAutor = LIBROAUTOR.idAutor JOIN LIBRO ON LIBROAUTOR.idLibro = LIBRO.idLibro WHERE LIBRO.Título = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT LIBRO.Título
FROM LIBRO
JOIN PRESTAMO ON LIBRO.idLibro = PRESTAMO.idLibro
JOIN ESTUDIANTE ON PRESTAMO.idLector = ESTUDIANTE.idLector
WHERE ESTUDIANTE.Nombre = 'Filippo' AND ESTUDIANTE.Apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT Nombre, Apellido
FROM ESTUDIANTE
WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT ESTUDIANTE.Nombre, ESTUDIANTE.Apellido
FROM ESTUDIANTE
JOIN PRESTAMO ON ESTUDIANTE.idLector = PRESTAMO.idLector
JOIN LIBRO ON PRESTAMO.idLibro = LIBRO.idLibro
WHERE LIBRO.Area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT LIBRO.Título
FROM LIBRO
JOIN LIBROAUTOR ON LIBRO.idLibro = LIBROAUTOR.idLibro
JOIN AUTOR ON LIBROAUTOR.idAutor = AUTOR.idAutor
WHERE AUTOR.Nombre = 'J.K.' AND AUTOR.Apellido = 'Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT LIBRO.Título
FROM LIBRO
JOIN PRESTAMO ON LIBRO.idLibro = PRESTAMO.idLibro
WHERE PRESTAMO.FechaDevolucion = '2021-07-16';
