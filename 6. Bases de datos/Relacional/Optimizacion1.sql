CREATE TEMPORARY TABLE TWD (tituloEp varchar(40), numeroEp int, rating decimal(10, 0), season_id int);
INSERT INTO TWD 
SELECT ep.title, ep.number, ep.rating, ep.season_id FROM episodes ep
INNER JOIN series s
INNER JOIN seasons sea
ON ep.season_id = sea.id AND sea.serie_id = s.id AND s.title = "The Walking Dead";

SELECT * FROM TWD;

SELECT twd.* FROM TWD twd
INNER JOIN seasons sea
ON sea.id = twd.season_id AND sea.title = "Primer temporada";

-- 2
EXPLAIN SELECT title FROM movies;

-- Creo un índice en el título porque como dba siento que sería bastante frecuente hacer consultas de películas por título, 
-- incluso más que por id, al menos por parte del usuario.