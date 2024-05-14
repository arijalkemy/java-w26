INSERT INTO movies(title,rating,awards,release_date) VALUES("Meli Bootcamp",8.2,3,"2020-10-10")
INSERT INTO genres (name,ranking,active) VALUES("Educacion",13,1)
UPDATE movies SET genre_id = 13 WHERE title LIKE "Meli Bootcamp"
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3
CREATE TEMPORARY TABLE movie_temporary
SELECT * FROM movies m; 
DELETE FROM movie_temporary WHERE awards < 5
SELECT g.name , COUNT(*) FROM movies m JOIN genres g ON m.genre_id = g.id GROUP BY name
SELECT a.first_name, a.last_name, m.awards  FROM actors a JOIN movies m ON a.favorite_movie_id = m.id WHERE m.awards > 3
CREATE INDEX movie_idx_second_part ON movies(title,awards)