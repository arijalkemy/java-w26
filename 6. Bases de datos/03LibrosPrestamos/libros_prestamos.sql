/* 1. Listar los datos de los autores. */
SELECT *
FROM autor;

/* 2. Listar nombre y edad de los estudiantes */
SELECT nombre, edad
FROM estudiante;

/* 3. ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT * 
FROM estudiante
WHERE carrera = 'Informática';

/* 4. ¿Qué autores son de nacionalidad francesa o italiana? */
SELECT * 
FROM autor
WHERE nacionalidad = 'Francia' OR nacionalidad = 'Italia';

/* 4. ¿Qué libros no son del área de internet? */
SELECT *
FROM libro
WHERE area != 'Internet';

/* 5. Listar los libros de la editorial Salamandra. */
SELECT *
FROM libro
WHERE editorial = 'Salamandra';

/* 6. Listar los datos de los estudiantes cuya edad es mayor al promedio. */
SELECT *
FROM estudiante 
WHERE edad > (SELECT AVG(edad) FROM estudiante);

/* 7. Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
SELECT nombre
FROM estudiante
WHERE apellido LIKE 'G%';

/* 8. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */
SELECT *
FROM autor a 
LEFT JOIN libroAutor la ON a.idAutor = la.idAutor 
LEFT JOIN libro l ON la.idLibro = l.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje'; 

/* 9. ¿Qué libros se prestaron al lector “Filippo Galli”? */
SELECT *
FROM estudiante e
RIGHT JOIN prestamo p ON e.idLector = p.idLector
WHERE e.nombre = 'Filippo'
AND e.apellido = 'Galli';

/* 10. Listar el nombre del estudiante de menor edad. */
SELECT nombre 
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

/* 11. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */
SELECT *
FROM estudiante e 
RIGHT JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = 'Base de Datos';

/* 12. Listar los libros que pertenecen a la autora J.K. Rowling. */
SELECT l.* 
FROM libro l
INNER JOIN libroautor la ON l.idLibro = la.idLibro
INNER JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';

/* 13. Listar títulos de los libros que debían devolverse el 16/07/2021. */
SELECT l.titulo
FROM prestamo p 
INNER JOIN libro l ON p.idLibro = l.idLibro
WHERE fechaDevolucion LIKE '%2021-07-16%' AND devuelto = 1;