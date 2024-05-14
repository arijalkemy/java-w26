-- Ejercicio 1

USE movies_db;
-- Crear la tabla temporal con los episodios de The walking dead
CREATE TEMPORARY TABLE TWD
SELECT s.title AS "TITULO_SERIE", se.title AS "TEMPORADA", e.title AS "NOMBRE_CAP"
FROM series s
JOIN seasons se ON s.id = se.serie_id
JOIN episodes e ON e.season_id = se.id
WHERE s.title LIKE "The Walking Dead";

-- Buscar los episodios de la primera temporada
SELECT *
FROM TWD
WHERE TEMPORADA LIKE "Primer Temporada"; 

-- Creador de indices
ALTER TABLE actors
ADD INDEX busqueda_apellido_actor last_name;

-- Ejercicio Grupal 2

USE movies_db;
-- Agregar una película a la tabla movies.
INSERT INTO movies(title,rating,awards,release_date,length,genre_id)
            VALUES("Interestellar",10.0,3,"2014-05-12",180,5);
-- Agregar un género a la tabla genres.
INSERT INTO genres(name,ranking,active)
            VALUES("Espacial",13,1);
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies m
SET genre_id = 13
WHERE m.title LIKE "Interestellar";
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE first_name LIKE "Jim";
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copia SELECT * FROM movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copia
WHERE awards < 5;
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON m.genre_id = g.id;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT DISTINCT a.*
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX nombre_pelicula(title);
-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT *
FROM movies m
WHERE m.title LIKE "La Guerra%";
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta