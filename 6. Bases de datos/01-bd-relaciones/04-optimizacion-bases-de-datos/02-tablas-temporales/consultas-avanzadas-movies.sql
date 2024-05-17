-- 1. Agregar una película a la tabla movies.

INSERT INTO MOVIES VALUES (22, null, null, "Barbarian", 7.0, 4, "2022-09-09 00:00:00", 100, 2);

-- 2. Agregar un género a la tabla genres.

INSERT INTO GENRES VALUES (13, "2024-05-14 00:00:00", null, "Romance", 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE MOVIES SET genre_id = 13 WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE ACTORS SET favorite_movie_id = 22 WHERE ID = 5;

-- 5. Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_copy SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM movies_copy WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.

SELECT name, count(*) as cantidadPeliculas FROM genres gn
JOIN movies mv ON gn.id = mv.genre_id
GROUP BY genre_id
HAVING cantidadPeliculas >= 1;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT DISTINCT first_name, last_name FROM actors ac
JOIN actor_movie am ON ac.id = am.actor_id
JOIN movies mv ON am.actor_id = mv.id
WHERE awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX title_name_index ON movies(title);

EXPLAIN SELECT * FROM movies WHERE title LIKE "Harry Potter%";

-- 10. Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- R/. Sí, por que al hacer la busqueda el indice mejora significativamente el rendimiento de las consultas.
-- En lugar de buscar secuencialmente la base de datos utiliza el indice para encontrar rapidamente las coincidencias de la busqueda

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- En el nombre del actor en la tabla actors, ya que es una de las tablas a las que mas se le hacen consultas

CREATE INDEX actor_name_index ON actors(first_name);

EXPLAIN SELECT * FROM actors WHERE first_name = "Daniel";

SHOW INDEX FROM actors;