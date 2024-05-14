-- Ejercicio 1

-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD (nombreEpisidio varchar(500), temporada varchar(500));

INSERT INTO TWD 
SELECT e.title nombreEpisodio, s.title temporada FROM episodes e  
INNER JOIN seasons s ON e.season_id = s.id 
INNER JOIN series s2 ON s.serie_id = s2.id 
WHERE s2.title LIKE 'The Walking Dead';

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT nombreEpisidio FROM TWD
WHERE temporada LIKE 'Primer Temporada'

-- Ejercicio 2

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

CREATE INDEX series_title_id ON series(title);
SHOW INDEX FROM series

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

-- Creamos un indice para el campo title de la tabla series porque es probable que tengamos que realizar varias busquedas 
-- por el nombre de la serie en vez de por el id.