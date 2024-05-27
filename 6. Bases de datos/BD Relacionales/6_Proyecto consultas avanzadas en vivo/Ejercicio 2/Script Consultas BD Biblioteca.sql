-- 1. Listar los datos de los autores.
SELECT * FROM autor;

-- 2. Listar nombre y edad de los estudiantes.
SELECT nombre, edad FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad IN ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE Area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
JOIN LibroAutor la ON a.idAutor = la.idAutor
JOIN libro l ON la.idLibro = l.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
ORDER BY edad ASC
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT e.nombre
FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON p.idLibro = l.idLibro
WHERE l.Area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM libro l
JOIN LibroAutor la ON l.idLibro = la.idLibro
JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
WHERE DATE(p.fechaDevolucion) = '2021-07-16';
