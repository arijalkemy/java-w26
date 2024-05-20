-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT m.title, g.name FROM movies m
	INNER JOIN genres g ON m.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT a.first_name, a.last_name, e.title FROM actor_episode ae
	INNER JOIN actors a ON ae.actor_id = a.id
		INNER JOIN episodes e ON e.id = ae.episode_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT  s.title, count(*) as "Season quantity" FROM series s
	INNER JOIN seasons sa ON s.id = sa.serie_id
		GROUP BY s.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(*) as "total movies" FROM movies m
	INNER JOIN genres g ON m.genre_id = g.id
		GROUP BY genre_id
			HAVING count(*) >= 3;
			
/* 
Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
y que estos no se repitan.
*/            

SELECT distinct a.first_name, a.last_name FROM actors a
	INNER JOIN actor_movie am ON a.id = am.actor_id
		INNER JOIN movies m on m.id = am.movie_id
			WHERE LOWER(title) LIKE "la guerra de las galaxias%";
