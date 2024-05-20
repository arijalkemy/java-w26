
USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, title, rating,awards, release_date,length) VALUES (sysdate(),'El día que la tierra se detuvo',5,0,'2008-01-02',104);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, name, ranking,active) VALUES (sysdate(),'Catástrofe',13,TRUE);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id=14 WHERE id=22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id=22 WHERE id=47;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movie_copy (
	id INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR (500),
    rating DECIMAL(3,1),
    awards INTEGER,
    release_date DATETIME,
    length INTEGER,
    genre_id INTEGER
);

INSERT INTO movie_copy SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movie_copy WHERE movie_copy.awards <5;
SET SQL_SAFE_UPDATES =1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT COUNT(*), genre_id
FROM movies m INNER JOIN genres g ON m.genre_id=g.id
GROUP BY genre_id
HAVING COUNT(*) > 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name
FROM actors a INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX titleIdx ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies, ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
--    En esta base de datos no creo que la mejora sea notable, ya que la cantidad de registros es poca, pero cuando
--    se tengan miles y cientos de miles de registros, el índice podrá ayudar a mejorar el tiempo de respuesta
--    ya que generalmente las búsquedas de este tipo de entidades se realizan por nombre.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
--    En la tabla genres colocaria un indice sobre el atributo name, ya que normalmente se usa ese parametro 
--    en las busquedas de series y peliculas.