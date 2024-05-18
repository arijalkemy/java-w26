#Ejercicio 1
-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
SELECT ep.*, sn.number AS temp
FROM series se
INNER JOIN seasons sn
ON se.id = sn.serie_id
INNER JOIN episodes ep
ON ep.season_id = sn.id
WHERE se.title = 'The Walking Dead';

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE temp = 1;

#Ejercicio 2 
# 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo
CREATE INDEX title_idx 
ON movies (title);

CREATE INDEX awards_idx 
ON movies (awards);

SHOW INDEX FROM movies;

/* 2. INDICES:
actors: 
	-first_name
movies:
	-title
    -awards
series:
	-title
Se le agregan los indices al ser campos que posiblemente no van a ser actualizados y no afecten una re indexación y así como también
son campos de recurrente busqueda o que puedan ser usados en funciones de agregación.
*/


