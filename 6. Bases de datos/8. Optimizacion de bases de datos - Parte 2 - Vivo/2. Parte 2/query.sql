use movies_db;

-- 1: Agregar una película a la tabla movies. 
INSERT INTO movies (title, rating, awards, release_date, `length`, genre_id)
VALUES ('The Shawshank Redemption', 9.3, 7, '1994-10-14', 142, 1);

-- 2: Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking , active)
VALUES ("Thriller", 13, 1);

-- 3: Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;

-- 4: Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE actors.id = 48;

-- 5: Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copia_temp (
    title VARCHAR(255),
    rating DECIMAL(3, 1),
    awards INT,
    release_date DATE,
    length INT,
    genre_id INT
);

INSERT INTO movies_copia_temp (title, rating, awards, release_date, `length`, genre_id)
SELECT title, rating, awards, release_date, `length`, genre_id
FROM movies;

-- 6: Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copia_temp WHERE awards < 5; 

-- 7: Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name AS genre_name
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name;

-- 8: Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, m.title, m.awards FROM actors a 
INNER JOIN movies m on a.favorite_movie_id = m.id 
WHERE m.awards > 3; 

-- 9: Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_title ON movies (title);
 
-- 11: 
-- Creamos un índice en la columna `title` de la tabla `movies`.
-- Esto se hace porque es más común buscar películas por su título, ya que los usuarios suelen recordar el nombre de la película que desean encontrar.
-- Al crear un índice en esta columna, mejoramos el rendimiento de las consultas que involucran búsquedas o filtros por el título de la película.

-- 12: 
-- Otro lugar donde se podria crear un index es dentro de la tabla 'actors'
-- Ya que tambien es comun buscar peliculas, series, etc por medio del nombre del actor 


