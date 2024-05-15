-- Select the DB to use
USE movies_db;

-- All movies are consulted
SELECT * FROM movies;

-- The name, surname and rating of all the actors are consulted.
SELECT first_name, last_name, rating FROM actors;

-- the title of all series with aliases is queried
SELECT title AS titulo FROM series AS tabla_series;

-- The first and last name of the actors whose rating is greater than 7.5 is consulted.
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

-- The title of the films, the rating and the awards of the films with a rating greater than 7.5 and with more than two awards are consulted.
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

-- The title of the movies and the rating are consulted, ordered by rating in ascending order.
SELECT title, rating FROM movies ORDER BY rating ASC;

-- The titles of the first three films are consulted in the database.
SELECT awards FROM movies LIMIT 3;

-- The top 5 films with the highest rating are consulted.
SELECT * FROM movies ORDER BY rating DESC LIMIT 5;

-- the first 10 actors are consulted.
SELECT * FROM actors LIMIT 10;

-- The title and rating of all films whose title is Toy Story is consulted.
SELECT title, rating FROM movies WHERE title LIKE "%toy story%";

-- all actors whose names begin with Sam are consulted.
SELECT * FROM actors WHERE first_name LIKE "sam%";

-- Check the titles of the films that came out between 2004 and 2008.
SELECT title FROM movies WHERE release_date >= '2004-01-01 00:00:00' AND release_date <= '2008-12-31 23:59:59';

-- The title of the films with a rating greater than 3, with more than 1 award and with a release date between 1988 and 2009 is consulted. Sort the results by rating.
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND release_date >= '1988-01-01 00:00:00' AND release_date <= '2009-12-31 23:59:59' ORDER BY rating;