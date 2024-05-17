/*
Mostrar el título y el nombre del género de todas las series.*/
SELECT s.title, g.name
FROM series s INNER JOIN genres g ON s.genre_id=g.id;
/*
Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
SELECT e.title, a.first_name,a.last_name
FROM episodes e INNER JOIN actor_episode ae ON e.id=ae.episode_id INNER JOIN actors a ON ae.actor_id=a.id;
/*
Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
*/
SELECT s.title, count(*) seasons
FROM series s INNER JOIN seasons sea ON sea.serie_id=s.id
GROUP BY sea.serie_id;
/*
Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
SELECT g.name, count(*) quantity_movies
FROM genres g INNER JOIN movies m ON m.genre_id=g.id
GROUP BY m.genre_id
HAVING quantity_movies>= 3;

/*
Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
*/
SELECT DISTINCT a.first_name,a.last_name
FROM actors a INNER JOIN actor_movie am ON a.id=am.actor_id INNER JOIN movies m 
On am.movie_id=m.id
