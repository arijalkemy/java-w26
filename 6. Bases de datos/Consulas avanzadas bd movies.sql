use movies_db;
-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name
from series s
inner join genres g on s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title as titulo, a.first_name as nombre, a.last_name as apellido
from actor_episode ae
inner join actors a on ae.actor_id = a.id
inner join episodes e on ae.episode_id = e.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(*)
from series s
inner join seasons ss on ss.serie_id = s.id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(*)
from genres g
inner join movies m on m.genre_id = g.id
group by g.name
having count(*) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
-- y que estos no se repitan
select distinct a.first_name, a.last_name
from actor_movie am
inner join actors a on am.actor_id = a.id
inner join movies m on am.movie_id = m.id
where m.title like 'La Guerra de las galaxias%'
group by a.first_name, a.last_name;


