CREATE TEMPORARY TABLE twd (title VARCHAR(200));

DELETE FROM twd;

INSERT INTO twd SELECT e.title FROM episodes e JOIN seasons s ON e.season_id = s.id JOIN series se ON s.serie_id = se.id 
WHERE se.title LIKE 'The Walking Dead';

SELECT * FROM twd;

SELECT e.title,se.title  FROM episodes e JOIN seasons s ON e.season_id = s.id JOIN series se ON s.serie_id = se.id;

SELECT * FROM actors a ;

INSERT INTO movies_db.movies (title, rating, awards, release_date, `length`, genre_id)
VALUES ('The Shawshank Redemption', 9.3, 7, '1994-10-14', 142, 1);

INSERT INTO genres (name, ranking , active)
VALUES ("Thriller", 13, 1);

UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;

UPDATE actors SET favorite_movie_id = 22 WHERE actors.id = 48;

CREATE TEMPORARY TABLE movies_copia_temp (
    title VARCHAR(255),
    rating DECIMAL(3, 1),
    awards INT,
    release_date DATE,
    length INT,
    genre_id INT
);
INSERT INTO movies_copia_temp (title, rating, awards, release_date, `length`, genre_id)
SELECT title, rating, awards, release_date, `length`, genre_id
FROM movies_db.movies;

DELETE
FROM movies_copia_temp
WHERE awards < 5;

SELECT * from movies_copia_temp;


SELECT g.name AS genre_name
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING COUNT(m.id) >= 1;

CREATE INDEX idx_movie_name ON movies (title);

SELECT * FROM movies m ;

EXPLAIN SELECT title  FROM movies WHERE movies.title ='I am Sam' ;

-- Creo que podriamos agregar un indice en la tabla Series con el nombre de la serire

-- Si existe una mejora notable porque no se tiene que consultar mas veces para obtener el resultado de una consulta







