/*
	Práctica Consultas a Bases de Datos
    Ejercicio Integrador - Andrés Felipe Lugo Rodríguez
*/

-- 1. Mostrar todos los registros de la tabla movies
SELECT * 
FROM movies;

-- 2. Mostrar el nombre, apellido y rating de todos los actores
SELECT first_name, last_name, rating 
FROM actors;

-- 3. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español
SELECT title AS 'Título'
FROM series;

-- 4. Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name, rating 
FROM actors
WHERE rating > 5;

-- 5. Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title AS 'Título', rating AS 'Calificación', awards AS 'Premios'
FROM movies
WHERE rating > 7.5 AND awards > 2;

-- 6. Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente
SELECT title AS 'Título', rating AS 'Calificación', awards AS 'Premios'
FROM movies
ORDER BY rating ASC;

-- 7. Mostrar el top 5 de las películas con mayor rating.
SELECT title AS 'Título', rating AS 'Calificación', awards AS 'Premios'
FROM movies
ORDER BY rating DESC
LIMIT 5;

-- 8. Listar los primeros 10 actores.
SELECT first_name, last_name, rating 
FROM actors
ORDER BY rating DESC
LIMIT 10;

-- 9. Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title AS 'Título', rating AS 'Calificación'
FROM movies
WHERE title LIKE 'Toy Story%';

-- 10. Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT first_name, last_name, rating
FROM actors
WHERE first_name LIKE 'Sam%';

-- 11. Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT * FROM movies;
SELECT title AS 'Título'
FROM movies
WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';

-- 12. Traer el título de las películas con el rating mayor a 3, con más 
-- de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title AS 'Título', rating AS 'Calificación', awards AS 'Premios'
FROM movies
WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating DESC;  



