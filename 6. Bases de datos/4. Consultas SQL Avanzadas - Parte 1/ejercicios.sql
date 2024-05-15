use movies_db;
-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name as genre_name
from series s 
	join genres g on s.genre_id = g.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name 
from episodes e 
	join actor_episode ae on e.id = ae.episode_id
	join actors a on a.id = ae.actor_id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title, count(seas.id) season_count
from series ser
	join seasons seas on ser.id = seas.serie_id
group by ser.id;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(m.id) movie_count
from genres g
	join movies m on m.genre_id = g.id
group by g.id
having movie_count > 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name
from movies m
	join actor_movie am on m.id = am.movie_id
    join actors a on am.actor_id = a.id
where upper(m.title) like 'LA GUERRA DE LAS GALAXIAS%';