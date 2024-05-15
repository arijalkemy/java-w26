/*Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y  
 *guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.*/

CREATE TEMPORARY TABLE TWD(
  `id_episode` int,
  `title_episode` varchar(500),
  `number_episode` int,
  `id_season` int,
  `number_season` int
  );

INSERT INTO TWD(
	SELECT e.id, e.title, e.number, s.id, s.number
	FROM episodes e  
	INNER JOIN seasons s ON e.season_id = s.id
	INNER JOIN series se ON se.id = s.serie_id 
			AND se.title LIKE "The Walking Dead")
		
DROP TABLE TWD;


/*Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.*/

SELECT * 
FROM TWD 
where number_season = 1;


/*En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.*/

ALTER TABLE seasons 
ADD INDEX idx_number (number);

SHOW INDEX FROM seasons


/* Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.*/

/*Creamos el indice en la tabla indicada porque analizamos que constantemente se 
 * filtra por el numero de temporada para encontrar los episodios y demás, ademas
 * es una tabla que no se actualiza constantemente*/
