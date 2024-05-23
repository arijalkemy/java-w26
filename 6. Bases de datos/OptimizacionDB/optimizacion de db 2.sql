
/* consultas optimizacion parte 2 */

/*1.Agregar una película a la tabla movies.*/
insert into movies values (22, null, null, 'Star Wars 7', 8.2, 2, '2010-10-04', 200, 5);

/*2.Agregar un género a la tabla genres.*/
insert into genres values (13, null, null, 'Espacial', 13, 1);

/*3.Asociar a la película del punto 1. genre el género creado en el punto 2.*/
update movies set genre_id = 13 where id = 22;

/*4.Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.*/
update actors set favorite_movie_id = 22 where id = 4;

/*5.Crear una tabla temporal copia de la tabla movies.*/
CREATE TEMPORARY TABLE temp_movies (id int, created_at timestamp, updated_at timestamp, title varchar(500), rating decimal(3,1), awards int, release_date datetime, length int, genre_id int);

insert into temp_movies select * from movies;

/*6.Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
delete 
from temp_movies
where awards < 5;

/*7.Obtener la lista de todos los géneros que tengan al menos una película.*/
select distinct  g.name
from genres g inner join movies m on g.id = m.genre_id;

/*8.Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.*/
select a.id , a.first_name, a.last_name , m.title ,m.awards
from actors a join movies m on a.favorite_movie_id = m.id
where m.awards > 3;

/*9.Crear un índice sobre el nombre en la tabla movies.*/
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;

/*10.Verificar si el indice fue creado*/
 SHOW INDEX FROM `movies_db`.`movies`;





