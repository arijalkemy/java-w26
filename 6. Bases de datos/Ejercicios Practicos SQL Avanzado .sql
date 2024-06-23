-- 1
select
	s.title as Titulo,
	g.name as Genero
from
	series s
join
	genres g on s.genre_id=g.id;
-- 2
select
	e.title as Titulo,
	a.first_name as Nombre,
    a.last_name as Apellido
from
	episodes e
join
	actor_episode ae on e.id=ae.episode_id
join
	actors a on ae.actor_id=a.id;
-- 3
select
	s.title as Titulo,
    count(se.id) as Temporadas
from
	series s
left join
	seasons se on s.id=se.serie_id
group by
	s.id, s.title;
-- 4
select
	g.name as Genero,
    count(m.id) as Peliculas
from
	genres g
left join
	movies m on g.id=m.genre_id
group by
	g.id,g.name
having
	count(m.id)>=3;
-- 5
select distinct
    a.first_name,
    a.last_name
from
    actors a
join
    actor_movie am on a.id = am.actor_id
join
    movies m on am.movie_id = m.id
where
    m.title like '%Guerra de las galaxias%'
group by
    a.id, a.first_name, a.last_name
having
    count(distinct m.id) = (
        select count(distinct m2.id)
        from movies m2
        where m2.title like '%Guerra de las galaxias%'
    );
