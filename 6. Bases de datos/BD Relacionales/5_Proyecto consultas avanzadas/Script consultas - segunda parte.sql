-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title titulo, g.name 
FROM series s 
JOIN genres g ON s.genre_id = g.id; 

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title "titulo episodios", a.first_name nombre, a.last_name apellido 
FROM episodes e 
JOIN actor_episode ae ON e.id = ae.episode_id 
JOIN actors a ON ae.actor_id = a.id; 

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title titulo_serie, COUNT(S.title) temporadas
FROM seasons s 
JOIN series se ON s.serie_id = se.id 
GROUP BY titulo_serie;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name nombre_genero, COUNT(m.title) peliculas 
FROM movies m 
JOIN genres g ON m.genre_id = g.id 
GROUP BY nombre_genero
HAVING peliculas >= 3;


-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name nombre_actor, a.last_name apellido_actor 
FROM actors a 
JOIN actor_movie am ON a.id = am.actor_id 
JOIN movies m ON am.movie_id = m.id 
WHERE m.title LIKE '%la guerra de las galaxias%';