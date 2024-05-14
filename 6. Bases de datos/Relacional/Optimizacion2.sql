-- 1
INSERT INTO MOVIES VALUES (22, null, null, " Los Goonies", 10.0, 4, "1980-06-07 00:00:00", 90, 8);

-- 2
INSERT INTO GENRES VALUES (13, "2024-05-14 00:00:00", null, "Piratas", 13, 1);

-- 3
UPDATE MOVIES SET genre_id = 13 WHERE id = 22;

-- 4
UPDATE ACTORS SET favorite_movie_id = 22 WHERE ID = 5;

-- 5
CREATE TEMPORARY TABLE copia_movies
SELECT * FROM movies;

-- 6
DELETE FROM copia_movies WHERE awards < 5;
-- NO ME FUNCIONA

-- 7
SELECT gen.* FROM GENRES gen
INNER JOIN MOVIES mo
ON mo.genre_id = gen.id
GROUP BY gen.id;

-- 8
SELECT act.* FROM ACTORS act
INNER JOIN MOVIES mo
ON act.favorite_movie_id = mo.id
WHERE mo.awards > 3;

-- 9 YA ESTA CREADO POR PARTE 1
-- 10
SHOW INDEX FROM MOVIES;

-- 11, sí porque un usuario sería bastante propenso a hacer búsquedas (tanto por igualdad como por like) sobre los nombres
-- de las películas.

-- 12, haría lo mismo para el nombre/apellido de actores y para el título de las series + episodios.
-- Si no están creados los actor_movie/actor_episode como FKs como PKs, podría hacer un índice sobre ellos para facilitar los joins.