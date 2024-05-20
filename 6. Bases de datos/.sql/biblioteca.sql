-- Listar los datos de los autores.
SELECT a.*
FROM autores a;

-- Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad
FROM estudiantes e;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.*
FROM estudiantes e
WHERE e.carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.*
FROM autores a
WHERE a.nacionalidad in ("francesa","italiana");

-- ¿Qué libros no son del área de internet?
SELECT l.*
FROM libros l
WHERE l.area != "internet";

-- Listar los libros de la editorial Salamandra.
SELECT l.*
FROM libros l
WHERE l.editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.*
FROM estudiantes
WHERE e.edad > (SELECT AVG(e2.edad)
                FROM estudiantes e2);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.nombre
FROM estudiantes
WHERE e.apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autores a
JOIN librosautor al ON al.idAutor = a.idAutor
JOIN libros l ON al.idLibro = l.idLibro
WHERE l.titulo = "El universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.*
FROM libros l
JOIN prestamos p ON p.idLibro = l.idLibro
JOIN estudiantes e ON p.idLector = e.idLector
WHERE e.nombre = "Filippo" AND
    e.apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido
FROM estudiantes e
WHERE e.edad = (SELECT MIN(e2.edad)
                FROM estudiantes e2
                WHERE e.idLector = e2.idLector);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM estudiantes e
JOIN prestamos p ON p.idLector = e.idLector
JOIN libros l ON p.idLibro = l.idLibro
WHERE l.titulo LIKE "%Base de datos%";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM libros l
JOIN librosautor al ON al.idLibro = l.idLibro
JOIN autores a ON al.idAutor = a.idAutor
WHERE a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libros l
JOIN prestamos p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = "16/07/2021";