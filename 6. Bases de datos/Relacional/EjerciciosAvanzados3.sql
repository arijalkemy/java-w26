-- 1
SELECT * FROM AUTOR;

-- 2
SELECT NOMBRE, EDAD FROM ESTUDIANTE;

-- 3
SELECT * FROM ESTUDIANTE
WHERE carrera = 'Informática';

-- 4
SELECT * FROM AUTOR
WHERE nacionalidad = 'Francia' or nacionalidad = 'Italia';

-- 5
SELECT * FROM LIBRO
WHERE AREA <> "Internet";

-- 6
SELECT * FROM LIBRO WHERE EDITORIAL = 'Salamandra';

-- 7
SELECT * FROM ESTUDIANTE
WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);

-- 8
SELECT nombre FROM ESTUDIANTE
WHERE apellido LIKE 'G%';

-- 9
SELECT aut.* FROM AUTOR aut
INNER JOIN LIBRO_AUTOR la
INNER JOIN LIBRO l
ON aut.idAutor = la.idAutor AND l.idLibro = la.idLibro
WHERE l.titulo = "El Universo: Guía de Viaje";

-- 10
SELECT l.* FROM LIBRO l
INNER JOIN PRESTAMO p
INNER JOIN ESTUDIANTE e
ON l.idLibro = p.idLibro AND p.idLector = e.idLector
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

-- 11
SELECT nombre FROM ESTUDIANTE e
WHERE e.edad = (SELECT MIN(edad) FROM ESTUDIANTE)
LIMIT 1;

-- 12
SELECT nombre FROM ESTUDIANTE e
INNER JOIN PRESTAMO p
INNER JOIN LIBRO l
ON e.idLector = p.idLector AND p.idLibro = l.idLibro
WHERE l.area = "Bases de Datos";

-- 13
SELECT l.* FROM LIBRO l
INNER JOIN LIBRO_AUTOR la
INNER JOIN AUTOR a
ON l.idLibro = la.idLibro AND la.idAutor = a.idAutor
WHERE a.nombre = "J.K. Rowling";

-- 14
SELECT l.titulo FROM PRESTAMO p
INNER JOIN LIBRO l
ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = "2021-07-16" AND NOT p.devuelto;