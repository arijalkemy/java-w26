-- 1. Agregar una película a la tabla movies.
INSERT INTO movies
(title, rating, awards, release_date, `length`)
VALUES('Fight Club', '10', '3', '1999-04-15 00:00:00', 139);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres
(name, ranking, active)
VALUES('Psychological Thriller', '13', 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 4;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE IF NOT EXISTS movies_TEMP AS SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_TEMP WHERE awards >= 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name FROM genres g 
JOIN movies m 
ON g.id = m.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name 
FROM actors a
JOIN movies m ON a.favorite_movie_id  = m.id 
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies ADD INDEX name_idx(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
 * Considero que si existe una mejora notable creando el indice sobre el nombre en la tabla movies porque es una tabla que no va a ser frecuentemente actualizada
 * y las búsquedas sobre esta tabla en la gran mayoría de los casos se harían por este campo ya que es el que identifica de una forma natural a las entidades.
 */

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
 * Crearía un indice sobre la tabla actors sobre el campo last_name ya que es un campo que no va a ser modificado una vez seteado y es un campo que si bien puede
 * ser repetido en diferentes registros es un campo por el que normalmente se va a buscar actores y por el que las consultas pueden ser muy rápidas, directas y eficientes.
 */ 