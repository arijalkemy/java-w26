-- MOSTRAR TODOS LOS REGISTROS DE LA TABLA DE MOVIES

SELECT * FROM movies;

-- 

SELECT first_name , last_name , rating FROM actors;


-- 

SELECT title as titulo FROM series as seriesEspaniol;

-- 

SELECT first_name, last_name FROM actors WHERE rating > 7.5;

-- 

SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

-- 

SELECT title, rating FROM movies ORDER BY rating;

-- 

SELECT title FROM movies LIMIT 3;

-- 

SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5; 

-- 

SELECT first_name, last_name FROM actors LIMIT 10;

-- 

SELECT title, rating FROM movies WHERE title LIKE 'Toy Story%';

-- 

SELECT * FROM actors WHERE first_name LIKE 'Sam%';

-- 

SELECT title, release_date  FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-01-01';

-- 

SELECT title, awards , rating, release_date FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-01-01' ORDER BY rating;