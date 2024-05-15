-- 1)
-- INSERT INTO movies (title, rating, awards, release_date, length, genre_id) 
-- VALUES ('Relatos Salvajes', 9.9, 2, '2022-04-04', 160, 3);

-- 2)
-- INSERT INTO genres (name,ranking,active)
-- VALUES ('Comedia Tragica', 13, 1);

-- 3)
-- UPDATE movies SET genre_id = 13 where id = 22;

-- 4)
-- UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;

-- 5) 
-- CREATE TEMPORARY TABLE temp_movies 
-- SELECT * FROM MOVIES;

-- 6)
-- DELETE FROM temp_movies WHERE awards < 5;

-- 7) 
-- SELECT gen.name
-- FROM movies mov 
-- INNER JOIN genres gen ON mov.genre_id = gen.id
-- GROUP BY gen.name;


-- 8)
-- SELECT * FROM actors 
-- WHERE favorite_movie_id IN (SELECT id FROM movies WHERE awards > 3);


-- 9)
-- CREATE INDEX idx_title ON movies(title);

-- 10)
-- SHOW INDEX FROM movies;

-- 11) 
-- Considero que habria una mejora considerable ya que es muy comun buscar peliculas por su titulo
-- Al ser esta una busqueda concurrente, optimizarla con un indice en la columna title daria una mejora de la misma.

-- 12) 
-- Considero que poner un indice en la release_date tambien seria adecuado ya que es una busqueda que puede ser usual
-- Sumando tambien que el release_date no va a cambiar con el tiempo, por lo que el coste es minimo.

