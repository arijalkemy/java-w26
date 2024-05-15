-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES(22, null, null, 'Pulp Fiction', 8.2, 3, '1986-05-03 00:00:00', 120, 3);
SELECT * FROM movies order by id DESC; -- checkear si la peli se creo con exito

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES(13, '1980-04-12 00:00:00', null, 'Thriller', 13, 1);
SELECT * FROM genres order by name DESC; -- checkea si se crea con exito

-- Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies
SET genre_id=13
WHERE title='Pulp Fiction';

SELECT * FROM movies WHERE title='Pulp Fiction';
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id= 22
WHERE id=1;

SELECT * FROM actors;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE peliculas AS
SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM peliculas
WHERE awards<5;

SELECT * FROM peliculas;
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres 
WHERE id IN (SELECT genre_id FROM movies);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT A.first_name, A.last_name, A.rating, M.title AS Favorite_movie, M.awards FROM actors A JOIN movies M ON (A.favorite_movie_id=M.id)
WHERE M.awards>3 order by A.first_name, A.last_name;
EXPLAIN SELECT * FROM movies WHERE title='Pulp Fiction';

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX indice_title ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
 
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT * FROM movies WHERE title="Pulp Fiction";
# La creacion de indices en la tabla, nos sirve para que las busquedas en la tabla sean las mas rapidas posibles, optimizando tiempos y acceso al mismo
# por Ej: sin el index en movies, tardo 22 ciclos y con el index, 1
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# En la tabla seasons, ya que su tabla es necesaria para las consultas respecto a las series y episodios, para facilitar la busqueda de la misma