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



/* ¿Qué libros no son del área de internet? */



/* Listar los libros de la editorial Salamandra. */



/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */



/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */
/* ¿Qué libros se prestaron al lector “Filippo Galli”? */
/* Listar el nombre del estudiante de menor edad. */
/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */
/* Listar los libros que pertenecen a la autora J.K. Rowling. */
/* Listar títulos de los libros que debían devolverse el 16/07/2021. */