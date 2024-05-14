USE movies_db;

## 1
SELECT title, name FROM series
join genres on genre_id = genres.id;

## 2
SELECT title, first_name, last_name FROM actor_episode
JOIN actors ON actor_id = actors.id
JOIN episodes ON episode_id = episodes.id;

## 3
SELECT s.title, count(*) as cantidad_de_temporadas from series s
join seasons on s.id = seasons.serie_id
group by s.title;

## 4
SELECT name, count(*) FROM genres
JOIN movies m on genres.id = m.genre_id
GROUP BY name
HAVING count(*) > 3;

## 5
SELECT distinct first_name, last_name FROM actors
JOIN actor_movie ON actors.id = actor_movie.actor_id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE 'La Guerra de las galaxias%';