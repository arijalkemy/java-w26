-- 1 Listar los datos de los autores.
SELECT * FROM Autor; 

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM Estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido FROM Estudiante
	WHERE carrera LIKE "%Informatica%";
    
-- 4.¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre FROM Autor
	WHERE Nacionalidad LIKE "Italiana" OR Nacionalidad LIKE "Francesa";

-- 5.¿Qué libros no son del área de internet?
SELECT Titulo FROM Libro
	WHERE Area <> "Internet";
-- 6. Listar los libros de la editorial Salamandra.
SELECT Titulo FROM Libro
	WHERE Editorial LIKE "Sudamericana";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante e
	WHERE e.edad > (SELECT AVG(e.edad) FROM Estudiante e);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante e
	WHERE e.nombre LIKE "G%";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT * FROM autor a
	INNER JOIN libroAutor la ON la.idAutor = a.idAutor
		INNER JOIN libro l ON l.idLibro = la.idLibro
			WHERE l.titulo LIKE "El Universo: Guía de viaje%";
        
-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT * FROM prestamo p
	INNER JOIN estudiante e ON p.idLector = e.idLector
		WHERE e.nombre like "Filippo%" AND e.apellido like "Galli";

-- 11. Listar el nombre del estudiante de menor edad.
SELECT * FROM estudiante e
	WHERE e.edad = (SELECT min(e.edad) FROM Estudiante e);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT * FROM prestamo p
	INNER JOIN estudiante e ON p.idLector = e.idLector
		INNER JOIN libro l on l.idLibro = p.idLibro
			WHERE l.area LIKE "Base de Datos%";

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * FROM autor a
	INNER JOIN libroAutor la ON la.idAutor = a.idAutor
		INNER JOIN libro l ON l.idLibro = la.idLibro
			WHERE a.nombre LIKE "%Rowling%";

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM prestamo p
		INNER JOIN libro l on l.idLibro = p.idLibro
			WHERE fechaPrestamo =  "2023-07-16";