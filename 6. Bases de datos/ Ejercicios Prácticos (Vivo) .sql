-- Asegurando que se utilice la DB apropiada
USE movies_db;
-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies;
-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name,last_name, rating FROM actors;
-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title as Titulo FROM series as Series;
-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name,last_name, rating FROM actors WHERE rating > 7.5;
-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title,rating,awards FROM movies WHERE rating > 7.5 AND awards > 2;
-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM MOVIES ORDER BY rating ASC;
-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies LIMIT 3;
-- Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM MOVIES ORDER BY RATING DESC LIMIT 5;
-- Listar los primeros 10 actores.
SELECT * FROM actors LIMIT 10;
-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title,rating FROM MOVIES WHERE title like "%TOY STORY%";
-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM ACTORS WHERE first_name like "%SAM";
-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT * FROM MOVIES WHERE release_date >='2004-01-01' AND release_date<='2008-12-31';
