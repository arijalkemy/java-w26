-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

CREATE TEMPORARY TABLE TWD(
	SELECT e.title AS Episodio, a.title AS Temporada FROM series s
	JOIN seasons a ON s.id = a.serie_id
	JOIN episodes e ON a.id = e.season_id
    WHERE s.title LIKE 'The Walking Dead'
);

SELECT * FROM TWD 
	WHERE Temporada LIKE 'Primer Temporada';
