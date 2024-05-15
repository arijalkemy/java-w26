
-- Consultas SQL Avanzadas 2

-- Punto 1
-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, null, null, 'Star Wars 7', 8.2, 2, '2010-10-04', 200, 5);

-- Punto 2
-- Agregar un género a la tabla genres.
INSERT INTO genres 
VALUES (13, null, null, 'Espacial', 13, 1);

-- Punto 3
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 
WHERE id = 22;

-- Punto 4
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 
WHERE id = 4;

-- Punto 5
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies (id int, created_at timestamp, updated_at timestamp, title varchar(500), rating decimal(3,1), awards int, release_date datetime, length int, genre_id int);
INSERT INTO temp_movies SELECT * FROM movies;

-- Punto 6
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temp_movies WHERE awards < 5;

-- Punto 7
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres WHERE id IN (SELECT DISTINCT genre_id FROM movies);

-- Punto 8
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors WHERE favorite_movie_id IN (SELECT id FROM movies WHERE awards > 3);

-- Punto 9
-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;

-- Punto 10
-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT title FROM movies
WHERE title = 'Avatar';

-- punto 11
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Si se utiliza indices en campos consultados frecuentemente como títulos de peliculas o nombres de actores, se
podría obtener una mejora en las consultas, ya que es posible que se busque más un título que por su id, sin embargo
en el caso de esta base de datos en particular, no posee tantos registros como para que sea una mejora notable.
*/

-- Punto 12
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
Crearía índices en las tablas donde se puedan realizar consultas frecuentes, por ejemplo en movies.title 
o actors.first_name y actors.last_name, la razón sería la misma, son tablas a las que es más probable 
que se realicen consultas frecuentes en las mismas.
*/
