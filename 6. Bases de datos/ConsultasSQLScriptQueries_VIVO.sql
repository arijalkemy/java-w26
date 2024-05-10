USE movies_db;

SELECT id, title, rating, awards, release_date, length, genre_id  FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title AS "Titulo" FROM series AS Programas;

SELECT first_name, last_name FROM actors WHERE rating>7.5;

SELECT title, rating, awards FROM movies WHERE rating>7.5 AND awards>2;

SELECT title, rating FROM movies ORDER BY rating ASC;

SELECT title FROM movies LIMIT 3;

SELECT id, title, rating, awards, release_date, length FROM movies ORDER BY rating DESC LIMIT 5;

SELECT id, first_name, last_name, rating, favorite_movie_id FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title LIKE "Toy Story";

SELECT id, first_name, last_name, rating, favorite_movie_id FROM actors WHERE first_name LIKE "Sam%";

SELECT title FROM movies WHERE release_date BETWEEN "2004-01-01" AND "2008-12-12";

SELECT title, rating, awards, release_date FROM movies WHERE rating>3 AND awards>1 AND (release_date BETWEEN "1988-01-01" AND "2009-12-12");



