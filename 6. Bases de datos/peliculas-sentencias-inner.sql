SELECT s.title, g.name
FROM series s
         INNER JOIN genres g ON s.genre_id = g.id;

SElECT e.title, a.first_name, a.last_name
FROM actor_episode ae
         INNER JOIN actors a ON a.id = ae.actor_id
         INNER JOIN episodes e ON e.id = ae.episode_id;

SELECT se.title, COUNT(*) as total_seasons
FROM series se
         INNER JOIN seasons ss ON se.id = ss.serie_id
GROUP BY se.id;

SELECT g.name, COUNT(*) as total_movies
FROM genres g
         INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.id;

SELECT a.first_name, a.last_name
FROM actor_movie am
         INNER JOIN actors a ON a.id = am.actor_id
         INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title like '%La Guerra de las galaxias%'
GROUP BY actor_id;
