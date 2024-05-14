-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title , g.name 
FROM series s 
INNER JOIN genres g ON s.genre_id = g.id;

/* Mostrar el título de los episodios, el nombre y apellido de los 
actores que trabajan en cada uno de ellos. */

SELECT e.title, a.first_name, a.last_name
FROM actor_episode ap
INNER JOIN actors a ON a.id = ap.actor_id
INNER JOIN episodes e ON e.id = ap.episode_id;

/* Mostrar el título de todas las series y 
el total de temporadas que tiene cada una de ellas. */

SELECT s.title, COUNT(sson.serie_id) seassons_number
FROM series s
INNER JOIN seasons sson ON s.id = sson.serie_id
GROUP BY s.title;

/* 
Mostrar el nombre de todos los géneros y la cantidad 
total de películas por cada uno, siempre que sea mayor o igual a 3. */

SELECT g.name, COUNT(m.id) movies_count
FROM genres g
INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.name
HAVING movies_count >= 3;

/* Mostrar sólo el nombre y apellido de los actores que trabajan en todas 
las películas de la guerra de las galaxias y que estos no se repitan. */

SELECT DISTINCT a.first_name, a.last_name 
FROM actors a
INNER JOIN actor_movie am ON am.actor_id = a.id
INNER JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE 'La Guerra de las galaxias%';
