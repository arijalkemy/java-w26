/*
	Crea un registro en la table de movies
*/
DESCRIBE movies;
INSERT INTO movies (title, rating, awards, release_date) VALUES ("ALEXIS'S MOVIE", 10.0, 8, NOW());

/*
	Crea un genre
*/
DESCRIBE genres;
INSERT INTO genres (name, ranking, active) VALUES("informatico", 7, 1);

/*
	Actualiza el registro de movies que creaste en el punto uno añadiendo el genre que creamos en el punto dos
*/
UPDATE movies set genre_id=(SELECT id FROM genres WHERE name="informatico") WHERE title = "ALEXIS'S MOVIE";

/*
	Modifica la tabla actors para que almenos un actor tenga como favorita la pelicula que creaste.
*/
SELECT * FROM actors;
UPDATE actors set favorite_movie=(SELECT id FROM movies WHERE name="ALEXIS'S MOVIE") WHERE favorite_movie=NULL;

/*
	Crea una tabla temporal que sea la copia de la tabla movies.
*/
CREATE TEMPORARY TABLE movies_copy
SELECT * FROM movies;

/*
	Eliminar de la table temporal todas las peliculas que hayan ganado menos de cinco awards.
*/
DELETE FROM movies_copy WHERE awards < 5;

/*
	Obtener una lista de todos los generos que tiene una pelicula
*/
SELECT name FROM genres JOIN movies ON genres.id=genre_id;

/*
	Obtener una lista de actores cuya lista de movies haya ganado mas de 3 premios
*/
SELECT first_name, awards FROM actors JOIN movies ON favorite_movie_id=movies.id WHERE awards > 3;

/*
	Crear un indice sobre la tabla movies
*/
CREATE INDEX title_index ON movies(title);

/*
	Revisar que el indice fue creado correctamente
*/
SHOW INDEX FROM movies;

/*
	En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

    RESPUESTA:
    SI, porque una base de datos de peliculas puede ser enorme, y suelen haber a priori
    mas lecturas que escrituras por lo que la creacion de indices en columnas especificas de tablas especificas
    puede mejorar enormemente le performance de nuestras consultas.
*/

/*
	¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

    RESPUESTA:
    Algunos posibles buenos indices que podemos implementar son los siguientes:

    Sobre el titulo de la tabla series y de la tabla movies: Porque el titulo es el mas importante atributo de una serie
    ya que en los buscadores la mayoria de las veces se realiza la busqueda por el nombre.

*/
