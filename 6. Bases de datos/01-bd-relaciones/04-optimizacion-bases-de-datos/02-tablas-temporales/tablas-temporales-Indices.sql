CREATE TEMPORARY TABLE TWD(title VARCHAR(100), rating DECIMAL(3,1), release_date DATETIME, serie_title VARCHAR(100));

INSERT INTO TWD SELECT ep.title, rating, ep.release_date, sr.title FROM episodes ep
JOIN seasons sns ON ep.season_id = sns.id
JOIN series sr ON sns.serie_id = sr.id
WHERE sr.title = 'The Walking dead';

SELECT * FROM TWD;

SELECT * FROM TWD 
WHERE rating > 7.0 AND release_date 
BETWEEN '2010-01-01' AND '2013-12-12';

SELECT * FROM TWD 
WHERE LENGTH(title) > 14;

-- CREACIÓN DE INDICES --

-- Mejora del rendimiento de consultas
-- Cuando se realizan consultas que involucran la búsqueda por el nombre del actor,
-- un índice en esa columna puede mejorar significativamente el rendimiento de esas consultas.

CREATE INDEX actor_name_index ON actors(first_name);

EXPLAIN SELECT * FROM actors WHERE first_name = "Daniel";

-- Búsqueda rápida por título
-- En lugar de tener que buscar secuencialmente en toda la tabla de películas, la base de datos puede utilizar el índice para 
-- encontrar rápidamente las filas que coinciden con el título buscado.

CREATE INDEX title_name_index ON movies(title);

EXPLAIN SELECT * FROM movies WHERE title LIKE "Harry Potter%";