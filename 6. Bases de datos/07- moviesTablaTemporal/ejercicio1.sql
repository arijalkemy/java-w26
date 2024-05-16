-- Ejercicio 1

USE movies_db;
-- Crear la tabla temporal con los episodios de The walking dead
CREATE TEMPORARY TABLE TWD
SELECT s.title AS "TITULO_SERIE", se.title AS "TEMPORADA", e.title AS "NOMBRE_CAP"
FROM series s
JOIN seasons se ON s.id = se.serie_id
JOIN episodes e ON e.season_id = se.id
WHERE s.title LIKE "The Walking Dead";

-- Buscar los episodios de la primera temporada
SELECT *
FROM TWD
WHERE TEMPORADA LIKE "Primer Temporada"; 

-- Creador de indices
ALTER TABLE actors
ADD INDEX busqueda_apellido_actor (last_name);
