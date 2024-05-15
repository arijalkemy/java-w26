USE movies_db;

#Agregar una película a la tabla movies.
INSERT INTO `movies_db`.`movies`
(`title`,
`rating`,
`awards`,
`release_date`,
`length`,
`genre_id`)
VALUES
('My New Movie', -- Title of the movie
9.0, -- Rating of the movie
0, -- No awards yet
'2024-05-14', -- Release date of the movie (replace with the actual release date)
120, -- Length of the movie in minutes (replace with the actual length)
1); -- Genre ID of the movie (replace with the actual genre ID)

#Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres`
(`name`,
`ranking`,
`active`)
VALUES
('Prueba', -- Name of the genre (replace with the actual genre name)
13, -- Ranking of the genre (replace with the actual ranking)
1); -- Active status of the genre (1 for active, 0 for inactive)

#Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies AS m
JOIN genres AS g ON g.id = m.genre_id
SET m.genre_id = (SELECT id FROM genres WHERE name = 'Prueba')
WHERE m.id = (SELECT id FROM (SELECT id FROM movies WHERE title = 'My New Movie') AS temp);

SELECT m.title, g.name genre from movies m JOIN genres g ON g.id = m.genre_id
WHERE m.title LIKE '%My New Movie%';


#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors a 
SET a.favorite_movie_id = (SELECT id FROM movies m WHERE m.title LIKE 'My New Movie')
LIMIT 1;

SELECT * from actors a 
WHERE a.favorite_movie_id = (SELECT id FROM movies m WHERE m.title LIKE 'My New Movie');

#Crear una tabla temporal copia de la tabla movies.
DROP TABLE IF EXISTS movies_temp;
CREATE TEMPORARY TABLE movies_temp (
	id INT NOT NULL PRIMARY KEY,
    title VARCHAR(500),
    rating DECIMAL(3,1),
    awards INT,
    length INT
);

INSERT INTO movies_temp (id, title, rating, awards, length)
SELECT id, title, rating, awards, length
FROM movies;

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

SELECT awards FROM movies_temp;

# Creo una tabla temporal para eliminar por id ya que el modo seguro no permite hacerlo por claves no PK.
CREATE TEMPORARY TABLE temp_ids
SELECT id
FROM movies_temp
WHERE awards < 5;

DELETE FROM movies_temp
WHERE id IN (SELECT id FROM temp_ids);

DROP TEMPORARY TABLE IF EXISTS temp_ids;

SELECT awards FROM movies_temp;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name 
FROM genres g
JOIN movies m ON g.id = m.genre_id;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_name ON movies(title);

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

#En la base de datos movies ¿Existiría una mejora notable al crear índices? 

-- Comunmente no sería notable, 

#Analizar y justificar la respuesta.

/*
Cuenta con muy pocos registros y la mejora en el 
rendimiento normalmente sería insignificante. Si la base de datos contara el día 
de mañana con mayor cantidad de registros, y siendo que estos no deberían de modificarse
frecuentemente, la creación de indices en forma apropiada podría mejorar considerablemente 
el rendimiento de la misma
*/

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

/* Crearía indices para aquellos campos que se utilicen habitualmente como
parametro de consultas, como podría ser nombre y/o apellido del actor entre
otros, además es importante considerar que tan habitualmente se actualizan
los registros de la tabla indexada ya que el proceso de re-indexación tiene
un costo en la performance de la base de datos sobre todo si la actualización
se lleva a cabo sobre el campo a indexar */
