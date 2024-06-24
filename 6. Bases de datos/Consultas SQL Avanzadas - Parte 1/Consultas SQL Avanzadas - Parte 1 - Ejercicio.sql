USE movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s INNER JOIN genres g
ON s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos
SELECT e.title, a.first_name, a.last_name
FROM episodes e INNER JOIN actors a
ON e.id IN (SELECT episode_id FROM actor_episode);

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas
SELECT ses.title, COUNT(*) as totalseasons
FROM seasons sns INNER JOIN series ses
ON sns.serie_id = ses.id 
GROUP BY ses.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3
SELECT g.name, COUNT(*) as totalmovies
FROM genres g INNER JOIN movies m
ON m.genre_id = g.id 
GROUP BY g.id
HAVING totalmovies >= 3;

SELECT * FROM movies;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
SELECT DISTINCT a.first_name, a.last_name
FROM actors a INNER JOIN movies m
ON m.title LIKE 'La Guerra de las galaxias%';






