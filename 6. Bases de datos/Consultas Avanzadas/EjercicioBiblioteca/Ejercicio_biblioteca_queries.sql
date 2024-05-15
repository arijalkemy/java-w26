-- Listar los datos de los autores.
select *
from Autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad
from Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select e.*
from Estudiante e
where e.carrera like "Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
select *
from Autor
where nacionalidad in ("Francesa", "Italiana");

-- ¿Qué libros no son del área de internet?
select *
from Libro
where area not like "Internet";

-- Listar los libros de la editorial Salamandra.
select *
from Libro
where editorial like "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select *
from Estudiante 
where edad > (select avg(edad)
			  from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select *
from Estudiante 
where apellido like "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre
from Autor a
inner join LibroAutor la on la.idAutor = a.idAutor
inner join Libro l on l.idLibro = la.idLibro
where l.titulo like 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.*
from Libro l
inner join Prestamo p on p.idLibro = l.idLibro
inner join Estudiante e on e.idLector = p.idLector
where e.nombre like 'Filippo'
and e.apellido like 'Galli';

-- Listar el nombre del estudiante de menor edad.
select nombre
from Estudiante
order by edad
limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre
from Estudiante e
inner join Prestamo p on p.idLector = e.idLector
inner join Libro l on l.idLibro = p.idLibro
where l.area like "%Base de Datos%";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.*
from Libro l
inner join LibroAutor la on la.idLibro = l.idLibro
inner join Autor a on la.idAutor = a.idAutor
where a.nombre like "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo
from Libro l
inner join Prestamo p on p.idLibro = l.idLibro
where FechaDevolucion = STR_TO_DATE('16/07/2021', '%d/%m/%Y');