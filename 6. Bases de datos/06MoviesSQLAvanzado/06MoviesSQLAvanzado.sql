/* 1. Agregar una película a la tabla movies. */
INSERT INTO movies (title, rating, awards, release_date, length, genre_id) 
VALUES (
	"The Batman",
    10,
	4,
    "2022-01-01",
    170,
    1
);
/* 2. Agregar un género a la tabla genres. */
INSERT INTO genres (name, ranking, active) 
VALUES (
	"Mystery",
    100,
    1
);
/* 3. Asociar a la película del punto 1. genre el género creado en el punto 2. */
UPDATE movies
SET genre_id = 15 
WHERE id = 22;

/* 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1. */
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 30;

/* 5. Crear una tabla temporal copia de la tabla movies. */
CREATE TEMPORARY TABLE MOVIESCOPY (
	id int NOT NULL PRIMARY KEY,
    created_at timestamp,
    updated_at timestamp,
    title varchar(500),
    rating decimal(3,1) NOT NULL,
    awards int NOT NULL,
    release_date datetime,
    length int NOT NULL,
    genre_id int NOT NULL
);

/* 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards. */
DELETE
FROM moviescopy
WHERE awards < 5;

/* 7. Obtener la lista de todos los géneros que tengan al menos una película. */
SELECT DISTINCT g.name, COUNT(*) cant
FROM movies m
INNER JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING cant > 1;

/* 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards. */
SELECT *
FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

/* 9. Crear un índice sobre el nombre en la tabla movies. */
CREATE INDEX peliculas_idx
ON movies (title);

/* 10. Chequee que el índice fue creado correctamente. */
EXPLAIN SELECT *
FROM movies
WHERE title = 'Toy Story';

/* 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta. 
	Es probable que sí ya que el nombre de la película es una consulta bastante frecuente. Sin embargo, 
    se suele buscar por ID así que podría justificarse el hecho de no agregar más índices. */
    
/* 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta. 
	En la tabla de temporadas, concretamente en la columna serie_id para buscar temporadas por serie, que es una consulta frecuente. */