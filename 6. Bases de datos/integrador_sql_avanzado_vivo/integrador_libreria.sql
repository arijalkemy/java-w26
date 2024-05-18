/*
	Ejercicio integrador - SQL Avanzado VIVO 2
*/

-- 1:Listar los datos de los autores.
SELECT * FROM autor;

-- 2:Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM estudiante;

-- 3:¿Qué estudiantes pertenecen a la carrera informática?
SELECT  Nombre, Apellido, Direccion, Carrera, Edad FROM estudiante
WHERE Carrera LIKE 'Informática%';

-- 4:¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre, Nacionalidad FROM autor
WHERE Nacionalidad = 'Francesa' OR 'Italiana';

-- 5:¿Qué autores son de nacionalidad francesa o italiana?
SELECT Titulo, Editorial, Area FROM libro
WHERE Area != 'Internet';

-- 6:Listar los libros de la editorial Salamandra.
SELECT Titulo, Editorial, Area FROM libro
WHERE Editorial LIKE 'Salamandra%';

-- 7:Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT  Nombre, Apellido, Direccion, Carrera, Edad FROM estudiante
WHERE Edad > (SELECT AVG(Edad) FROM estudiante);

-- 8:Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT  Nombre, Apellido, Direccion, Carrera, Edad FROM estudiante
WHERE Apellido LIKE 'G%';

-- 9:Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT Nombre FROM autor
INNER JOIN libroautor ON autor.idAutor = libroautor.idAutor
INNER JOIN libro ON libro.idLibro = libroautor.idLibro
WHERE libro.Titulo = 'El Universo: Guía de viaje';

-- 10:¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT Titulo FROM libro
INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
INNER JOIN estudiante ON estudiante.idLector = prestamo.idLector
WHERE estudiante.Nombre = 'Filippo' AND estudiante.Apellido = 'Galli';

-- 11:Listar el nombre del estudiante de menor edad.
SELECT Nombre, Edad FROM estudiante
WHERE Edad <= (
	SELECT MIN(Edad) FROM estudiante
    );

-- 12:Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT Nombre, Apellido FROM estudiante
INNER JOIN prestamo ON estudiante.idLector = prestamo.idLector
INNER JOIN libro ON libro.idLibro = prestamo.idLibro
WHERE libro.Titulo = (SELECT Titulo FROM libro WHERE Titulo = 'Base de Datos');

-- 13:Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT Nombre, Titulo, Editorial, Area FROM libro
INNER JOIN libroautor ON libro.idLibro = libroautor.idLibro
INNER JOIN autor ON autor.idAutor = libroautor.idAutor
WHERE autor.Nombre LIKE 'J.K. Rowling';

-- 14:Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT Titulo, Editorial, Area, FechaDevolucion, Devuelto FROM libro
RIGHT JOIN prestamo ON libro.idLibro = prestamo.idLibro
WHERE FechaDevolucion <= '2021-07-16';



