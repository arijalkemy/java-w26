#Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
#y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD (temporada VARCHAR(40), nroCapitulo INT, tituloCapitulo VARCHAR(40));

INSERT INTO TWD SELECT s.title, e.`number`, e.title FROM episodes e 
INNER JOIN seasons s ON e.season_id  = s.id 
INNER JOIN series s2 ON s.serie_id  = s2.id 
WHERE s2.title LIKE '%Walking Dead%';

#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT nroCapitulo, tituloCapitulo FROM TWD WHERE temporada = 'Primer Temporada';

#Considero que un indice de titulos en la tabla movies seria ideal debido a la cantidad de consultas que recibe.
CREATE INDEX movies_idx ON movies (title);
SHOW INDEX from movies;

#Agregar una película a la tabla movies.
INSERT INTO movies_db.movies
(created_at, updated_at, title, rating, awards, release_date, `length`, genre_id)
VALUES(NULL, NULL, 'MELI Movie', 8.1, 3, '2016-05-04 00:00:00', 80, 10);

#Agregar un género a la tabla genres.
INSERT INTO movies_db.genres
(created_at, updated_at, name, ranking, active)
VALUES('2013-07-04 00:00:00', NULL, 'Corporativo', 13, 1);

#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = (SELECT id FROM genres WHERE name ='Corporativo') WHERE title = 'MELI Movie';

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors a SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'MELI Movie') 
WHERE a.first_name = 'Bryan' AND a.last_name = 'Cranston'; 

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE Movie_Table (id int, create_at date, updated_at date, titulo VARCHAR(255), rating DECIMAL(10,2), awards INT, release_date DATETIME, length int, genre_id int);
INSERT INTO Movie_Table SELECT * FROM movies;

SELECT titulo from Movie_Table WHERE awards >= 5;

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM Movie_Table WHERE awards < 5;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, COUNT(*) as Cantidad_Peliculas FROM genres g 
INNER JOIN movies m ON g.id = m.genre_id 
GROUP BY g.name;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name FROM actors a
INNER JOIN movies m ON a.favorite_movie_id  = m.id 
WHERE m.awards > 3; 

#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX mv_idx ON movies(title);

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
 Considero que la mejora al integrar indices seria casi imperceptible debido a que la BD movies tiene pocos registros en sus tablas.
*/

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
 Si la BD actual fuera mucho mas grande, crearia un indice en la tabla actors,
ya que suele ser una tabla muy consultada y no opera frecuentemente con adiciones o modificaciones de datos.
 */


