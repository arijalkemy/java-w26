create table libro(
idLibro INT primary key,
titulo VARCHAR(50),
editorial VARCHAR(50),
area VARCHAR(20)
);



create table estudiante(
idLector INT primary key,
nombre VARCHAR(20),
apellido VARCHAR(20),
direccion VARCHAR(20),
carrera VARCHAR(20),
edad INT
);

create table autor(
idAutor INT primary key,
nombre VARCHAR(20),
nacionalidad VARCHAR(20)
);

create table libroautor(
idAutor INT,
idLibro INT,
foreign key (idAutor) references autor(idAutor),
foreign key (idLibro) references libro(idLibro)
);

create table prestamo(
idLector INT,
idLibro INT,
fechaPrestamo DATE,
fechaDevolucion DATE,
devuelto bool,
foreign key (idLector) references estudiante(idLector),
foreign key (idLibro) references libro(idLibro)
);

-- autor
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (1, 'Gabriel Márquez', 'Colombiana');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (2, 'Isabel Allende', 'Chilena');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (3, 'Jorge Borges', 'Argentina');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (4, 'Mario Llosa', 'Peruana');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (5, 'Octavio Paz', 'Mexicana');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (6, 'Pablo Neruda', 'Chilena');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (7, 'Juan perez', 'Frances');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (8, 'juan Paz', 'Italiano');

-- LIBRO:
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (1, 'Cien años de soledad', 'Sudamericana', 'Novela');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (2, 'La casa de los espíritus', 'Plaza & Janés', 'Novela');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (3, 'Ficciones', 'Emecé', 'Cuento');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (4, 'La ciudad y los perros', 'Seix Barral', 'Novela');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (5, 'El laberinto de la soledad', 'Fondo de Cultura Económica', 'Ensayo');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (6, 'Veinte poemas de amor y una canción desesperada', 'Nascimento', 'Poesía');
-- ESTUDIANTE:
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (1, 'Ana', 'López', 'Calle 123', 'Literatura', 22);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (2, 'Carlos', 'Gómez', 'Avenida 456', 'Historia', 20);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (3, 'Laura', 'Martínez', 'Plaza 789', 'Filosofía', 21);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (4, 'Pedro', 'Sánchez', 'Calle 101', 'Ingeniería', 19);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (5, 'Sofía', 'Ramírez', 'Avenida 202', 'Medicina', 23);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (6, 'Miguel', 'Hernández', 'Calle 555', 'Derecho', 25);
-- LIBRO AUTOR:
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (1, 1);  
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (2, 2);  
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (3, 3);  
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (4, 4);  
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (5, 5);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (6, 6);

-- PRESTAMO:
INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (1, 1, '2024-04-01', '2024-04-15', true);
INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (2, 2, '2024-04-02', '2024-04-16', true);
INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (3, 3, '2024-04-03', '2024-04-17', true);
INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (4, 4, '2024-04-04', '2024-04-18', true);
INSERT INTO PRESTAMO (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES (5, 5, '2024-04-05', '2024-04-19', true);

-- 1
select idAutor, nombre, nacionalidad
from autor;

-- 2 
select nombre, edad
from estudiante;

-- 3
select idLector, nombre, apellido, direccion, edad
from estudiante
where carrera like 'Ingeniería';

-- 4
select idAutor, nombre
from autor
where nacionalidad in ('Italiano', 'Frances');

-- 5
select idLibro, titulo, editorial, area
from libro
where area not like 'Internet';

-- 6
select idLibro, titulo, area
from libro
where editorial like 'Nascimento';

-- 7
select e.idLector, e.nombre, e.apellido, e.edad
from estudiante e
where e.edad > (
	select avg(edad) from estudiante
)
;
-- 8
select e.nombre
from estudiante e 
where e.apellido like 'G%';

-- 9
select a.nombre
from autor a
join libroautor la on a.idAutor = la.idAutor
join libro l on la.idLibro = l.idLibro
where l.titulo like "El laberinto de la soledad";

-- 10

select l.titulo
from libro l
join prestamo p on l.idLibro = p.idLibro
join estudiante e on p.idLector = e.idLector
where e.nombre like "Pedro";


-- 11
select e.nombre
from estudiante e 
where e = (select min(edad) from estudiante);

-- 12
select e.nombre, e.apellido
from estudiante e
where e.idLector in (
	select idLector from prestamo
);

-- 13
select l.titulo
from libro l
join libroautor la on l.idLibro = la.idLibro
where la.idAutor = (select idAutor from autor where nombre like "Gabriel Márquez");

-- 14
select l.titulo
from libro l
where l.idLibro in (select idLibro from prestamo where fechaDevolucion like "2024-04-18")
;
