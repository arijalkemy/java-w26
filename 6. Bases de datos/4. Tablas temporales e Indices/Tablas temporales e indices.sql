USE movies_db;

-- EJERCICIO 1 TABLAS TEMPORALES
-- Crear la tabla temporal con los episodios de The walking dead

CREATE TEMPORARY TABLE TWD (
select e.title AS titulo_episodio, s.title AS titulo_temporada from episodes e 
join seasons s on e.season_id = s.id
join series se on s.serie_id = se.id
where se.title like 'The Walking Dead');


-- Buscar los episodios de la primera temporada
SELECT * FROM TWD;

SELECT *
FROM TWD
WHERE TEMPORADA LIKE "Primer Temporada"; 

-- EJERCICIO 2 INDICE
CREATE INDEX index_genero ON movies (genre_id); 

-- creamos index ya que en la tablas de peliculas se consulta mucho el genero.