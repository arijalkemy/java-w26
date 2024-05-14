-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name 
FROM series s
JOIN genres g
	on g.id = s.genre_id;

/*
 * 2. Mostrar el título de los episodios, el nombre y apellido 
 *    de los actores que trabajan en cada uno de ellos.
 */
SELECT e.title, a.first_name, a.last_name
FROM episodes e
JOIN actor_episode ae 
	ON e.id = ae.episode_id
JOIN actors a 
	ON a.id = ae.actor_id;

/*
 * 3. Mostrar el título de todas las series
 *    y el total de temporadas que tiene cada una de ellas.
 */
SELECT ser.title, COUNT(*) 'Nº de temporadas'
FROM series ser
JOIN seasons sea
	ON ser.id = sea.serie_id
GROUP BY ser.id;

/*
 * 4. Mostrar el nombre de todos los géneros y la cantidad total 
 *    de películas por cada uno, siempre que sea mayor o igual a 3.
 */
SELECT g.name, COUNT(*) 'Nº de Peliculas'
FROM genres g
JOIN movies m
	ON g.id = m.genre_id 
GROUP BY g.id
HAVING COUNT(*) >= 3;

/*
 * 5. Mostrar sólo el nombre y apellido de los actores que trabajan 
 *    en todas las películas de la guerra de las galaxias 
 *    y que estos no se repitan.
 */
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am 
	on a.id = am.actor_id
JOIN movies m
	ON m.id = am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%';


