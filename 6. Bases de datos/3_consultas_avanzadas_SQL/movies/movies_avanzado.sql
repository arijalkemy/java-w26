# 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name  FROM series s
INNER JOIN genres g ON g.id = s.id;

# 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM episodes e
INNER JOIN actor_episode ae
INNER JOIN actors a;

# 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, count(*) FROM series s
INNER JOIN seasons s2 ON s2.serie_id = s.id
GROUP BY s2.serie_id;

# 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) as total_movies FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING total_movies >= 3;

# 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas
# las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%';