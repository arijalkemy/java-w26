/* Listar los datos de los autores. */

SELECT *
FROM Autor a;

/* Listar nombre y edad de los estudiantes */

SELECT e.Nombre, e.Apellido, e.Edad 
FROM Estudiante e; 

/* ¿Qué estudiantes pertenecen a la carrera informática? */

SELECT e.Nombre, e.Apellido
FROM Estudiante e 
WHERE e.Carrera LIKE 'Informatica';

/* ¿Qué autores son de nacionalidad francesa o italiana? */

SELECT a.Nombre 
FROM Autor a 
WHERE a.Nacionalidad LIKE "Francés" OR 
		a.Nacionalidad LIKE "Italiano";


/* ¿Qué libros no son del área de internet? */

SELECT l.Titulo 
FROM Libro l 
WHERE l.Area <> "Informática";

/* Listar los libros de la editorial Salamandra. */

SELECT l.Titulo
FROM Libro l 
WHERE l.Editorial LIKE "Salamandra";

/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */

SELECT e.Nombre , e.Apellido , e.Carrera , e.Edad 
FROM Estudiante e 
WHERE e.Edad > (SELECT AVG(e2.Edad)  FROM Estudiante e2);

/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */

SELECT e.Nombre, e.Apellido 
FROM Estudiante e 
WHERE e.Apellido LIKE "G%";

/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */

SELECT a.Nombre 
FROM Autor a INNER JOIN AutorLibro al ON a.idAutor = al.idAutor 
	INNER JOIN Libro l ON l.idLibro = al.idLibro 
WHERE l.Titulo LIKE "El Universo: Guía de viaje";


/* ¿Qué libros se prestaron al lector “Filippo Galli”? */

SELECT l.Titulo 
FROM Libro l INNER JOIN Prestamo p ON l.idLibro  = p.idLibro 
WHERE p.idLector  IN (SELECT e.idLector
					FROM Estudiante e 
					WHERE e.Nombre LIKE "Filippo" AND e.Apellido LIKE "Galli");

/* Listar el nombre del estudiante de menor edad. */

SELECT e.Nombre
FROM Estudiante e 
ORDER BY e.Edad
LIMIT 1;

/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */

SELECT e.Nombre
FROM Estudiante e INNER JOIN Prestamo p ON e.idLector = p.idLector 
WHERE p.idLibro  IN (SELECT l.idLibro FROM Libro l
					WHERE l.Titulo LIKE "%Base de Datos%");

/* Listar los libros que pertenecen a la autora J.K. Rowling. */

SELECT l.Titulo 
FROM Autor a 
INNER JOIN AutorLibro al ON a.idAutor = al.idAutor 
INNER JOIN Libro l ON l.idLibro = al.idLibro 
WHERE a.Nombre LIKE "J. K. Rowling";

/* Listar títulos de los libros que debían devolverse el 16/07/2021. */

SELECT l.Titulo 
FROM Prestamo p JOIN Libro l ON l.idLibro = p.idLibro 
WHERE p.FechaDevolucion = "2021-07-16";
