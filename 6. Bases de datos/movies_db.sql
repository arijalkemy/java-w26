-- Active: 1715349678349@@127.0.0.1@3306@movies_db
use movies_db;

/* 1 */
select * FROM movies;

/* 2 */
select first_name,last_name, rating FROM actors;

/* 3 */
select title as titulo from series as tabla_titulos;

/* 4 */
select first_name,last_name,rating from actors WHERE rating > 7.5;

/* 5 */
select title,rating,awards from movies where rating > 7.5 AND awards > 2;

/* 6 */
select title,rating from movies ORDER BY rating ASC;

/* 7 */
SELECT title from movies LIMIT 3;

/* 8 */
SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;

/* 9 */
select * from actors LIMIT 10;

/* 10 */
select title,rating from movies where title like 'Toy Story%';

/* 11 */
select * from actors where first_name like 'Sam%';

/* 12 */
select * from movies where release_date between '2004-01-01' and '2008-01-01' ;

/* 13 */
select title from movies where rating > 3 AND awards > 1 AND release_date between '1988-01-01' and '2009-01-01';



