SELECT *
FROM actor_movie
LIMIT 5;

SELECT *
FROM episodes
LIMIT 5;

SELECT *
FROM movies
LIMIT 5;

SELECT *
FROM actors
LIMIT 5;

//SEGUNDA PARTE

//EJERCICIO 1
SELECT title, name as genre
FROM series INNER JOIN genres ON series.genre_id = genres.id

//EJERCICIO 2
SELECT first_name, last_name, temp.title
FROM actors INNER JOIN
(SELECT title, actor_id FROM episodes INNER JOIN actor_episode ON actor_episode.episode_id = episodes.id) as temp ON actors.id = temp.actor_id;

//Ejercicio 3
SELECT series.title, count(*) as seasons_amount
FROM seasons INNER JOIN series ON seasons.serie_id = series.id
GROUP BY serie_id;

//Ejercicio 4
SELECT genres.name, count(*) as movies_amount
FROM genres INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genre_id
HAVING movies_amount >= 3;

//Ejercicio 5

SELECT first_name, last_name
FROM actor_movie INNER JOIN actors ON actor_movie.actor_id = actors.id
WHERE actor_movie.movie_id IN 
(SELECT id FROM movies WHERE movies.title LIKE "La Guerra de las galaxias%")
