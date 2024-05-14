-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name  FROM series s JOIN genres g ON s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name 
	FROM actor_episode ae 
	JOIN episodes e ON ae.episode_id = e.id
	JOIN actors a ON ae.actor_id = a.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(s.title) FROM series s 
JOIN seasons sea ON s.id = sea.serie_id 
GROUP BY s.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name as genre_name, COUNT(m.title) as amount_of_movies
	FROM genres g 
	JOIN movies m ON m.genre_id = g.id 
	GROUP BY g.name
	HAVING amount_of_movies >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
	FROM actors a 
	JOIN actor_movie am ON a.id = actor_id
	WHERE am.movie_id IN
	(SELECT m.id FROM movies m 
		WHERE m.title LIKE "La Guerra de las galaxias:%");
		

	

