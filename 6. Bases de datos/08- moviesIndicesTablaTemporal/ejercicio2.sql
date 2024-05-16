USE movies_db;
-- Agregar una película a la tabla movies.
INSERT INTO movies(title,rating,awards,release_date,length,genre_id)
            VALUES("Interestellar",10.0,3,"2014-05-12",180,5);
-- Agregar un género a la tabla genres.
INSERT INTO genres(name,ranking,active)
            VALUES("Espacial",13,1);
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies m
SET genre_id = 13
WHERE m.title LIKE "Interestellar";
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE first_name LIKE "Jim";
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copia SELECT * FROM movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copia
WHERE awards < 5;
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON m.genre_id = g.id;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.first_name, a.last_name
from actors a
where a.favorite_movie_id in (
		select m.id from movies m where m.awards > 3
)
;
-- Crear un índice sobre el nombre en la tabla movies.
alter table movies
add index busqueda_nombre_pelicula (title);

-- Chequee que el índice fue creado correctamente.
show index from movies;
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- En mi opinion, diria que si. Busquedas comunes podrían ser, por ejemplo, obtener el titulo de alguna pelicula y al tener el indice creado para esa columna se podría acceder de forma directa a ese campo.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearía indices tanto en series, episodes y seasons siguiendo la misma lógica de movies. Ya que el titulo de cada uno de los registros de esas tablas fueron solicitados en más de una ocasión en esta ejercitacion
-- demostrando que se podría optimizar esas busquedas. 
