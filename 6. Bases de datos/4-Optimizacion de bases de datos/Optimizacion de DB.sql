
-- Consultas SQL Avanzadas

/* 
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma 
los episodios de todas las temporadas de “The Walking Dead”. 
*/

CREATE TEMPORARY TABLE twd (title varchar(500), seasonsTitle varchar(500), number int unsigned, rating decimal(3,1));

INSERT INTO twd SELECT episodes.title, seasons.title, episodes.number, episodes.rating FROM episodes
INNER JOIN seasons ON seasons.id = episodes.season_id
INNER JOIN series ON series.id = seasons.serie_id
WHERE series.title LIKE 'The Walking Dead';

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT * FROM twd
WHERE seasonsTitle = 'Primer Temporada';


-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

ALTER TABLE `movies_db`.`seasons` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;

EXPLAIN SELECT title FROM seasons
WHERE title = 'Primer Temporada';

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

/*
Se decidio indexar la columna title de la tabla seasons porque se estaba realizando muchas consultas sobre la misma.
y al ver que cada consulta ocupaba 46 iteraciones, klogramos una mejora de 40 iteraciones menos cada vez 
que se realiza esa consulta.
*/
