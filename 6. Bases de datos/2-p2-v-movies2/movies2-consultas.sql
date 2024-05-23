USE movies_db;
CREATE TEMPORARY TABLE TWD
(
    id           int unsigned auto_increment
        primary key,
    created_at   timestamp     null,
    updated_at   timestamp     null,
    title        varchar(500)  null,
    number       int unsigned  null,
    release_date datetime      not null,
    rating       decimal(3, 1) not null,
    season       int unsigned  null
);

INSERT INTO TWD (SELECT e.id,
                        e.created_at,
                        e.updated_at,
                        e.title,
                        e.number,
                        e.release_date,
                        e.rating,
                        s.number as season
                 FROM episodes e
                          INNER JOIN seasons s ON e.season_id = s.id
                          INNER JOIN series se ON s.serie_id = se.id
                 WHERE se.title LIKE 'The Walking Dead');

SELECT t.*
FROM TWD t
WHERE t.season = 1;

# Los indices los colocamos porque las capitulos asociados a una temporada no cambian.
ALTER TABLE seasons
    ADD INDEX seasons_idx (number);
ALTER TABLE series
    ADD INDEX series_title_idx (title);

EXPLAIN
SELECT *
FROM seasons
WHERE number = 1;

# -------------- SEGUNDA PARTE ----------

# DROP TABLE TWD;

INSERT INTO movies_db.genres (created_at, updated_at, name, ranking, active)
VALUES ('2024-05-14 15:30:22', null, 'Animales', 13, 1);

INSERT INTO movies_db.movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (null, null, 'Garfield', 4.9, 0, '2024-05-01 15:29:05', 130, 13);

UPDATE movies_db.actors t
SET t.favorite_movie_id = 22
WHERE t.id = 39;

CREATE TEMPORARY TABLE movies_temp
SELECT *
FROM movies;

DELETE
FROM movies_temp mp
WHERE mp.awards < 5;

SELECT g.name
FROM genres g
         INNER JOIN movies m on g.id = m.genre_id
GROUP BY g.id;

SELECT g.name
FROM genres g
         INNER JOIN movies_temp mt on g.id = mt.genre_id
GROUP BY g.id;

ALTER TABLE movies
    ADD INDEX title_idx (title);

ALTER TABLE movies
    ADD INDEX awards (awards);
 
ALTER TABLE episodes
    ADD INDEX title_idx (title);

EXPLAIN SELECT * FROM movies WHERE title LIKE 'G%';

DROP TEMPORARY TABLE IF EXISTS movies_temp;