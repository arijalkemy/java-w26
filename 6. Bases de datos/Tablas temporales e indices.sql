DROP TABLE twd;

CREATE TEMPORARY TABLE twd (
	id INT,
    title VARCHAR(500),
    release_date DATETIME,
    rating DECIMAL(3,1),
    season VARCHAR(500)
    );
    
INSERT INTO twd (id, title, release_date, rating, season)
SELECT e.id, e.title, e.release_date, e.rating, s.title FROM episodes AS e 
INNER JOIN seasons AS s ON e.season_id = s.id
INNER JOIN series AS se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';
-- WHERE s.serie_id = (SELECT id FROM series WHERE title = 'The Walking Dead');

SELECT * FROM twd;

SELECT * FROM twd WHERE season = 'Primer Temporada';

/*
Se le agrega el indice al ser un campo que posiblemente no van a ser actualizado y no afecta una re indexación y así como también
es un campo de recurrente busqueda o que puede ser usado en funciones de agregación.
*/
CREATE INDEX title_idx 
ON movies (title);

SHOW INDEX FROM movies;
