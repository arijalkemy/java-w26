-- Mostrar el título y el nombre del género de todas las series.
USE movies_db;
SELECT s.title, g.name
FROM series s
JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
USE movies_db;
SELECT e.title, ac.first_name, ac.last_name
FROM episodes e
JOIN actor_episode ae ON ae.episode_id = e.id
JOIN actors ac ON ac.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
USE movies_db;
SELECT s.title, COUNT(*)
FROM series s
JOIN seasons se ON se.serie_id = s.id
GROUP BY s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
USE movies_db;
SELECT g.name, COUNT(1) AS cant_peliculas
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING COUNT(1) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
USE movies_db;
SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac
JOIN actor_movie acm ON acm.actor_id = ac.id
JOIN movies m ON acm.movie_id = m.id
WHERE UPPER(m.title) LIKE UPPER("la guerra de las galaxias:%");