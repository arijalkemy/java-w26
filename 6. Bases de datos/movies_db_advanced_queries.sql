-- Use the db for movies
USE movies_db;


-- 1. Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES ('2024-05-14 10:00:00', '2024-05-14 10:00:00', 'Sample Movie', 8.5, 3, '2024-05-14', 120, null);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES ('2024-05-14 14:00:00', '2024-05-14 14:00:00', 'Cyberpunk', 13, TRUE);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Cyberpunk')
WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga
-- como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Sample Movie')
WHERE id = 1;
SELECT * FROM actors WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS SELECT * FROM movies;
SELECT * FROM movies_copy;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan
-- ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
START TRANSACTION;
DELETE FROM movies_copy WHERE awards < 5;
SELECT * FROM movies_copy;
COMMIT;
SET SQL_SAFE_UPDATES = 1;

-- 7. Obtener la lista de todos los géneros que tengan al menos
-- una película.
SELECT g.*, COUNT(g.id) mov_count
FROM genres g
JOIN movies m ON m.genre_id = g.id
GROUP BY g.id, g.name;

-- 8. Obtener la lista de actores cuya película favorita haya
-- ganado más de 3 awards.
SELECT a.*, m.title, m.awards
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3
;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable
-- al crear índices? Analizar y justificar la respuesta.
/*
* Tener el id como indice no es suficiente cuando un usuario no lo conoce,
* El usuario conoce cosas como el titulo de la pelicula o su fecha de
* lanzamiento, por lo cual es una buena decision hacer esos campos indices.
*/

-- 12. ¿En qué otra tabla crearía un índice y por qué?
-- Justificar la respuesta
/*
* En la tabla de series, con indices por titulo y por las fechas,
* en la tabla de actores, con indices por nombre y apellido.
* Esto por las mismas razones del anterior punto, le brindo al usuario
* la opcion de buscar por lo que este conoce.
*/
