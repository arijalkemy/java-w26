SELECT * FROM genres;
SELECT * FROM movies;
SELECT * FROM actors; 

INSERT INTO movies (title, rating, awards, release_date, length, genre_id) 
VALUES ("Air", 8, 10, "2010-10-04 00:00:00", 120, 1);

INSERT INTO genres (name, ranking, active)
VALUES ("Suspenso", 13, 1);

UPDATE movies
SET genre_id = 14
WHERE id = 22;

UPDATE actors
SET favorite_movie_id = 22
WHERE actors.id = 3;

CREATE TEMPORARY TABLE movies_copy AS
SELECT * FROM movies;

DELETE FROM movies_copy 
WHERE awards < 5;

SELECT DISTINCT genre_id
FROM movies;

SELECT first_name 
FROM actors 
WHERE favorite_movie_id IN (
	SELECT id 
    FROM movies
    WHERE awards > 3
    );
    
CREATE INDEX title ON movies(title);

SHOW INDEX FROM movies;

#Analisis Movies.title deberia estar indexada ya que esta sobre una DB acerca de peliculas por lo cual deberia ser uno de los atributos mas buscados dentro de esta DB

#Analisis donde crear un segundo indice, Tabla Actors, Columna first_name, Ya que es una tabla que tiene varias relaciones muchos a muchos por lo que varios consultas estaran 
#relacionadas a esta tabla.
