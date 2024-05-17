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

-- Ejercicio 2
-- 2.1 En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX titleIdx ON movies(title);
CREATE INDEX titleIdx ON series(title);
SHOW INDEX FROM movies;
SHOW INDEX FROM series;

-- 2.2 Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Normalmente las busquedas en contenido multimedia y solbretodo en series y peliculas se realiza por su nombre 
-- ya que el usuario desconoce el id, entonces por esto se usaron los indices en los titulos de las peliculas y series