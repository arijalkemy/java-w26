-- Ejercicios Consultas SQL avanzadas
-- 1: Mostrar el título y el nombre del género de todas las series.
SELECT title as 'Título', name as 'Género'
FROM series LEFT JOIN genres
ON series.genre_id = genres.id;

-- 2: Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT title as 'Título', first_name as 'Nombre', last_name as 'Apellido'
FROM episodes 
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id 
INNER JOIN actors ON actor_episode.actor_id = actors.id;

-- 3: Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title as 'Título', COUNT(*) as 'Número de Temporadas'
FROM series RIGHT JOIN seasons
ON series.id = seasons.serie_id
GROUP BY series.title;

SELECT series.title as 'Título', COUNT(*) as 'Número de Episodios'
FROM series 
INNER JOIN seasons ON series.id = seasons.serie_id 
INNER JOIN episodes ON seasons.id = episodes.season_id
GROUP BY series.title;

-- 4: Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name as 'Género', COUNT(*) as peliculas
FROM genres LEFT JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING peliculas >= 3;

-- 5: Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT first_name as 'Nombre', last_name as 'Apellido'
FROM actors 
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.id IN (SELECT id FROM movies WHERE title LIKE 'La Guerra de las galaxias%')
GROUP BY actors.id;

-- 5: Opción 2
SELECT first_name as 'Nombre', last_name as 'Apellido'
FROM actor_movie
LEFT JOIN actors ON actors.id = actor_movie.actor_id
RIGHT JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE 'La Guerra de las galaxias%'
GROUP BY actors.id;



