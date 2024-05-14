-- Use the db for movies
USE movies_db;

-- Queries for movies with temporary tables and index

-- Ejercicio 1 --
/* Con la base de datos “movies”, se propone crear una
tabla temporal llamada “TWD” y guardar en la misma los
episodios de todas las temporadas de “The Walking Dead”. */
CREATE TEMPORARY TABLE twd AS
SELECT s.*, ep.number as ep_num
FROM seasons s
JOIN series se ON se.id = s.serie_id
JOIN episodes ep ON s.id = ep.season_id
WHERE se.title = 'The Walking Dead';
-- DROP TEMPORARY TABLE twd;
/* Realizar una consulta a la tabla temporal para ver
los episodios de la primera temporada.*/
SELECT
    *
FROM
    twd t
WHERE
	t.number = 1;

-- Ejercicio 2 --
/* En la base de datos “movies”, seleccionar una tabla
donde crear un índice y luego chequear la creación del
mismo. */
CREATE INDEX idx_release_date ON series(release_date);
SHOW INDEX FROM series;

/* Analizar por qué crearía un índice en la tabla
indicada y con qué criterio se elige/n el/los campos. */
-- A menudo las consultas se pueden hacer por fechas
-- en casos como cuando no se conoce el nombre de la
-- serie o pelicula.
