# Consultas SQL Avanzadas - Parte 1

## Primera parte
-- 1. ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?

   /* Es una sentencia para obtener datos de distintas tablas
      que estan realcionadas entre si combinando los datos de
      estas tablas
	*/

-- 2. Explicar dos tipos de JOIN.
	/*
    Full Outer Join es utilizado para obtener todos los datos de ambas tablas
    sin importar si coinciden o no.
    Right Join, trae los datos de la tabla de la derecha adicionando
    los datos que coinciden con la tabla izquierda
    */

-- 3. ¿Para qué se utiliza el GROUP BY?
	/*
    Se utiliza para agrupar los resultados de una consulta, esto
    especificando la/s columna/s de referencia sobre las que se
    realiza la agrupacion.
    */

-- 4. ¿Para qué se utiliza el HAVING?
	/*
    Se utiliza para realizar un filtro sobre una agrupacion
    Es utilizado junto al GROUP BY y funciona como el WHERE
    */

-- 5. Escribir una consulta genérica para cada uno de los siguientes diagramas:
	/*
    -- Left Join
    SELECT mo.*
	FROM movies mo LEFT JOIN actors ac
	ON mo.id = ac.favorite_movie_id;

	-- Inner Join
	SELECT COUNT(*), mo.title, mo.rating, mo.awards
	FROM movies mo INNER JOIN actors ac
	ON mo.id = ac.favorite_movie_id
	GROUP BY mo.id;
    */

USE movies_db;

## Segunda parte
-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s
JOIN genres g ON s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de
-- los actores que trabajan en cada uno de ellos.
SELECT ep.title, ac.first_name, ac.last_name
FROM actors ac
JOIN actor_episode aep ON aep.actor_id = ac.id
JOIN episodes ep ON aep.episode_id = ep.id;

-- 3. Mostrar el título de todas las series y el total de
-- temporadas que tiene cada una de ellas.
SELECT ser.title, COUNT(sea.id) total_temp
FROM series ser
JOIN seasons sea ON sea.serie_id = ser.id
GROUP BY ser.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de
-- películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.id) movies_count
FROM genres g
JOIN movies m ON m.genre_id = g.id
GROUP BY g.name;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan
-- en todas las películas de la guerra de las galaxias y que estos
-- no se repitan.
SELECT
    CONCAT(a.first_name, ' ', a.last_name) full_name
FROM
    actors a
        JOIN
    actor_movie am ON am.actor_id = a.id
        JOIN
    movies m ON am.movie_id = m.id
WHERE
    m.title LIKE '%galaxias%'
GROUP BY full_name
;
