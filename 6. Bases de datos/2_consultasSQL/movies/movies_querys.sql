USE movies_db;

# 1 Mostrar todos los registros de la tabla de movies.
SELECT * FROM MOVIES;

# 2 Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM actors;

# 3 Mostrar el título de todas las series y
# usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title as titulo FROM series;

# 4 Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

# 5 Mostrar el título de las películas, el rating y
# los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM MOVIES WHERE rating > 7.5 AND awards > 2;

# 6 Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM MOVIES ORDER BY rating ASC;

# 7 Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM MOVIES LIMIT 3;

# 8 Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM MOVIES ORDER BY rating DESC LIMIT 5;

# 9 Listar los primeros 10 actores.
SELECT * FROM actors LIMIT 10;

# 10 Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating FROM movies WHERE title = "Toy Story";

# 11 Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM actors WHERE first_name LIKE "SAM%";

# 12 Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title FROM movies WHERE release_date BETWEEN "2004-01-01" AND "2008-12-31";

# 13 Traer el título de las películas con el rating mayor a 3, con más de 1 premio y
# con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title FROM movies
WHERE rating > 3
AND awards > 1
AND release_date BETWEEN "1988-01-01" AND "2009-12-31"
ORDER BY rating DESC;