-- 1
select * from autor a 

-- 2
select nombre, edad from estudiante e

-- 3
select * from estudiante e
where e.carrera like 'Informatica'

-- 4
select * from autor a
where a.nacionalidad in ('Colombiana', 'Británica')

-- 5
select * from libro l 
where l.area NOT LIKE 'Fantasía' 

-- 6
select * from libro l 
where l.editorial = 'Salamandra' 

-- 7
select * from estudiante e 
where e.edad > (select AVG(e2.edad) from estudiante e2)

-- 8
select nombre from estudiante e
where e.nombre like 'M%'

-- 9
select a.nombre from autor a 
inner join libro_autor la on la.idAutor = a.idAutor
inner join libro l on l.idLibro = la.idLibro
where l.titulo = 'El señor de los anillos' 

