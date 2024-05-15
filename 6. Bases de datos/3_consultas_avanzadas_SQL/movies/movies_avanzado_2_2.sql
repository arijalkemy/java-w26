# 1. Agregar una película a la tabla movies.
# 2. Agregar un género a la tabla genres.
# 3. Asociar a la película del punto 1. genre el género creado en el punto 2.

INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES ("2000-01-01", "2001-01-01", "Fantasia fantastica", 13, 1);

INSERT INTO movies (created_at, updated_at, title, rating, awards,release_date,length, genre_id)
VALUES ("2000-01-01", "2001-01-01", "Avatar 2", 8.1, 5, "2022-01-02", 200, 13);

# 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 1;

# 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temporal_movies (
	SELECT * FROM movies
);

# 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temporal_movies tm WHERE tm.awards < 5;

# 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, COUNT(*) as cant_movies FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING cant_movies > 0;

# 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name FROM actors a
INNER JOIN movies m ON m.id = a.favorite_movie_id;

# 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title_movies ON movies(title);

# 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

# 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

EXPLAIN SELECT * FROM movies WHERE awards = 5;
# Busca en todas las movies

CREATE INDEX index_awards_movies ON movies(awards);
# Gracias a esto, busca en solo las específicas indexadas

CREATE INDEX index_title_episodes ON episodes(title);



