#Listar los datos de los autores.
SELECT * FROM Autor;

#Listar nombre y edad de los estudiantes
SELECT e.nombre, e.apellido FROM Estudiante e;

#¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre, e.apellido FROM Estudiante e WHERE e.carrera = 'Informatica';

#¿Qué autores son de nacionalidad francesa o italiana?
SELECT au.nombre, au.nacionalidad FROM Autor au WHERE (nacionalidad = 'francesa' OR nacionalidad = 'italiana');

#¿Qué libros no son del área de internet?
SELECT l.titulo FROM Libro l WHERE area NOT LIKE '%internet%';

#Listar los libros de la editorial Salamandra.
SELECT l.titulo  FROM Libro l WHERE l.editorial = 'Salamandra'; 

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.nombre, e.edad FROM Estudiante e WHERE e.edad > (SELECT AVG(edad) FROM Estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.nombre FROM Estudiante e WHERE apellido LIKE 'G%';

#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM Autor a 
INNER JOIN LibroAutor la ON a.idAutor = la.idAutor 
INNER JOIN Libro l ON la.idLibro = l.idLibro 
WHERE l.titulo = 'El universo: Guia de viaje';

#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo  FROM Libro l
INNER JOIN Prestamo p ON l.idLibro = p.idLibro
INNER JOIN Estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

#Listar el nombre del estudiante de menor edad.
SELECT e.nombre FROM Estudiante e ORDER BY edad LIMIT 1;


#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre FROM Estudiante e
INNER JOIN Prestamo p ON e.idLector = p.idLector 
INNER JOIN Libro l ON p.idLibro = l.idLibro
WHERE l.area = 'Bases de datos';

#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM Libro l 
INNER JOIN LibroAutor la ON l.idLibro = la.idLibro 
INNER JOIN Autor a ON la.idAutor = a.idAutor 
WHERE a.nombre = 'J.K. Rowling';

#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM Libro l 
INNER JOIN Prestamo p ON l.idLibro = p.idLibro 
WHERE p.fechaDevolucion = '2021-07-16';

SHOW INDEX FROM ;
