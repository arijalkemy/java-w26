/* Agregar una película a la tabla movies.
	Agregar un género a la tabla genres.
Asociar a la película del punto 1. genre el género creado en el punto 2.
Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Crear una tabla temporal copia de la tabla movies.
Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
*/

USE movies_db;

INSERT INTO movies (created_at, title, rating,awards, release_date,length) VALUES (sysdate(),'El día que la tierra se detuvo',5,0,'2008-01-02',104);

INSERT INTO genres (created_at, name, ranking,active) VALUES (sysdate(),'Catástrofe',13,TRUE);

UPDATE movies SET genre_id=14 WHERE id=22;

UPDATE actors SET favorite_movie_id=22 WHERE id=47;

DROP TABLE movie_copy;

CREATE TEMPORARY TABLE movie_copy (
	id INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR (500),
    rating DECIMAL(3,1),
    awards INTEGER,
    release_date DATETIME,
    length INTEGER,
    genre_id INTEGER
);

INSERT INTO movie_copy SELECT * FROM movies;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM movie_copy WHERE movie_copy.awards >2;

SET SQL_SAFE_UPDATES =1;

/*
Obtener la lista de todos los géneros que tengan al menos una película.
Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Crear un índice sobre el nombre en la tabla movies.
Chequee que el índice fue creado correctamente.
En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
*/


SELECT COUNT(*), genre_id
FROM movies m INNER JOIN genres g ON m.genre_id=g.id
GROUP BY genre_id
HAVING COUNT(*) > 1;

SELECT a.first_name, a.last_name, m.title
FROM actors a INNER JOIN movies m ON a.favorite_movie_id=m.id
WHERE m.awards> 3;

CREATE INDEX movie_titleInd ON movies(title);

SHOW INDEX FROM movies;


