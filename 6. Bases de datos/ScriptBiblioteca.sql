USE biblioteca;

/** Listar los datos de los autores **/

SELECT
	*
FROM 
	autor;

/** Listar nombre y edad de los estudiantes **/

SELECT
	nombre,
    apellido
FROM 
	estudiante;

/** ¿Qué estudiantes pertenecen a la carrera informática? **/

SELECT
	*
FROM 
	estudiante
WHERE
	carrera = 'Informática';

/** ¿Qué autores son de nacionalidad francesa o italiana? **/

SELECT
	*
FROM 
	autor
WHERE
	nacionalidad like 'Frances%'
    OR
    nacionalidad like 'Italian&';

/** ¿Qué libros no son del área de internet? **/

SELECT
	*
FROM 
	libro
WHERE
	area = 'Internet';

/** Listar los libros de la editorial Salamandra **/

SELECT
	*
FROM 
	libro
WHERE
	editorial = 'Salamandra';

/** Listar los datos de los estudiantes cuya edad es mayor al promedio **/

SELECT
	*
FROM 
	estudiante
WHERE
	edad > (
		SELECT
			AVG(edad)
		FROM 
			estudiante
    );

/** Listar los nombres de los estudiantes cuyo apellido comience con la letra G **/

SELECT
	nombre
FROM 
	estudiante
WHERE
	nombre like 'G%';

/** Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres) **/

SELECT
	a.nombre
FROM 
	libro l
    LEFT JOIN
		libro_autor la
        ON
			la.id_libro = l.id_libro
    INNER JOIN
		autor a
        ON
			a.id_autor = la.id_autor
WHERE
	l.titulo = 'El Universo: Guía de viaje';

/** ¿Qué libros se prestaron al lector “Filippo Galli”? **/

SELECT
	l.titulo
FROM 
	estudiante e
    LEFT JOIN
		prestamo p
        ON
			e.id_lector = p.id_lector
    INNER JOIN
		libro l
        ON
			l.id_libro = l.id_libro
WHERE
	e.nombre = 'Filippo Galli';

/** Listar el nombre del estudiante de menor edad **/

SELECT 
	*
FROM
	estudiante
WHERE
	edad < 18
LIMIT 1;

/** Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos **/

SELECT
	e.nombre
FROM
	libro l
	LEFT JOIN 
		prestamo p
        ON
			p.id_libro = l.id_libro
	INNER JOIN
		estudiante e
        ON
			e.id_lector = p.id_lector
WHERE
	l.area = 'Base de Datos';

/** Listar los libros que pertenecen a la autora J.K. Rowling **/

SELECT
	l.*
FROM
	autor a
    LEFT JOIN
		libro_autor la
        ON
			la.id_autor = a.id_autor
	INNER JOIN
		libro l
        ON
			l.id_libro = l.id_libro
WHERE
	a.nombre = 'J.K. Rowling';
    

/** Listar títulos de los libros que debían devolverse el 16/07/2021 **/

SELECT
	l.titulo
FROM
	prestamo p
	LEFT JOIN
		libro l
        ON
			p.id_libro = l.id_libro
WHERE
	p.fecha_devolucion = '2021-07-16';