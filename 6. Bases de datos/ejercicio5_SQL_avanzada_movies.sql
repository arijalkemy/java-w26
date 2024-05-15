-- Show the title and genre name of all series
SELECT s.title, g.name as genres
FROM series s
INNER JOIN genres g ON s.genre_id = g.id;

-- Show the title of the episodes, the first and last name of the actors working on each of them
SELECT e.title, a.first_name, a.last_name s
FROM episodes e 
INNER JOIN actor_episode ae ON ae.episode_id = e.id
INNER JOIN actors a ON a.id = ae.actor_id
ORDER BY e.title AND e.number;

-- Show the title of all the series and the total number of seasons that each of them has
SELECT s.title, COUNT(ss.id) as number_season
FROM series s
INNER JOIN seasons ss ON s.id = ss.serie_id
GROUP BY s.id;

-- Show the name of all genres and the total number of movies for each one, as long as it is greater than or equal to 3
SELECT g.name, COUNT(m.id) AS number_movies
FROM genres g
INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.id
HAVING number_movies >= 3;

-- Show only the first and last name of the actors who work in all the Star Wars films and do not repeat them
SELECT DISTINCT (a.first_name), a.last_name
FROM actors a
INNER JOIN actor_movie am ON am.actor_id = a.id
INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE "%Guerra%galaxias%";