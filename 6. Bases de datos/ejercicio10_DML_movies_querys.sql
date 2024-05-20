-- 1. Se agrega una película a la tabla movies
INSERT INTO movies(created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (now(), now(), "Los vengadores", 10, 0, "2023-04-04", 180, 5);

-- 2. Se agrega un género a la tabla genres.
INSERT INTO genres(created_at, updated_at, name, ranking, active)
VALUES (now(), now(), "Super Heroes", 13, 1);

-- 3. Se asocia a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- 4. Se Modifica la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 1;

-- 5. Se crea una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE IF NOT EXISTS movies_temp AS
SELECT * FROM movies;

-- 6. Se elimina de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp
WHERE awards < 5;

-- 7. Se obtiene la lista de todos los géneros que tengan al menos una película.
SELECT g.name
FROM genres g
INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.id;

-- 8. Se obtiene la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
FROM actors a
INNER JOIN actor_movie am ON am.actor_id = a.id
INNER JOIN movies m ON m.id = am.movie_id
WHERE m.awards > 3;

-- 9. Se crea un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title
ON movies (title);

-- 10. Se Chequea que el índice fue creado correctamente.
SHOW INDEX FROM movies;

/*
11. De acuerdo a la optimización en el punto 9, la búsqueda por nombre en la tabla "movies" ya no necesita escanear todas las filas. 
Esta mejora es especialmente beneficiosa, ya que las películas a menudo se buscan por su nombre en lugar de por su id. 
Esta eficiencia se puede demostrar al ejecutar la siguiente consulta:
*/
EXPLAIN SELECT * FROM movies
WHERE title = "buscando a";

/*
12. Se recomienda crear un índice adicional para la columna "last_name" en la tabla "actors". 
Esta mejora es conveniente, ya que frecuentemente se hace referencia a los actores por su apellido en lugar de por su id o su nombre.
*/
CREATE INDEX index_last_name
ON actors(last_name);

-- Se muestran los indexs en la tabla de actors
SHOW INDEX FROM actors;