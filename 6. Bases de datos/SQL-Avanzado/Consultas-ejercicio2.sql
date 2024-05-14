-- Mostrar el título y el nombre del género de todas las series
SELECT series.title, genres.name
FROM series
INNER JOIN genres ON series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
INNER JOIN actors_episodes ON episodes.id = actors_episodes.episode_id
INNER JOIN actors ON actors_episodes.actor_id = actors.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas
SELECT series.title, COUNT(seasons.id) AS total_temporadas
FROM series
LEFT JOIN seasons ON series.id = seasons.series_id
GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3
SELECT genres.name, COUNT(*) AS total_peliculas
FROM movies
INNER JOIN genres ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING COUNT(*) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
INNER JOIN actors_movies ON actors.id = actors_movies.actor_id
INNER JOIN movies ON actors_movies.movie_id = movies.id
INNER JOIN genres ON movies.genre_id = genres.id
WHERE genres.name = 'Guerra de las Galaxias';


