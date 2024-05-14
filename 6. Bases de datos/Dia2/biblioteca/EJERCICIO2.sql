/* Listar los datos de los autores. */

SELECT a.Nombre
FROM Autor a 

/* Listar nombre y edad de los estudiantes */

SELECT e.Nombre, e.Apellido, e.Edad 
FROM Estudiante e 

/* ¿Qué estudiantes pertenecen a la carrera informática? */

SELECT e.Nombre, e.Apellido
FROM Estudiante e 
WHERE e.Carrera LIKE 'Informatica'

/* ¿Qué autores son de nacionalidad francesa o italiana? */

SELECT a.Nombre , a.Nacionalidad 
FROM Autor a
WHERE a.Nacionalidad = 'Francés' OR a.Nacionalidad = "Italiano"

/* ¿Qué libros no son del área de internet? */

SELECT l.Titulo , l.Area 
FROM Libro l
WHERE l.Area != 'Internet' 

/* Listar los libros de la editorial Salamandra. */

SELECT l.Titulo 
FROM Libro l 
WHERE l.Editorial = 'Salamandra' 

/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */

SELECT CONCAT(e.Nombre, ' ', e.Apellido) nombre_apellido, e.Edad  
FROM Estudiante e 
WHERE e.Edad > (SELECT AVG(e2.Edad)
				FROM Estudiante e2)


/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
				
SELECT CONCAT(e.Apellido, ', ', e.Nombre) apellido_nombre
FROM Estudiante e 
WHERE e.Apellido LIKE "G%"
				
/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */

SELECT a.Nombre nombre_autor
FROM Autor a 
JOIN AutorLibro al ON a.idAutor = al.idAutor 
JOIN Libro l ON al.idLibro = l.idLibro
WHERE l.Titulo = "El Universo: Guía de viaje"

/* ¿Qué libros se prestaron al lector “Filippo Galli”? */

SELECT l.Titulo 
FROM Estudiante e 
JOIN Prestamo p ON e.idLector = p.idLector 
JOIN Libro l ON p.idLibro = l.idLibro 
WHERE e.Nombre = "Filippo" AND e.Apellido = "Galli"

/* Listar el nombre del estudiante de menor edad. */

SELECT CONCAT(e.Nombre, ' ', e.Apellido) nombre_apellido, e.Edad 
FROM Estudiante e
WHERE e.Edad = (SELECT MIN(e2.Edad)
				FROM Estudiante e2) 


/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */

SELECT CONCAT(e.Nombre, ' ', e.Apellido) nombre_apellido
FROM Estudiante e 
JOIN Prestamo p ON e.idLector = p.idLector 
JOIN Libro l ON p.idLibro = l.idLibro 
WHERE l.Area = 'Base de Datos' 

/* Listar los libros que pertenecen a la autora J.K. Rowling. */ 

SELECT l.Titulo 
FROM Autor a 
JOIN AutorLibro al ON a.idAutor = al.idAutor 
JOIN Libro l ON al.idLibro = l.idLibro 
WHERE a.Nombre = 'J.K. Rowling' 

/* Listar títulos de los libros que debían devolverse el 16/07/2021. */

SELECT l.Titulo 
FROM Libro l 
JOIN Prestamo p ON l.idLibro = p.idLibro 
WHERE p.FechaDevolucion < "2021-07-16"