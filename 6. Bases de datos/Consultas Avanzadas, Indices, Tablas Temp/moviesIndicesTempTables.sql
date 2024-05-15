-- EJERCICIO 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y
-- guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (episodios VARCHAR(100), temporada VARCHAR (100));

INSERT INTO TWD SELECT e.title, seasons.title  FROM episodes e
JOIN seasons ON seasons.id = e.season_id
JOIN series s ON s.id = seasons.serie_id
WHERE s.title = 'The Walking Dead' ;

DELETE FROM TWD;

SELECT * FROM TWD;
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE temporada LIKE "Primer%";


-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

CREATE INDEX idx_serie_title ON series (title);

SHOW INDEX FROM series;



-- EJERCICIO 2.

-- Agregar un género a la tabla genres.

INSERT INTO genres (name, ranking , active)
VALUES ("Thriller", 13, 1);

-- Agregar una película a la tabla movies.

INSERT INTO movies_db.movies (title, rating, awards, release_date, `length`, genre_id)
VALUES ('The Shawshank Redemption', 9.3, 7, '1994-10-14', 142, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;


-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE actors.id = 48;

-- Crear una tabla temporal copia de la tabla movies.
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

SELECT * from movies_copia_temp;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE
FROM movies_copia_temp
WHERE awards < 5;


-- Obtener la lista de todos los géneros que tengan al menos una película.

SELECT DISTINCT  g.name  FROM genres g
JOIN movies m ON m.genre_id = g.id ;

--  Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.first_name , a.last_name, m.awards  FROM actors a
JOIN movies m ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX idx_movie_name ON movies (title);

-- Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;
