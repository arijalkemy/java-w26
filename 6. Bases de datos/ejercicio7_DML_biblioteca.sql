-- Se consultan todos los autores
SELECT *
FROM autor;

-- Se consulta el nombre y la edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

-- Se consulta el nombre y apellido de los estudiantes en la carrera de Informatica
SELECT nombre, apellido
FROM estudiante 
WHERE carrera = 'Informatica';

-- Se consulta el nombre y la nacionalidad de los autores con nacionalidad Francesa e Italiana
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

-- Se consulta toda la información de los libros que sean de diferentes areas al de Internet
SELECT *
FROM libro
WHERE area <> "Internet";

-- Se consulta toda la información de los libros de la editorial Salamandra
SELECT * 
FROM libro
WHERE editorial = 'Salamandra';

-- Se consulta el nombre, apellido y edad de los estudiantes con la edad mayor al promedio
SELECT nombre, apellido, edad
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Se consulta los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'G%';

-- Se consulta los autores del libro “El Universo: Guía de viaje”
SELECT au.nombre
FROM autor au INNER JOIN libro_autor la ON au.id = la.id_autor
	INNER JOIN libro li ON li.id = la.id_libro
WHERE li.titulo = 'El Universo: Guía de viaje';

-- Se consulta qué libros se prestaron al lector “Filippo Galli”
SELECT l.titulo
FROM libro l INNER JOIN prestamo p ON l.id = p.id_libro
 INNER JOIN estudiante e ON e.id = p.id_estudiante
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- Se consulta el nombre del estudiante de menor edad
SELECT nombre, apellido
FROM estudiante 
WHERE edad = (SELECT MIN(edad) FROM estudiante);

-- Se consulta los nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT e.nombre, e.apellido
FROM libro l INNER JOIN prestamo p ON l.id = p.id_libro
 INNER JOIN estudiante e ON e.id = p.id_estudiante
WHERE l.area = 'Bases de datos';

-- Se consulta los libros que pertenecen a la autora J.K. Rowling
SELECT li.titulo
FROM autor au INNER JOIN libro_autor la ON au.id = la.id_autor
	INNER JOIN libro li ON li.id = la.id_libro
WHERE au.nombre = 'J.K. Rowling';

-- Se consulta los títulos de los libros que debían devolverse el 16/07/2021
SELECT l.titulo
FROM libro l INNER JOIN prestamo p ON l.id = p.id_libro
WHERE fecha_devolucion = '2021-07-16';
