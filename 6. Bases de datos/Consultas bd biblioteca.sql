# EJERCICIO 1

# 1. Listar los datos de los autores.
SELECT *
FROM autor;

# 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad
FROM estudiante;

# 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE Carrera = 'Informatica';

# 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE Nacionalidad = 'Francesa' OR Nacionalidad = 'Italiana';

# 5. ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE Area != 'Internet';

# 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE Editorial = 'Salamandra';

# 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE Edad > (SELECT AVG(Edad) FROM estudiante);

# 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre, Apellido
FROM estudiante
WHERE Apellido Like 'G%';

# 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT Nombre
FROM autor a 
INNER JOIN libroautor la ON a.idAutor=la.idAutor
INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE l.Titulo='El Universo: Guía de viaje';

# 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.Titulo, l.Editorial
FROM estudiante e 
INNER JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE e.Nombre = 'Filippo' AND e.Apellido = 'Galli';

# 11. Listar el nombre del estudiante de menor edad.
SELECT Nombre, Apellido, Edad
FROM estudiante
WHERE Edad < 18;

# 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre, e.Apellido
FROM estudiante e 
INNER JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro;

# 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.Titulo, l.Editorial
FROM libro l 
INNER JOIN libroautor la ON la.idLibro = l.idLibro
INNER JOIN autor a ON a.idAutor = la.idAutor
WHERE a.Nombre = 'J.K. Rowling';

# 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.Titulo, l.Editorial
FROM libro l INNER JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.FechaDevolucion = '2021-07-16';
