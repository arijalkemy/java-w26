USE movies_db;

-- Crear una tabla temporal TWD con datos de series, temporadas y capítulos específicos
CREATE TEMPORARY TABLE TWD AS
SELECT DISTINCT
    se.title AS tSerie,
    ss.title AS tTemporada,
    e.title AS tCapitulo
FROM
    series se
INNER JOIN
    seasons ss ON se.title = 'The Walking Dead'
INNER JOIN
    episodes e ON ss.id = e.season_id;

-- Seleccionar todos los registros de TWD donde la temporada sea 'Primer Temporada'
SELECT * FROM TWD
WHERE tTemporada = 'Primer Temporada';

-- Seleccionar todos los registros de las tablas movies y genres
SELECT * FROM movies;
SELECT * FROM genres;

-- 1. Agregar una nueva película a la tabla movies
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Nueva Película', 8.5, 3, '2024-05-17 00:00:00', 120, null);

-- 2. Agregar un nuevo género a la tabla genres
INSERT INTO genres (name, ranking, active)
VALUES ('Nuevo Género', 13, 1);

-- 3. Asociar la nueva película con el nuevo género
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Nuevo Género')
WHERE title = 'Nueva Película';

-- 4. Actualizar la tabla actors para que al menos un actor tenga como favorita la nueva película
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Nueva Película')
WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies
CREATE TEMPORARY TABLE temp_movies AS
SELECT * FROM movies;

-- 6. Eliminar de la tabla temporal todas las películas que hayan ganado menos de 5 premios
DELETE FROM temp_movies
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película
SELECT DISTINCT g.*
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 premios
SELECT a.*
FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies
CREATE INDEX idx_movie_title ON movies (title);

-- 10. Verificar que el índice fue creado correctamente
SHOW INDEX FROM movies WHERE Key_name = 'idx_movie_title';

-- 11. Mejora notable al crear índices en la base de datos
-- Crear un índice en la columna title puede acelerar las búsquedas de películas por título,
-- mejorando el tiempo de respuesta para las consultas que filtren o busquen por el nombre de la película.

-- 12. Sugerencia para otro índice
-- Crear un índice en la columna last_name de la tabla actors
-- para mejorar la eficiencia de las búsquedas y operaciones de filtrado por apellido.
