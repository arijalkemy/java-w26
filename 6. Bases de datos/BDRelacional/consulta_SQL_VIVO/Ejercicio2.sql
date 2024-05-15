-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad IN ('Francia', 'Italia');

-- ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.nombre 
FROM autor JOIN libroAutor ON autor.idAutor = libroAutor.idAutor
JOIN libro ON libroAutor.idLibro = libro.idLibro
WHERE libro.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.titulo FROM libro
JOIN prestamo ON libro.idLibro = prestamo.idLibro
JOIN estudiante ON prestamo.idLector = estudiante.idLector
WHERE estudiante.nombre = 'Filippo' AND estudiante.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante ORDER BY edad ASC LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT estudiante.nombre FROM estudiante
JOIN prestamo ON estudiante.idLector = prestamo.idLector
JOIN libro ON prestamo.idLibro = libro.idLibro
WHERE libro.area = 'Base de Datos';


-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT libro.titulo FROM libro
JOIN libroAutor ON libro.idLibro = libroAutor.idLibro
JOIN autor ON libroAutor.idAutor = autor.idAutor
WHERE autor.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT libro.titulo FROM libro
JOIN prestamo ON libro.idLibro = prestamo.idLibro
WHERE prestamo.fechaDevolucion = '2021-07-16';

