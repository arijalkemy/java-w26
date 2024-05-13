-- Mostrar el título y el nombre del género de todas las series.

SELECT movies.title, genres.name genre
FROM movies JOIN genres ON movies.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT e.title, a.first_name, a.last_name FROM actors a 
JOIN actor_episode ae ON a.id = ae.actor_id  
JOIN episodes e ON e.id = ae.episode_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT s.title, MAX(sns.`number`) seasons 
FROM series s JOIN seasons sns ON s.id = sns.serie_id 
GROUP BY s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT g.name, COUNT(m.id) movies_amount 
FROM movies m JOIN genres g ON m.genre_id = g.id 
GROUP BY g.name;

/* 
 * Mostrar sólo el nombre y apellido de los actores que trabajan en todas las 
 * películas de la guerra de las galaxias y que estos no se repitan.
 */

SELECT DISTINCT a.first_name, a.last_name
FROM actors a JOIN actor_movie am ON am.actor_id = a.id 
JOIN movies m ON am.movie_id = m.id 
WHERE m.title LIKE 'La Guerra de las galaxias%'
AND (
    SELECT COUNT(*)
    FROM movies m2
    WHERE m2.title LIKE 'La Guerra de las galaxias%'
) = (
    SELECT COUNT(*)
    FROM actor_movie am2
    WHERE am2.actor_id = a.id
    AND EXISTS (
        SELECT 1
        FROM movies m3
        WHERE m3.title LIKE 'La Guerra de las galaxias%'
        AND m3.id = am2.movie_id
    )
);