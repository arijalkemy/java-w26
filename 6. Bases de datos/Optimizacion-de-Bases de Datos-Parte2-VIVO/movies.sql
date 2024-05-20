use movies_db;


# Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y
# guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD
SELECT E.*, S2.TITLE AS temporada
FROM SERIES S
JOIN SEASONS S2 on S.ID = S2.SERIE_ID
JOIN EPISODES E ON S2.ID = E.SEASON_ID
WHERE S.TITLE LIKE 'The Walking Dead%';
 
#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT * 
FROM TWD
WHERE TEMPORADA LIKE 'Primer Temporada'

# En la base de datos “movies”, seleccionar una tabla donde crear un índice 
# y luego chequear la creación del mismo.

## nombre, apellido de los actores y aparaciones
## de los actores que aparecen en the walking dead
## mas de 4 veces

SELECT DISTINCT 
    A.FIRST_NAME,
    A.LAST_NAME,
    COUNT(A.ID) AS APARICIONES
FROM TWD T 
JOIN ACTOR_EPISODE AT ON T.ID= AT.EPISODE_ID
INNER JOIN ACTORS A ON AT.ACTOR_ID = A.ID
GROUP BY A.ID
HAVING APARICIONES > 4;

## el titulo tiene mucha concurrencia
CREATE INDEX MOVIES_IDX ON MOVIES(TITLE);
SHOW INDEX FROM MOVIES;


## Agregar una película a la tabla movies.

INSERT INTO MOVIES
(CREATED_AT, UPDATED_AT, TITLE, RATING, AWARDS, RELEASE_DATE, `LENGTH`)
VALUES(CURRENT_DATE, NULL, 'Codigo Enigma',5.4, 4,'2023-04-04', 120);

## Agregar un género a la tabla genres.

INSERT INTO GENRES
(CREATED_AT, UPDATED_AT, NAME, RANKING, ACTIVE)
VALUES(CURRENT_DATE, NULL, 'Epoca', (SELECT MAX(G.RANKING) + 1 FROM GENRES G),1);

## Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE MOVIES 
SET GENRE_ID = (SELECT MAX(G.ID) FROM GENRES G)
WHERE ID = 22;

## Modificar la tabla actors para que al menos un actor tenga como favorita 
## la película agregada en el punto 1.

UPDATE ACTORS A
SET A.FAVORITE_MOVIE_ID = (SELECT M.ID FROM MOVIES M WHERE M.TITLE = 'Codigo Enigma')
WHERE A.ID = 49;

## Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE MOVIES_COPY
SELECT * FROM MOVIES;

SELECT * FROM MOVIES_COPY;

## Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM MOVIES 
WHERE AWARDS < 5;

# Obtener la lista de todos los géneros que tengan al menos una película.

SELECT DISTINCT GENRES.* FROM GENRES 
INNER JOIN MOVIES M ON GENRES.ID = M.GENRE_ID;

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT DISTINCT A.* 
FROM ACTORS A
INNER JOIN MOVIES M ON A.FAVORITE_MOVIE_ID = M.ID
WHERE AWARDS >3;

# Crear un índice sobre el nombre en la tabla movies.

DROP INDEX MOVIES_IDX ON MOVIES;
CREATE INDEX MOVIES_IDX ON MOVIES(TITLE);

SHOW INDEX FROM MOVIES;

explain select * from movies where movies.title like 'Codigo Enigma';

drop index movies_idx on movies;

explain select * from movies where movies.title like 'Codigo Enigma';

#11
# si existe porque filtra por menos filas, se podria valorar crear
# un indice por rating

##12
## crearia en la tabla series por el titulo tambien



