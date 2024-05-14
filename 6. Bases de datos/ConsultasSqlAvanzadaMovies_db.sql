#Mostrar el título y el nombre del género de todas las series.
SELECT S.TITLE, G.NAME 
	FROM SERIES AS S
INNER JOIN GENRES AS G ON S.genre_id = G.id ;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT E.TITLE,A.first_name, A.last_name  
	FROM actor_episode AS AE 
INNER JOIN actors AS  A ON AE.actor_id = A.id INNER JOIN episodes AS E ON AE.episode_id = E.id ;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT SER.title,COUNT(*) AS TEMPORADAS  
	FROM seasons AS SEA
INNER JOIN SERIES AS SER ON SEA.serie_id  = SER.id 
GROUP BY SER.title ;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
#siempre que sea mayor o igual a 3.

SELECT G.name, COUNT(*) AS TOTAL_PELICULAS  
	FROM MOVIES AS M 
INNER JOIN genres AS G ON M.genre_id = G.id 
GROUP BY G.name 
HAVING TOTAL_PELICULAS>=3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias
# y que estos no se repitan.


SELECT A.first_name, A.last_name, COUNT(*) AS REPETIDOS  
	FROM actor_episode AS AE 
INNER JOIN actors AS  A ON AE.actor_id = A.id INNER JOIN movies AS M ON AE.episode_id = M.id
WHERE M.title like 'La Guerra de las galaxias:%'
GROUP BY A.first_name ,A.last_name 
HAVING REPETIDOS = 1;

SELECT * FROM MOVIES;