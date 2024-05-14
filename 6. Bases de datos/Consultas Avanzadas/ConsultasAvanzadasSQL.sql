-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name
from series s
inner join genres g on g.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name
from episodes e
inner join actor_episode ae on ae.episode_id = e.id
inner join actors a on a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(s.id) as number_of_season
from series s
inner join seasons sea on sea.serie_id = s.id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(m.id) as number_of_movies
from genres g
inner join movies m on m.genre_id = g.id
group by g.name
having count(m.id) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la 
-- guerra de las galaxias y que estos no se repitan.
select a.first_name, a.last_name
from actors a
inner join actor_movie am on am.actor_id = a.id
inner join movies m on m.id = am.movie_id
where m.title like 'La guerra de las galaxias%'
group by a.id
having count(a.id) = (select count(id)
						from movies
						where title like 'La guerra de las galaxias%');