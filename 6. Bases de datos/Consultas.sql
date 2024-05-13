SELECT * FROM movies_db.movies;

SELECT first_name, last_name, rating 
FROM movies_db.actors;

SELECT title as Titulo
FROM movies_db.series as Serie;

SELECT first_name, last_name
FROM movies_db.actors
WHERE rating >= 7.5;

SELECT title, rating,movies, awards
FROM movies_db.movies
WHERE rating>=7.5 AND awards>=2;

SELECT title, rating
FROM movies_db.movies
ORDER BY rating ASC;

SELECT title
FROM movies_db.movies
LIMIT 3;

SELECT title
FROM movies_db.movies
ORDER BY rating DESC
LIMIT 5;

SELECT *
FROM movies_db.actors
LIMIT 10;

SELECT title, rating
FROM movies_db.movies
WHERE title LIKE '%Toy Story%';

SELECT * 
FROM movies_db.actors
WHERE first_name LIKE 'Sam%';

SELECT title
FROM movies_db.movies
WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';

SELECT title
FROM movies_db.movies
WHERE rating > 3 AND awards > 1 AND  release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating DESC;
