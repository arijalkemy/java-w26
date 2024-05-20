USE movies_db;

-- consultas 1 2 y 3

insert into genres (created_at, updated_at, name, ranking, active)
 values("2000-01-01", "2001-01-01", "fantacia avatar", 13, 1);

SELECT * FROM movies;

insert into movies (created_at, updated_at, title, rating, awards,release_date,length, genre_id)
 values ("2000-01-01", "2001-01-01", "avatar", 8.1, 5, "2000-01-02", 200, 14);

-- 4
UPDATE actors SET favorite_movie_id = 14 WHERE id = 1;

-- 5 
CREATE TEMPORARY TABLE movies_copi (
select * from movies);

-- 6
delete from movies_copi where awards < 5;
SET SQL_SAFE_UPDATES = 0; -- luego volver a poner en 1

-- 7

SELECT DISTINCT ge.id, ge.name, ge.ranking
FROM genres ge JOIN movies mo ON mo.genre_id = ge.id;

-- 8
SELECT ac.id, ac.first_name, ac.last_name
FROM actors ac JOIN movies mo ON ac.favorite_movie_id = mo.id
WHERE mo.awards > 3;

-- 9
CREATE INDEX index_title_name ON movies(title);

-- 10
SHOW INDEX FROM movies;
