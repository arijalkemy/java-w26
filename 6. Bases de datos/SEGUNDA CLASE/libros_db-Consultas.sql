SELECT idAutor, Nombre, Nacionalidad
FROM autor;

SELECT Nombre, Edad
FROM estudiante;

SELECT Nombre, Apellido
FROM estudiante
WHERE Carrera='Informática';

SELECT idAutor, Nombre, Nacionalidad 
FROM autor 
WHERE Nacionalidad IN ('Francesa', 'Italiana');

SELECT idLibro, Titulo, Editorial, Area
FROM libro 
WHERE Area NOT IN ('Internet');

SELECT idLibro, Titulo, Editorial, Area
FROM libro 
WHERE Editorial = 'Salamandra';

SELECT idLector, Nombre, Apellido, Direccion, Carrera, Edad
FROM estudiante
WHERE Edad > (SELECT AVG(Edad) FROM estudiante);

SELECT Nombre, Apellido
FROM estudiante
WHERE Apellido LIKE 'G%';

SELECT Nombre
FROM autor a INNER JOIN libroautor la ON a.idAutor=la.idAutor
			   INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE l.Titulo='El Universo: Guía de viaje';

SELECT l.Titulo, l.Editorial
FROM estudiante e INNER JOIN prestamo p ON e.idLector = p.idLector
				  INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE e.Nombre = 'Filippo' AND e.Apellido = 'Galli';

SELECT Nombre, Apellido, Edad
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

SELECT e.Nombre, e.Apellido
FROM estudiante e INNER JOIN prestamo p ON e.idLector = p.idLector
				  INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE l.Area='Base de datos';

SELECT l.Titulo, l.Editorial
FROM libro l INNER JOIN libroautor la ON la.idLibro = l.idLibro
			 INNER JOIN autor a ON a.idAutor=la.idAutor
WHERE a.Nombre = 'J.K. Rowling';

SELECT l.Titulo, l.Editorial 
FROM libro l INNER JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.FechaDevolucion = '2021-07-16';
