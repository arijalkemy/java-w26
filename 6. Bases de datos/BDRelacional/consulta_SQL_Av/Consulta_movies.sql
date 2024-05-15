-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s INNER JOIN genres g ON (s.genre_id=g.id);

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT A.first_name, A.last_name, E.title
FROM actors A INNER JOIN actor_episode AE ON (A.id=AE.actor_id) INNER JOIN episodes E ON (AE.episode_id=E.id);
			
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT S.title, COUNT(SE.number) FROM series S INNER JOIN seasons SE ON (S.id=SE.serie_id) GROUP BY s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT G.name, COUNT(M.id) AS total_peliculas
FROM genres G INNER JOIN movies M ON (G.id=M.genre_id)
GROUP BY G.name
HAVING total_peliculas >=3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT distinct A.first_name, A.last_name
FROM actors A INNER JOIN actor_movie AM ON (A.id=AM.actor_id) INNER JOIN movies M ON (AM.movie_id=M.id)
WHERE M.title LIKE "La Guerra de las galaxias%";

SELECT * FROM movies;
SELECT * FROM actor_movie ORDER BY movie_id ASC;
SELECT * FROM actors;