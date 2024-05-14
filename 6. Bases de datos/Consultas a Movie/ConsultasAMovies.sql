-- Agregar una película a la tabla movies.

INSERT INTO movies(title, rating, awards, length, genre_id, release_date) values 
("Tarzan", 7.4, 3.0, 90, 2, '20240101');

-- Agregar un género a la tabla genres.

INSERT INTO movies_db.genres
(created_at, name, ranking, active)
VALUES( '20240101',  'Animacion', 14, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.


-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.


-- Crear una tabla temporal copia de la tabla movies.


-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.


-- Obtener la lista de todos los géneros que tengan al menos una película.


-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.


-- Crear un índice sobre el nombre en la tabla movies.


-- Chequee que el índice fue creado correctamente.


-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.


-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta