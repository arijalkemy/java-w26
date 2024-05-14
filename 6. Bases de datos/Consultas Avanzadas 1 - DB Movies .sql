#Mostrar el titulo y el nombre del genero de todas las series
SELECT s.title, g.name FROM series s
INNER JOIN genres g ON s.genre_id = g.id;

#Mostrar titulo episodios, nombre, apellido de los actores que trabajan en ellos
SELECT e.title, a.first_name, a.last_name from episodes e 
INNER JOIN actor_episode ae ON e.id = ae.id 
INNER JOIN actors a ON ae.id = a.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(*) as Temporadas from series s 
INNER JOIN seasons sea ON s.id = sea.serie_id 
GROUP BY s.title;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) as Cantidad_Peliculas from genres g 
INNER JOIN movies m ON g.id = m.genre_id 
GROUP BY g.name HAVING Cantidad_Peliculas >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name from actors a 
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies mo ON am.movie_id = mo.id
WHERE mo.title LIKE '%guerra de las galaxias%';