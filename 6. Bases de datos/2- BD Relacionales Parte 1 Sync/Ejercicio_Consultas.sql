SELECT id, title, rating, awards, release_date, length, genre_id from movies;

SELECT first_name, last_name, rating from actors;

SELECT title AS "titulo" from series;

SELECT first_name, last_name from actors WHERE rating > 7.5;

SELECT title from movies WHERE rating > 7.5 AND awards > 2;

SELECT title, rating from movies ORDER BY rating;

SELECT title from movies LIMIT 3;

SELECT title from movies ORDER BY rating DESC LIMIT 5;

SELECT first_name, last_name, rating from actors LIMIT 10;

SELECT title, rating from movies WHERE title LIKE "Toy Story";

SELECT first_name, last_name, rating from actors WHERE first_name LIKE "Sam%";

SELECT title from movies WHERE release_date BETWEEN "2004-01-01" AND "2008-12-12";

SELECT title from movies WHERE rating > 3 AND awards > 1 AND (release_date BETWEEN "1988-01-01" AND "2009-12-12"); 
