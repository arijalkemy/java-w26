USE movies_db;

SELECT s.title 'Título', g.name 'Género'
FROM series s INNER JOIN genres g ON s.genre_id = g.id;

SELECT e.title 'Título', a.first_name 'Nombre', a.last_name 'Apellido'
FROM episodes e INNER JOIN actor_episode act_e ON e.id = act_e.episode_id
				INNER JOIN actors a ON a.id = act_e.actor_id;
                
SELECT series.title 'Serie', COUNT(seasons.id) 'Número de temporadas'
FROM series INNER JOIN seasons ON series.id=seasons.serie_id
GROUP BY series.id;

SELECT g.name 'Genero', COUNT(m.id) 'Número de peliculas'
FROM genres g INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.id
HAVING COUNT(m.id) >= 3;

SELECT DISTINCT a.first_name 'Nombre', a.last_name
FROM movies m INNER JOIN actor_movie actor_m ON m.id = actor_m.movie_id
			  INNER JOIN actors a ON a.id = actor_m.actor_id
WHERE m.title LIKE 'La Guerra de las Galaxias%';