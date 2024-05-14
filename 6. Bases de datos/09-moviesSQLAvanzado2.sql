-- Agregar una película a la tabla movies.
INSERT INTO movies(title, created_at, rating, awards, release_date, length, genre_id) VALUES
('Alicia en el pais de las maravillas', NOW(), 8, 2, '2003-04-04 00:00:00', 120, 5)

-- Agregar un género a la tabla genres.
INSERT INTO genres(created_at, name, ranking, active) VALUES 
(NOW(), 'Familiar', 13, 1)

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies m
SET m.genre_id = 13
WHERE m.title = 'Alicia en el pais de las maravillas'

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
INSERT INTO actors(created_at, first_name, last_name, rating, favorite_movie_id) VALUES
(NOW(), 'Laia', 'Costa', 10, 22)

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE moviesTMP (id int, created_at timestamp, updated_at timestamp, title varchar(500), rating decimal(3,1), 
									awards int, release_date datetime, length int, genre_id int)

INSERT INTO moviesTMP 
SELECT * FROM movies

SELECT * FROM moviesTMP

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM moviesTMP
WHERE awards < 5

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* FROM genres g 
INNER JOIN movies m ON m.genre_id = g.id 

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* FROM actors a 
INNER JOIN movies m ON a.favorite_movie_id = m.id 
WHERE m.awards > 3

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_title_id ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- Teniendo en cuenta que muchas veces se va a buscar por nombre de la pelicula y no por ID, creemos que si mejoraria notablemente el uso de ese indice.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- Partiendo de la misma idea tambien se podria crear en series en el campo title.