-- EJERCICIO 1

-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
use movies_db; 

create temporary table twd (
	titulo varchar(100) not null
);

INSERT INTO twd (titulo)
SELECT episodes.title
FROM episodes
INNER JOIN seasons ON episodes.season_id = seasons.id
INNER JOIN series ON series.id = seasons.serie_id
WHERE series.title = "The Walking Dead";


-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * from twd;

-- EJERCICIO 2

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
CREATE INDEX idx_title ON movies (title);

-- EXPLICACION 
-- Creamos un índice en la columna `title` de la tabla `movies`.
-- Esto se hace porque es más común buscar películas por su título, ya que los usuarios suelen recordar el nombre de la película que desean encontrar.
-- Al crear un índice en esta columna, mejoramos el rendimiento de las consultas que involucran búsquedas o filtros por el título de la película.
