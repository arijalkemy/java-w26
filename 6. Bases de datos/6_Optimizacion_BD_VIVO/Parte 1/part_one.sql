CREATE TEMPORARY TABLE TWD
SELECT s.title AS series_title, se.title AS season_title ,e.title AS episode_title
FROM series s, seasons se, episodes e 
WHERE s.id = se.serie_id AND se.id = e.season_id AND s.title = "The Walking Dead";

CREATE INDEX movie_idx 
ON movies(title)

SHOW INDEX FROM movies;