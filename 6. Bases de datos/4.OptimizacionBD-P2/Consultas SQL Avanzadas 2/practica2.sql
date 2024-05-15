-- PRACTICA: CREACION DE DTABLAS TEMPRALES E INDICES
USE movies_db;

-- EJERCICIO 1

-- 1. CREAR TABLA TEMPORAL TWD
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

-- 2. REALIZAR UNA CONSULTA PARA VER LOS EPISODIOS DE LA TEMPORADA 1
SELECT t.*
FROM TWD t
WHERE t.season = 1;

-- EJERCICIO 2
-- 1.
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

-- 2. Agregar un género a la tabla genres.
INSERT INTO movies_db.genres (created_at, updated_at, name, ranking, active)
VALUES ('2024-05-14 15:30:22', null, 'Animales', 13, 1);

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies_db.movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (null, null, 'Garfield', 4.9, 0, '2024-05-01 15:29:05', 130, 13);
UPDATE movies_db.actors t

-- 4.Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SET t.favorite_movie_id = 22
WHERE t.id = 39;

-- 5.Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp
SELECT *
FROM movies;

-- 6.Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE
FROM movies_temp mp
WHERE mp.awards < 5;

-- 7 Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name
FROM genres g
         INNER JOIN movies m on g.id = m.genre_id
GROUP BY g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT g.name
FROM genres g
         INNER JOIN movies_temp mt on g.id = mt.genre_id
GROUP BY g.id;

-- 9. Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
    ADD INDEX title_idx (title);

ALTER TABLE movies
    ADD INDEX awards (awards);
 
ALTER TABLE episodes
    ADD INDEX title_idx (title);
-- 10. Chequee que el índice fue creado correctamente.
EXPLAIN SELECT * FROM movies WHERE title LIKE 'G%';
-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Consideramos que sí, Sin embargo lo ideal es utilizarlos en las columnas que sean aptas para ello, porque consideramos
-- que hay una gran cantidad de columnas que pueden ser suceptibles a una gran cantidad de actualizaciones como el rating de peliculas y actores.
-- Por otro lado, columnas como la de la cantidad de premios o el nombre de peliculas o series pueden ser ideales para la utilización de indices,
-- por su naturaleza estatica y de alto interés para los usuarios. 

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Agregaríamos indices en la tabla seasons, por ejemplo en la columna titulo o en la columna titulo de la tabla episodios
-- Ya que ambas columnas son relativamente estaticas (sus datos no cambian de manera frecuente)y de alta concurrencia debido a que muchos usuarios podrían buscar sus temporadas y episodios de sus series favoritas,
-- ási que optimizar dichas consultas mediante el uso de indices puede ser buena idea.

