# 1. Agregar una película a la tabla movies.
INSERT INTO genres (id, created_at, updated_at, name, ranking, active) VALUES(null, '2013-07-01', null, 'Diversión Colombiana', 13, 1);
# 2. Agregar un género a la tabla genres.
# 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
INSERT INTO movies  VALUES(null,'2024-01-01',null, 'pelicula MELI', 10.0, 3, '2024-01-01', 90, 16);

# 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 1;

# 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
SELECT * FROM movies;

# 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;

# 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT ge.* 
FROM genres ge
INNER JOIN movies mo
ON mo.genre_id = ge.id;

# 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ac.*
FROM actors ac
WHERE ac.favorite_movie_id IN (SELECT id FROM movies WHERE awards > 3);

# 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx 
ON movies (title);

# 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies WHERE Key_name = 'title_idx';

/* 
11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta:
Los indices tienen eficiencia o mejoras cuando en la tabla de la base de datos hay muchos datos, 
pero en este caso al tener pocos datos en la tabla no se van a ver resultados eficientes
*/

/*
12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta:
Se le agregarían los indices a los campos de titulos o nombres por ser recurrentes en los WHERE, 
así como también campos que pueden ser usados como funciones de agregación en las consultas
*/