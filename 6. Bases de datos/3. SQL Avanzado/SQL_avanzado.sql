#Mostrar el título y el nombre del género de todas las series.
SELECT
	s.title,
	g.name
FROM
	series s
INNER JOIN genres g on
	s.genre_id = g.id 

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT
    e.title,
    a.first_name,
    a.last_name
FROM
    episodes e
INNER JOIN actor_episode ae ON
    e.id = ae.episode_id
INNER JOIN actors a ON
    a.id = ae.actor_id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT
    s.title,
    COUNT(se.id) as season_count
FROM
    series s
INNER JOIN seasons se ON
    s.id = se.serie_id
GROUP BY
    s.title;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
    g.name,
    COUNT(m.id) as movies_count
FROM
    movies m
INNER JOIN genres g ON
    m.genre_id = g.id
GROUP BY
    g.name
HAVING
    COUNT(m.id) >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT
    DISTINCT a.last_name, 
    a.last_name 
FROM
    movies m
INNER JOIN actor_movie am ON
    m.id = am.movie_id
INNER JOIN actors a ON
    a.id = am.actor_id
WHERE
    m.title LIKE '%guerra de las galaxias%';
   
