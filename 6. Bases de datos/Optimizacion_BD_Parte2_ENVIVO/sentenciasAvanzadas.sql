-- Primer punto

CREATE TEMPORARY TABLE TWD (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
    titulo varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
    numero int(10) unsigned DEFAULT NULL,
    fecha_de_realizacion datetime NOT NULL,
    rating decimal(3, 1) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO TWD
SELECT e.id, e.title, e.number, e.release_date, e.season_id
FROM episodes e 
	INNER JOIN seasons s ON e.season_id = s.id
	INNER JOIN series se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

SELECT * FROM TWD;

SELECT * 
FROM TWD 
WHERE rating > 20;

-- Segundo punto

CREATE INDEX idx_serie_movie ON series(title);

SHOW INDEX FROM series;

-- Tercer punto

INSERT INTO movies (id, title, rating, awards, release_date, length)
VALUES (22, 'Bastardos sin Gloria', 8.3, 4, '2009-09-21', 150);

INSERT INTO genres (id, name, ranking, active)
VALUES (13, 'Ucronía', 13, 1);

UPDATE movies
SET genre_id = 13
WHERE id = 22;

UPDATE actors
SET favorite_movie_id = 22
WHERE id = 4;

CREATE TEMPORARY TABLE moviesTemp(
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rating` decimal(3,1) unsigned NOT NULL,
  `awards` int(10) unsigned NOT NULL DEFAULT '0',
  `release_date` datetime NOT NULL,
  `length` int(10) unsigned DEFAULT NULL,
  `genre_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
); 

INSERT INTO moviesTemp 
SELECT * FROM movies;

SELECT * FROM moviesTemp;

DELETE FROM moviesTemp 
WHERE awards < 5;

SELECT DISTINCT ge.id, ge.name, ge.ranking
FROM genres ge INNER JOIN movies mo ON mo.genre_id = ge.id;

SELECT ac.id, ac.first_name, ac.last_name
FROM actors ac INNER JOIN movies mo ON ac.favorite_movie_id = mo.id
WHERE mo.awards > 3;

CREATE INDEX idx_title_name ON movies(title);

SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- Considerando que podría darse la búsqueda constante de películas por medio de su nombre y que no es una tabla que cambie mucho, si consideramos que si sería conveniente agregarle un indice a dicha columna ya que como se puede observar en las imagenes la búsqueda paso de recorrer 22 filas a una sola y esto pensando que más adelante podrían haber insertadas más de mil peliculas o más.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- Con base en el mismo criterio que mencionamos antes, haríamos lo mismo con las series, de indexar su nombre además de indexar por nombre a los actores pensando que muchos de los filtros se darían por medio de esto.