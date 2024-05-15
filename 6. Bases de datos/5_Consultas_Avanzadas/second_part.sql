SELECT se.title, g.name FROM series se JOIN genres g ON se.genre_id = g.id;

SELECT ep.title, a.first_name, a.last_name FROM episodes ep JOIN actor_episode ac ON ac.episode_id = ep.id JOIN actors a ON a.id = ac.actor_id;

SELECT se.title, COUNT(*) AS total_temporadas FROM series se JOIN seasons s ON se.id = s.serie_id GROUP BY title; 

SELECT ge.name , COUNT(*) AS total_peliculas FROM genres ge JOIN movies m ON ge.id = m.genre_id GROUP BY name HAVING total_peliculas > 3;

SELECT DISTINCT ac.first_name, ac.last_name FROM actors ac JOIN actor_movie am  ON am.actor_id = ac.id JOIN movies m ON m.id = am.movie_id WHERE m.title LIKE "La Guerra%";
