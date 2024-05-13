use movies_db

-- Inner join series < > genres
select series.title, genres.name
from series
inner join genres on series.genre_id  = genres.id;

-- Inner join actors < > episodes
SELECT episodes.title AS 'Episode Title', CONCAT(actors.first_name, ' ', actors.last_name) AS 'Actor Name'
FROM episodes
JOIN actor_episode ON episodes.id = actor_episode.episode_id
JOIN actors ON actor_episode.actor_id = actors.id
ORDER BY episodes.title;

-- Group by
select s.title, COUNT(se.serie_id) as 'Total temporadas'
from series s
join seasons se  on s.id = se.serie_id
group by title

SELECT g.name, COUNT(p.title) AS 'Peliculas por genero'
FROM genres g
JOIN movies p ON g.id = p.genre_id
GROUP BY g.name
HAVING COUNT(p.title) >= 3;


SELECT DISTINCT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
JOIN genres g ON m.genre_id = g.id
WHERE g.name = 'Star Wars'
GROUP BY a.first_name, a.last_name
HAVING COUNT(DISTINCT m.title) = (
    SELECT COUNT(*)
    FROM movies
    WHERE genre_id = (
        SELECT id
        FROM genres
        WHERE name = 'Star Wars'
    )
);
