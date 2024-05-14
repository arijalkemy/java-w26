CREATE TEMPORARY TABLE TWD 
(
	id integer primary key,
	title varchar(40),
	release_date datetime
)


SELECT e.id,e.title,e.release_date  
FROM episodes e 
INNER JOIN seasons sea on sea.id = e.season_id 
INNER JOIN series s on s.id = sea.serie_id 
WHERE s.title like 'The Walking Dead';

INSERT INTO TWD (id, title, release_date)
SELECT e.id, e.title, e.release_date  
FROM episodes e 
INNER JOIN seasons sea ON sea.id = e.season_id 
INNER JOIN series s ON s.id = sea.serie_id 
WHERE s.title LIKE 'The Walking Dead';


SELECT * FROM TWD;


#OBTENGO LOS EPISIDIOS QUE SALIERON MAYORES AL 2011



SELECT * FROM TWD WHERE RELEASE_DATE > '2011-01-01';
SELECT * FROM MOVIES WHERE RATING > 8 ;
# CONSULTO Y VEO EL PLAN DE EJECUCION DE MOVIES
EXPLAIN SELECT * FROM movies WHERE RATING > 8 ;


# CREO UN INDICE EN LA COLUMNA RATING DE LA TABLA MOVIES

CREATE INDEX idx_rating ON movies (rating);

# CONSULTO Y VEO EL PLAN DE EJECUCION DE MOVIES
EXPLAIN SELECT * FROM movies WHERE RATING > 8 ;

# ES UNA COLUMNA QUE SE PUEDE UTILIZAR VARIAS VECES PARA OBTENER DISTINTOS TIPOS DE METRICAS



#-------- EJERCICIO 2 -----------

#Agregar una película a la tabla movies.
INSERT INTO movies
(created_at, updated_at, title, rating, awards, release_date, length)
VALUES(CURRENT_DATE ,null,'new movie', 5.4, 4, CURRENT_DATE, 120);
# Agregar un género a la tabla genres.
INSERT INTO genres
( created_at, updated_at, name, ranking, active)
VALUES (CURRENT_DATE, null, 'new gender', 13, 1);
#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22 ;

SELECT * FROM movies m ;

SELECT * FROM genres g ;

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

SELECT * FROM actors a ;

UPDATE actors SET favorite_movie_id = 22 WHERE ID =3;
# Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE MOVIES_COPY
(
	id integer primary key,
	created_at TIMESTAMP,
	updated_at TIMESTAMP,
	title varchar(500),
	rating DECIMAL(3,1),
	awards INTEGER,
	release_date datetime,
	length INTEGER,
	GENRE_ID INTEGER
	
);
INSERT INTO MOVIES_COPY SELECT * FROM movies;
SELECT * FROM MOVIES_COPY;


# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.




