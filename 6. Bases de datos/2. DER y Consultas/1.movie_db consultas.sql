-- 1
SELECT * FROM movies;

-- 2
SELECT first_name, last_name, rating from actors;

-- 3
SELECT title as Título FROM SERIES;

-- 4
SELECT first_name, last_name FROM actors
WHERE RATING > 7.5;

-- 5
SELECT title, rating, awards FROM movies
WHERE rating > 7.5 AND awards > 2;

-- 6
SELECT title, rating FROM movies
ORDER BY rating;

-- 7
SELECT title FROM movies
LIMIT 3;

-- 8
SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5;

-- 9
SELECT * FROM actors
LIMIT 10;

-- 10
SELECT title, rating FROM movies
WHERE title LIKE 'Toy Story%';

-- 11
SELECT * FROM actors
WHERE first_name LIKE 'Sam%';

-- 12
SELECT title FROM movies
WHERE release_date BETWEEN "2004-01-01" AND "2008-12-31";

-- 13
SELECT title FROM movies
WHERE rating > 3 AND
awards > 1 AND 
release_date BETWEEN "1988-01-01" AND "2009-12-31"
ORDER BY rating;






















