-- Listar los datos de los autores
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM ESTUDIANTE WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR WHERE nacionalidad IN ('Francesa', 'Italiana');

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE area <> 'Internet';

-- Listar los libros de la editorial Salamandra
SELECT * FROM LIBRO WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio
SELECT * FROM ESTUDIANTE WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT nombre FROM ESTUDIANTE WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres)
SELECT AUTOR.nombre 
FROM AUTOR 
INNER JOIN LIBRO_AUTOR ON AUTOR.id_autor = LIBRO_AUTOR.id_autor 
INNER JOIN LIBRO ON LIBRO_AUTOR.id_libro = LIBRO.id_libro 
WHERE LIBRO.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT LIBRO.* 
FROM LIBRO 
LEFT JOIN PRESTAMO ON LIBRO.id_libro = PRESTAMO.id_libro 
LEFT JOIN ESTUDIANTE ON PRESTAMO.id_lector = ESTUDIANTE.id_lector 
WHERE ESTUDIANTE.nombre = 'Filippo Galli';

-- Listar el nombre del estudiante de menor edad
SELECT nombre 
FROM ESTUDIANTE 
ORDER BY edad ASC 
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT ESTUDIANTE.nombre 
FROM ESTUDIANTE 
INNER JOIN PRESTAMO ON ESTUDIANTE.id_lector = PRESTAMO.id_lector 
INNER JOIN LIBRO ON PRESTAMO.id_libro = LIBRO.id_libro 
WHERE LIBRO.area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling
SELECT LIBRO.* 
FROM LIBRO 
INNER JOIN LIBRO_AUTOR ON LIBRO.id_libro = LIBRO_AUTOR.id_libro 
INNER JOIN AUTOR ON LIBRO_AUTOR.id_autor = AUTOR.id_autor 
WHERE AUTOR.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT LIBRO.titulo 
FROM LIBRO 
INNER JOIN PRESTAMO ON LIBRO.id_libro = PRESTAMO.id_libro 
WHERE PRESTAMO.fecha_devolucion = '2021-07-16';
