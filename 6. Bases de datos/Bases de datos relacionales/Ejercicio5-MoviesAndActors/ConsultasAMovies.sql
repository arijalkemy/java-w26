-- Agregar una película a la tabla movies.

INSERT INTO movies(title, rating, awards, length, genre_id, release_date) values 
("Tarzan", 7.4, 3.0, 90, 2, '20240101');

-- Agregar un género a la tabla genres.

INSERT INTO movies_db.genres(created_at, name, ranking, active)
VALUES( '20240101',  'Stream', 15, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies 
SET genre_id  = (SELECT g.id
				FROM genres g
				WHERE g.name = "Stream") 
WHERE id = 2;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors 
SET favorite_movie_id = 22 
WHERE favorite_movie_id = 2;

-- Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_temp (
 `id` int,
  `created_at` timestamp,
  `updated_at` timestamp,
  `title` varchar(500),
  `rating` decimal(3,1),
  `awards` int,
  `release_date` datetime,
  `length` int,
  `genre_id` int
);

INSERT INTO movies_temp(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id 
FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM movies_temp
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.

SELECT g.id, g.name, g.ranking, COUNT(*) AS "Cantidad de peliculas"  
FROM genres g INNER JOIN movies m 
		ON g.id = m.genre_id 
GROUP BY g.id 
HAVING COUNT(*) > 0;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.first_name, a.last_name, m.title AS "Pelicula favorita", m.awards AS "Cantidad de titulos"
FROM actors a INNER JOIN movies m 
		ON a.favorite_movie_id = m.id 
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.

ALTER TABLE movies 
ADD INDEX idx_nombre(title);

-- Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

/*EN LA BASE DE DATOS MOVIES SE PODRIAN CREAR INDICES DE LOS NOMBRES DE LAS PELICULAS Y LA CANTIDAD DE PREMIOS DADO QUE SON 
 * DATOS MUY SOLICITADOS EN LAS CONSULTAS REALIZADAS ANTERIORMENTE... EL HECHO DE CREARLOS HARIA QUE SEA MUCHO MENOR EL TIEMPO
 * DE RESPUESTA Y MAS EFICIENTE LA CONSULTA EN LA DB*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

/* SE PODIAN AGREGAR EN MUCHAS, PERO RESUMIENDO, AGREGARIA UNO EN SEASON EN EL NUMBER, UNO EN SERIE EN EL
 * TITLE DE LA MISMA, EN EL FIRST Y LAST_NAME DE LOS ACTORS... Y NO MUCHO MAS QUE ESO, CON EL FIN DE QUE LAS
 * CONSULTAS SEAN LO MAS EFICIENTE POSIBLES. 
 * ADEMAS NO AGREGARIA TANTOS DADO QUE EL HECHO DE UTILIZAR INDICES AFECTA AL RENDIMIENTO DE LOS PROCESOS
 * DE ALTA, BAJA Y MODIFICACION... POR ESO DEBERIAMOS SER MUY PRUDENTES A LA HORA DE TOMAR ESTA DECISION */
