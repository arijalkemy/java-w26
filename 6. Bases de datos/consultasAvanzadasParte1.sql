-- Mostrar el título y el nombre del género de todas las series.

SELECT s.title AS titulo_serie, g.name AS nombre_genero 
FROM series s 
LEFT JOIN genres g 
ON s.genre_id = g.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name 
FROM episodes e 
INNER JOIN actor_episode ae
	ON ae.episode_id = e.id
INNER JOIN actors a
	ON ae.actor_id = a.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(*) AS total_temporadas
FROM series
INNER JOIN seasons
	ON series.id = seasons.serie_id
GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) AS total_peliculas
FROM movies m
INNER JOIN genres g
	ON m.genre_id = g.id
GROUP BY g.name
HAVING total_peliculas >=3;


-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a 
INNER JOIN actor_movie am
	ON a.id = am.actor_id
INNER JOIN movies m
	ON am.movie_id = m.id
WHERE m.title LIKE 'La Guerra de las galaxias%';