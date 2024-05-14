-- Listar los datos de los autores.
SELECT * from autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad  from estudiante e;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM  estudiante e where carrera = 'Ingeniería Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * from autor a where nacionalidad in ('Francesa', 'Italiana');

-- ¿Qué libros no son del área de internet?
SELECT * from libro l where area <> 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * from libro l where editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante e where edad > (SELECT AVG(edad) FROM estudiante e2);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select * from estudiante e where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre  from autor a inner join libroAutor la on a.idAutor = la.idAutor inner join libro l on la.idLibro = l.idLibro where l.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo from estudiante e inner join prestamo p on e.idLector = p.idLector inner join libro l on p.idLibro = l.idLibro where e.nombre = 'Filippo' and apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido from estudiante e order by edad asc LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido from estudiante e inner join prestamo p on e.idLector = p.idLector inner join libro l on p.idLibro = l.idLibro where l.area = 'Bases de datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo from libro l inner join libroAutor la on l.idLibro = la.idLibro inner join autor a on la.idAutor = a.idAutor where a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo from libro l inner join prestamo p on l.idLibro = p.idLibro where p.fechaDevolucion = '2021-07-16';
