SELECT g.name, s.title FROM movies_db.genres g 
INNER JOIN movies_db.series s ON g.id = s.genre_id 

SELECT e.title, a.first_name, a.last_name FROM movies_db.episodes e 
INNER JOIN movies_db.actor_episode ae ON e.id = ae.episode_id 
INNER JOIN movies_db.actors a ON ae.actor_id = a.id 

SELECT s.title, COUNT(t.serie_id) AS Temporadas FROM movies_db.series s
INNER JOIN movies_db.seasons t ON s.id = t.serie_id 
GROUP BY t.serie_id 

SELECT g.name, COUNT(m.genre_id) AS PeliculasPorGenero FROM movies_db.genres g 
INNER JOIN movies_db.movies m ON g.id = m.genre_id 
GROUP BY m.genre_id 
HAVING PeliculasPorGenero >= 3

SELECT DISTINCT a.first_name, a.last_name FROM movies_db.actors a 
INNER JOIN movies_db.actor_movie am ON a.id = am.actor_id 
INNER JOIN movies_db.movies m ON am.movie_id = m.id 
WHERE m.title LIKE 'La Guerra de las galaxias%' 