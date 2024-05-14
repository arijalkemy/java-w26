# Creación de Tablas Temporales e Índices
# Ejercicio 1
# 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
# y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD (
    episode_number INT,
    season_number INT,
    title VARCHAR(255),
    air_date DATE
);

# 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

INSERT INTO TWD (episode_number, season_number, title, air_date)
VALUES
    (1, 1, 'Days Gone Bye', '2010-10-31'),
    (2, 1, 'Guts', '2010-11-07'),
    (6, 1, 'TS-19', '2010-12-05');
    
SELECT episode_number, title
FROM TWD
WHERE season_number = 1;

