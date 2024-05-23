/*1.Mostrar el título y el nombre del género de todas las series.*/
select s.title , g.name
from genres g join series s on g.id = s.genre_id;

/*2.Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
select s.title, e.title , a.first_name , a.last_name
from series s 
join seasons sea on s.id = sea.serie_id 
join episodes e on e.season_id = sea.id 
join actor_episode ae on ae.episode_id = e.id
join actors a on a.id = ae.actor_id;

/*3.Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
select s.title ,count(sea.id)
from series s join seasons sea on s.id = sea.serie_id
group by s.title;

/*4.Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
 siempre que sea mayor o igual a 3.*/
 select g.name , count(*)
 from genres g join movies m on g.id = m.genre_id
 group by g.name
 having count(*) > 3;
 
/*5.Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias
 y que estos no se repitan*/
 select distinct a.first_name , a.last_name
 from movies m 
 join actor_movie am on m.id = am.movie_id 
 join actors a on a.id = am.actor_id
 where m.title like "La Guerra de las galaxias%"
 
 