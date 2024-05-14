USE movies_db;

## Mostrar el título y el nombre del género de todas las series
SELECT title, name 
FROM series
join genres on genre_id = genres.id;

## 2 Mostrar el título y el nombre del género de todas las series.
SELECT title, first_name, last_name 
FROM actor_episode
JOIN actors ON actor_id = actors.id
JOIN episodes ON episode_id = episodes.id;

## Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, count(*) as cantidad_de_temporadas 
FROM series s
JOIN seasons ON s.id = seasons.serie_id
GROUP BY s.title;

## Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT name, count(*) 
FROM genres
JOIN movies m on genres.id = m.genre_id
GROUP BY name
HAVING count(*) > 3;

## Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
SELECT distinct first_name, last_name FROM actors
JOIN actor_movie ON actors.id = actor_movie.actor_id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE 'La Guerra de las galaxias%';