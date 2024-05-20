/*
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
*/

CREATE TEMPORARY TABLE TWD(
	episode_number INT NOT NULL,
    episode_title VARCHAR(50),
    episode_season INT NOT NULL
);

INSERT INTO TWD(
	episode_number,
    episode_title,
    episode_season
)
SELECT e.number,
	   e.title,
       sea.number
FROM
	series ser
INNER JOIN 
	seasons sea
    ON
		sea.serie_id = ser.id
INNER JOIN 
	episodes e
    ON
		e.season_id = sea.id
WHERE 
	ser.title = 'The Walking Dead';

SELECT
	*
FROM
	TWD;

/*
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/

SELECT
	*
FROM
	TWD
WHERE
	episode_season = 1;