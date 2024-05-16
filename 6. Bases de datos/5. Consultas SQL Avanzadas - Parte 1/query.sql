use movies_db; 

-- 1: Mostrar el título y el nombre del género de todas las series. 
SELECT s.title, g.name FROM series s
LEFT JOIN genres g 
ON s.genre_id = g.id

UNION

SELECT s.title, g.name FROM series s
RIGHT JOIN genres g 
ON s.genre_id = g.id; 

-- 2: Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM episodes e
	INNER JOIN actor_episode ae ON e.id = ae.episode_id
	INNER JOIN actors a ON a.id = ae.actor_id;

-- 3: Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT 
	s.title, 
    (SELECT COUNT(*) FROM seasons se WHERE se.serie_id = s.id) AS No_Temporadas
FROM
	series s;

-- 4: Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT 
	g.name, 
    COUNT(m.id) AS NoMovies
FROM genres g
LEFT JOIN movies m ON m.genre_id = g.id 
GROUP BY g.name 
HAVING COUNT(m.id) >= 3;  

-- 5: Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name 
FROM actors a
INNER JOIN actor_movie am ON am.actor_id = a.id
INNER JOIN movies m ON am.movie_id = m.id
WHERE LOWER(m.title) LIKE '%guerra de las galaxias%'
GROUP BY a.id 
HAVING COUNT(m.id) >= 2; 

