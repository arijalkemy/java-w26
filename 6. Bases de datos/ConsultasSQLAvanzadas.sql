use movies_db;

/* Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. */

select 
	g.name,
	count(*) cant
from 
	movies m
	left join 
		genres g
		on 
			g.id = m.genre_id
group by 
	m.genre_id
having 
	count(*) >= 3;

/* Mostrar el título y el nombre del género de todas las series. */

select 
	s.title,
    g.name
from
	series s
	left join 
		genres g
		on 
			g.id = s.genre_id;

/* Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */

select 
	e.title,
    a.first_name,
    a.last_name
from 
	actor_episode ae
    inner join 
		episodes e
        on
			e.id = ae.episode_id
	inner join 
		actors a
        on
			a.id = ae.actor_id;

/* Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */

select 
	series.title,
    count(*) seasons
from
	seasons
    left join 
		series
        on
			series.id = seasons.serie_id
group by
	series.title;

/* Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan. */

select
	a.first_name,
    a.last_name
from
	movies m
    inner join
		actor_movie am
			on
				am.movie_id = m.id
	inner join
		actors a
        on
			a.id = am.actor_id
where
	m.title
		like
			'La Guerra de las galaxias%'
group by 
	a.first_name,
    a.last_name
having 
	count(m.title) = (
		select 
			count(*)
		from
			movies m2
		where 
			m2.title
		like
			'La Guerra de las galaxias%'
    );