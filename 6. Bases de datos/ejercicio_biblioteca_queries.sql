-- Listar los datos de los autores.
select * from autores;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiantes;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiantes where carrera like 'Ingeniería Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autores where nacionalidad like 'Francia' or nacionalidad like 'Italia';

-- ¿Qué libros no son del área de internet?
select * from libros where area != 4;

-- Listar los libros de la editorial Salamandra.
select * from libros where editorial like '%Salamandra%';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiantes where edad > (select avg(edad) from estudiantes);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiantes where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select * from autores a inner join LibrosAutores la on a.idAutor = la.idAutor
inner join Libros l on la.idLibro = l.idLibro 
where l.titulo = 'El Universo: Guía de viaje'; 

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select titulo from libros l inner join prestamos p on l.idLibro = p.idLibro
inner join estudiantes e on e.idLector = p.idLector 
where e.nombre like 'Filippo' and e.apellido like 'Galli';

-- Listar el nombre del estudiante de menor edad.
select nombre from estudiantes order by edad asc limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre from estudiantes e inner join prestamos p on e.idLector = p.idLector
inner join libros l on l.idLibro = p.idLibro 
where l.area = 5;

-- Listar los libros que pertenecen a la autora J.R.R. Tolkien.
select * from libros l inner join librosautores la on l.idLibro = la.idLibro
inner join autores a on a.idAutor = la.idAutor
where a.nombre like 'J.R.R. Tolkien';

-- Listar títulos de los libros que debían devolverse el 14/05/2024.
select titulo from libros l inner join prestamos p on l.idLibro = p.idLibro
where p.fechaDevolucion = '2024-05-14'
