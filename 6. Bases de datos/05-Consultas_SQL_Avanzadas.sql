use movies_db;

-- Mostrar el nombre y el genero de todas las series
SELECT title, name FROM series JOIN genres ON genres.id=series.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT title, first_name, last_name FROM episodes JOIN actors JOIN actor_episode ON actor_id=episode_id;

-- Mostrar el titulo de todas las series y el total de temporadas que contiene cada una de ellas.
SELECT series.title, COUNT(*) as numero_temporadas FROM series  JOIN seasons ON series.id = seasons.serie_id GROUP BY series.id;

-- Mostrar el nombre de todos los generos y la cantidad total de peliculas por cada uno, siempre que sea mayor o igual a 3;
SELECT name, count(*) AS movies_number FROM genres JOIN movies ON genres.id=movies.genre_id GROUP BY genres.id HAVING movies_number >= 	3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT first_name, last_name, title FROM movies JOIN actors JOIN actor_movie ON actor_id = movie_id WHERE title LIKE "La Guerra %";
/*

-- alternative
SELECT DISTINCT first_name, last_name, title
FROM movies
JOIN actor_movie ON movies.id = actor_movie.movie_id
JOIN actors ON actor_movie.actor_id = actors.id
WHERE title LIKE "La Guerra %";

*/
