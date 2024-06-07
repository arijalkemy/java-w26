-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD SELECT *
FROM episodes
WHERE season_id IN (
    SELECT id
    FROM seasons
    WHERE serie_id = (
        SELECT id
        FROM series
        WHERE title = "The Walking Dead"
    )
);

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT * FROM TWD WHERE season_id =
(SELECT season_id FROM seasons WHERE number=1 AND serie_id=(SELECT id FROM series WHERE title="The Walking Dead"));

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

CREATE INDEX title_index ON series(title);

SHOW INDEX FROM series;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
/*
	El index creado se creo sobre la tabla de series en el campo del titulo
    y la razon por la que el campo fue elegido es porque el nombre de una serie
    es un dato muy representativo de primer nivel por lo que se supone se realizara una gran
    cantidad de solicitudes a la base de datos intentando buscar series por medio de su nombre
    de una manera frecuente.
*/
