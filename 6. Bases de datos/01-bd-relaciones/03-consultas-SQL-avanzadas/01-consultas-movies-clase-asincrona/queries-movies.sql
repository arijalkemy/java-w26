-- 1. Mostrar el título y el nombre del género de todas las series.

SELECT title, name FROM movies
JOIN genres ON movies.genre_id = genres.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT title, first_name, last_name FROM episodes
JOIN actor_episode aep ON aep.episode_id = episodes.id
JOIN actors ON aep.actor_id = actors.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT series.title, count(*) AS 'Cantidad de temporadas' FROM series
JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT name, count(*) as cantidadPeliculas FROM genres
JOIN movies ON genres.id = movies.genre_id
GROUP BY name
HAVING cantidadPeliculas >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT first_name, last_name FROM actors
JOIN actor_movie av ON av.actor_id = actors.id
JOIN movies mv ON mv.id = av.movie_id
WHERE mv.title LIKE 'La guerra de las galaxias%';