/*Mostrar el título y el nombre del género de todas las series.*/

SELECT s.title , g.name  
FROM series s INNER JOIN genres g 
ON s.genre_id = g.id; 

/*Mostrar el título de los episodios, el nombre y 
 * apellido de los actores que trabajan en cada uno de ellos.*/

SELECT e.title , a.first_name , a.last_name 
FROM actor_episode ae INNER JOIN episodes e
ON e.id =ae.episode_id 
INNER JOIN actors a ON a.id = ae.actor_id; 


/*Mostrar el título de todas las series y 
 * el total de temporadas que tiene cada una de ellas.*/

SELECT s.title , COUNT(*) AS "Cantidad de temporadas"
FROM series s INNER JOIN seasons se ON s.id = se.serie_id 
GROUP BY s.id, s.title 
ORDER BY s.title; 

/*Mostrar el nombre de todos los géneros y 
 * la cantidad total de películas por cada uno, 
 * siempre que sea mayor o igual a 3.*/

SELECT g.name , COUNT(*) AS "Cantidad de peliculas"
FROM genres g INNER JOIN movies m ON g.id = m.genre_id 
GROUP BY g.id, g.name
HAVING COUNT(*) >= 3 
ORDER BY g.name;

/*Mostrar sólo el nombre y 
 * apellido de los actores que trabajan en todas 
 * las películas de la guerra de las galaxias y que estos no se repitan.*/

SELECT a.first_name , a.last_name 
FROM actors a 
WHERE a.id IN (
	SELECT am.actor_id
	FROM actor_movie am INNER JOIN movies m ON m.id = am.movie_id
	WHERE m.title LIKE ("La Guerra de las galaxias%")
	GROUP BY am.actor_id
	HAVING COUNT(DISTINCT m.id) = (SELECT COUNT(*) 
									FROM movies m2 
									WHERE m2.title LIKE("La Guerra de las galaxias%"))
);

