SELECT * FROM actors;

SELECT first_name, last_name, rating FROM actors;

SELECT title AS titulo FROM series;

SELECT first_name, last_name FROM actors WHERE rating>7.5;

SELECT title, rating, awards FROM movies where rating>7.5 AND awards>2;

SELECT title, rating FROM movies ORDER BY rating;

SELECT title FROM movies limit 3;

SELECT title, rating FROM movies ORDER BY rating DESC limit 5;

SELECT first_name, last_name FROM actors limit 5;

SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';

SELECT first_name, last_name FROM actors WHERE first_name LIKE 'Sam%';

SELECT title, release_date FROM movies WHERE year(release_date) BETWEEN 2004 AND 2008;

SELECT title, rating, awards, release_date FROM movies WHERE rating>3 AND awards>1 AND year(release_date) BETWEEN 1988 AND 2009 ORDER BY rating;
