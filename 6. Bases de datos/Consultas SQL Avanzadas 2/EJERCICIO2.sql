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

SELECT a.Nombre, a.Nacionalidad 
FROM Autor a 
WHERE a.Nacionalidad = 'Frances' OR a.Nacionalidad = 'Italiano'

/* ¿Qué libros no son del área de internet? */

SELECT l.Titulo, l.Area 
FROM Libro l 
WHERE l.Area NOT LIKE 'Internet'

/* Listar los libros de la editorial Salamandra. */

SELECT l.Titulo, l.Editorial  
FROM Libro l 
WHERE l.Editorial LIKE 'Salamandra'

/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */

SELECT e.Nombre, e.Apellido, e.Edad 
FROM Estudiante e 
WHERE e.Edad > (SELECT AVG(e2.Edad) FROM Estudiante e2) 

/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */

SELECT e.Nombre, e.Apellido
FROM Estudiante e 
WHERE e.Apellido LIKE 'G%'

/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */

SELECT a.Nombre 
FROM Autor a 
INNER JOIN AutorLibro al 	ON al.idAutor = a.idAutor 
INNER JOIN Libro l			ON al.idLibro  = l.idLibro AND l.Titulo LIKE 'El Universo: Guía de viaje'

/* ¿Qué libros se prestaron al lector “Filippo Galli”? */

SELECT l.Titulo
FROM Libro l 
INNER JOIN Prestamo p ON l.idLibro = p.idLibro 
WHERE p.idLector = (SELECT e.idLector FROM Estudiante e WHERE e.Nombre LIKE 'Filippo' AND e.Apellido LIKE 'Galli')

/* Listar el nombre del estudiante de menor edad. */

SELECT e.Nombre, e.Apellido, e.Edad 
FROM Estudiante e 
ORDER BY e.Edad ASC 
LIMIT 1

/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */

SELECT e.Nombre, e.Apellido
FROM Estudiante e 
INNER JOIN Prestamo p ON e.idLector = p.idLector 
INNER JOIN Libro l ON l.idLibro = p.idLibro AND l.Titulo LIKE 'Base de Datos'

/* Listar los libros que pertenecen a la autora J.K. Rowling. */

SELECT l.Titulo
FROM Libro l 
INNER JOIN AutorLibro al 	ON al.idLibro = l.idLibro  
INNER JOIN Autor a 			ON a.idAutor = al.idAutor AND a.Nombre LIKE 'J.K. Rowling'

/* Listar títulos de los libros que debían devolverse el 16/07/2021. */

SELECT l.Titulo
FROM Libro l
INNER JOIN Prestamo p ON l.idLibro = p.idLibro AND p.FechaDevolucion = '20210716'
