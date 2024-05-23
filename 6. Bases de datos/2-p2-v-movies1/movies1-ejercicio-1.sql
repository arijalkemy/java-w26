-- Ejercicio 1

-- Creo tabla temporal
CREATE TEMPORARY TABLE TWD (
    id INT UNSIGNED,
    title VARCHAR(500),
    release_date DATE,
    genre INT UNSIGNED,
    duration INT UNSIGNED
);

-- Importo de movies (No hay registros)
INSERT INTO TWD (id, title, release_date, genre, duration)
SELECT id, title, release_date, genre_id, length
FROM movies
WHERE title LIKE '%The Walking Dead%';

SELECT * FROM TWD;

-- inserto registros validos The Walking Dead
INSERT INTO TWD (id, title, release_date, genre, duration)
VALUES
(1, 'The Walking Dead - Season 1, Episode 1', '2010-10-31', 1, 60),
(2, 'The Walking Dead - Season 1, Episode 2', '2010-11-07', 1, 60),
(3, 'The Walking Dead - Season 1, Episode 3', '2010-11-14', 1, 60),
(4, 'The Walking Dead - Season 1, Episode 4', '2010-11-21', 1, 60);

-- Busco datos
SELECT *
FROM TWD
WHERE title LIKE '%The Walking Dead%' AND YEAR(release_date) = 2010;

-- Elimino tabla temporal
DROP TEMPORARY TABLE IF EXISTS TWD;
