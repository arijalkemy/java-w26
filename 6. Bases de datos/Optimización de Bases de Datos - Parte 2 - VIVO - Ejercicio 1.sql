-- 1.1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE IF NOT EXISTS TWD AS (
	SELECT EPI.* FROM episodes epi 
	JOIN seasons sea ON epi.season_id = sea.id
	JOIN series ser ON sea.serie_id = ser.id
	WHERE ser.title = 'The Walking Dead'
);

-- 1.2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE id = (
	SELECT sea.id FROM seasons sea 
	JOIN series ser ON sea.serie_id = ser.id 
	WHERE ser.title = 'The Walking Dead'
	ORDER BY sea.release_date LIMIT 1
);

-- 2.1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
SHOW INDEX FROM actors;
ALTER TABLE actors ADD INDEX full_name_idx(first_name, last_name);
SHOW INDEX FROM actors;

-- 2.2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
/*
* Crearía un indice en la tabla actors en los campos first_name y last_name ya que la única información que identifica a los actores que es conocida por el usuario
* es el nombre completo del actor. Por lo tanto, las búsquedas frecuentes que se harían sobre esta tabla seguramente serían sobre el nombre completo de los actores.
*/