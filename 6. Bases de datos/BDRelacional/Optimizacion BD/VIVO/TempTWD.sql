-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
-- guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (created_at TIMESTAMP, update_at TIMESTAMP, title varchar(500), release_date DATETIME, rating decimal(3,1), serie_id INT, season_id int);
INSERT INTO TWD SELECT e.created_at, e.updated_at, e.title, e.release_date, e.rating, se.id, s.id
	FROM episodes e JOIN seasons s ON (e.season_id=s.id) JOIN series se ON (s.serie_id=se.id)
    WHERE se.title="The Walking Dead";
SELECT * FROM TWD;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT t.title FROM TWD t JOIN seasons s ON (t.season_id=s.id)
WHERE s.title LIKE "PRIMER%";

