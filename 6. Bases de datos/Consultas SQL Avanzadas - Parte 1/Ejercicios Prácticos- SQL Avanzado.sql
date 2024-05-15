-- Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name
FROM series se
INNER JOIN genres ge
ON se.genre_id = ge.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title ,ac.first_name, ac.last_name
FROM episodes ep
INNER JOIN actor_episode ae
ON ep.id = ae.episode_id
INNER JOIN actors ac
ON ac.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT COUNT(*) AS numb_seas, se.title
FROM series se
INNER JOIN seasons sn
ON se.id = sn.serie_id
GROUP BY se.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT ge.name, COUNT(*) AS tot_movies
FROM genres ge
INNER JOIN movies mo
ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING tot_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac
INNER JOIN actor_movie am
ON am.actor_id = ac.id
INNER JOIN movies mo
ON  mo.id = am.movie_id
WHERE mo.title LIKE 'La Guerra de las galaxias%';

