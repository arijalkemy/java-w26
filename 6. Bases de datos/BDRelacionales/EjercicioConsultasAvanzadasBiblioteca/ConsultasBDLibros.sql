-- registros
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Filippo', 'Galli', '123 Main St', 'Ingeniería', 22),
(2, 'Maria', 'Lopez', '456 Oak St', 'Matemáticas', 21),
(3, 'John', 'Doe', '789 Pine St', 'Ciencias', 23),
(4, 'Ana', 'Perez', '321 Maple St', 'Literatura', 24),
(5, 'Lucas', 'Smith', '654 Cedar St', 'Historia', 22);

INSERT INTO autor (idAutor, Nombre, Nacionalidad) VALUES
(1, 'J.K. Rowling', 'Británica'),
(2, 'George R.R. Martin', 'Estadounidense'),
(3, 'Isaac Asimov', 'Rusa'),
(4, 'Agatha Christie', 'Británica'),
(5, 'J.R.R. Tolkien', 'Británica');

INSERT INTO libro (idLibro, titulo, editorial, area) VALUES
(1, 'Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
(2, 'Juego de Tronos', 'Bantam Books', 'Fantasía'),
(3, 'Fundación', 'Gnome Press', 'Ciencia Ficción'),
(4, 'Asesinato en el Orient Express', 'Collins Crime Club', 'Misterio'),
(5, 'El Señor de los Anillos', 'Allen & Unwin', 'Fantasía');

INSERT INTO libroautor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2021-07-01', '2021-07-16', 1),
(2, 2, '2021-06-15', '2021-07-16', 0),
(3, 3, '2021-07-05', '2021-07-20', 1),
(4, 4, '2021-07-10', '2021-07-25', 0),
(5, 5, '2021-07-12', '2021-07-27', 1);



-- 1 
select * from autor;
-- 2
select nombre,edad from estudiante;
-- 3 
select nombre, apellido, carrera from estudiante where carrera='informática';
-- 4 
select nombre, nacionalidad from autor where nacionalidad = 'francesa' or nacionalidad='italiana';
-- 5
select titulo, area from libro where area not like 'internet';
-- 6 
select * from libro where editorial='Salamandra';
-- 7
select * from estudiante where edad > (select AVG(edad) from estudiante);
-- 8 
select nombre from estudiante where apellido like 'G%';
-- 9
select a.Nombre from autor a join libroautor la on a.idAutor=la.idAutor join libro l on la.idLibro=l.idLibro where l.titulo='El Universo: Guía de viaje';
-- 10
select l.titulo from estudiante e join prestamo p on e.idLector=p.idLector join libro l on p.idLibro=l.idLibro where e.nombre= 'Filippo' and e.apellido='Galli';
-- 11
select nombre from estudiante where edad=(select min(edad) from estudiante);
-- 12
select e.nombre from estudiante e join prestamo p on e.idLector=p.idLector join libro l on p.idLibro=l.idLibro where l.titulo='Base de Datos';
-- 13
select l.* from libro l join libroautor la on l.idLibro= la.idLibro join autor a on la.idAutor=a.idAutor where a.Nombre='J.K. Rowling';
-- 14
select l.titulo from prestamo p join libro l on p.idLibro=l.idLibro where p.fechaDevolucion='2021-07-16';



