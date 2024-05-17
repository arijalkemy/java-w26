-- EJERCICIO 1:  Creación de Tablas Temporales e Índices
DROP TABLE TWD;
CREATE TEMPORARY TABLE TWD (
  `id` int unsigned NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `number` int unsigned DEFAULT NULL,
  `release_date` datetime NOT NULL,
  `rating` decimal(3,1) NOT NULL,
  `season_id` int unsigned DEFAULT NULL,
   `season_number` int unsigned DEFAULT NULL
); 

INSERT INTO TWD SELECT ep.id, ep.title, ep.number, ep.release_date, ep.rating, ep.season_id, sns.number as season_number
FROM episodes ep
JOIN seasons sns ON ep.season_id = sns.id
JOIN series sr ON sns.serie_id = sr.id
WHERE sr.title = 'The Walking Dead';

select * from TWD WHERE season_number = 2;
select * from TWD WHERE rating > 2;


--  EJERCICIO 2:  Consultas SQL Avanzadas 2
-- 2.)
-- ALTER TABLE `movies_db`.`movies` 
-- ADD INDEX `title_index` (`title` ASC) VISIBLE;
-- ;

-- consultas Error Code: 1136. Column count doesn't match value count at row 1

-- 1.)
INSERT INTO movies (id, title, rating, awards, release_date, length)  VALUES(23, "SOME", 3.00, 1, '2024-02-02', 180); 
-- 2.)
INSERT INTO genres (id, name, ranking, active) VALUES (777, "terro gótico jsjs", 888, 1);
-- 3.) 
UPDATE movies SET genre_id = 777 WHERE movies.id = 23;
-- 4.)
UPDATE actors SET favorite_movie_id = 23 WHERE actors.id= 1;
-- 5.)
CREATE TEMPORARY TABLE COPY_MOVIES (SELECT * from movies);
-- 6.)
DELETE FROM COPY_MOVIES WHERE awards > 3;
-- 7.)
SELECT DISTINCT g.name
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id;
-- 8.)
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- 9.)
CREATE INDEX idx_movies_title ON movies(title);

-- 10.)
SHOW INDEX FROM movies;

-- 11.)
  -- Sí, crear índices en movies mejora el rendimiento de las consultas, especialmente si hay consultas frecuentes que filtran o buscan películas por título.
  
-- 12.)

 -- Crearía un indice en la tabla actors en la columna rating, ya que podría haber consultas frecuentes que ordenen o filtren actores por su calificación





