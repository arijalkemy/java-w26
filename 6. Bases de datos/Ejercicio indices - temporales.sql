USE movies_db;

-- Ejercicio 1

-- 1.1 Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma 
-- los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
	episodeId INTEGER, 
    episodieTitle VARCHAR(500), 
    episodieRating INTEGER,
    episodieNumber INTEGER, 
    seasonNumber INTEGER, 
    seasonTitle VARCHAR(500)
);

INSERT INTO TWD SELECT e.id, e.title, e.rating, e.number, s.number, s.title
FROM episodes e INNER JOIN seasons s ON e.season_id = s.id
				INNER JOIN series se ON se.id= s.serie_id
WHERE se.title = 'The Walking Dead';

-- 1.2 Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * 
FROM TWD
WHERE seasonNumber=1;

-- 1.3 Se propuso una consulta para listar los episodeos con un rating mayor a 5
SELECT episodeId,
    episodieTitle, 
    episodieRating ,
    episodieNumber , 
    seasonNumber , 
    seasonTitle
FROM TWD
WHERE episodieRating>5;
