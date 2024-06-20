-- 1, 2 y 3
INSERT INTO genres (id, name, ranking, active)
VALUES (15, 'Horror', 15, 1);

INSERT INTO movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (100, NOW(), NOW(), 'The Walking Dead: The Beginning', 8.5, 5, '2010-10-31', 60, 15);

-- 4 
UPDATE actors SET favorite_movie_id = 100 WHERE id = 1;
-- 5
CREATE TEMPORARY TABLE temp_movies AS SELECT * FROM movies;
-- 6
DELETE FROM temp_movies WHERE awards < 5;
-- 7 
SELECT g.name FROM genres g JOIN movies m ON g.id = m.genre_id GROUP BY g.id, g.name;
-- 8
SELECT a.first_name, a.last_name FROM actors a JOIN movies m ON a.favorite_movie_id = m.id WHERE m.awards > 3;
-- 9 
CREATE INDEX idx_movie_title ON movies(title);
-- 10
SHOW INDEX FROM movies;
-- 11
-- Si tendria una mejora conciderable ya que por ejemplo si frecuentemente se realizan búsquedas por el título de la película, 
-- un índice en la columna title puede acelerar estas consultas. Por ejemplo, una consulta para encontrar una película específica 
-- por su título será mucho más rápida con un índice.

-- 12
-- En la tabla actors ya que por ejemplo si frecuentemente se realizan búsquedas de actores por apellido, un índice en la columna last_name puede acelerar estas consultas. 






