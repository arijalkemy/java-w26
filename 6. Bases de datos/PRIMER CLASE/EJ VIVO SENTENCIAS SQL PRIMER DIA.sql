use movies_db;

select * FROM movies; -- 1

select first_name as nombre, last_name as apellido, rating FROM actors; -- 2

select title as titulo FROM series; --  EJ 3

select first_name as nombre, last_name as apellido FROM actors
WHERE rating > 7.5; -- 4

select title, rating, awards from movies where rating > 7.5 and awards > 2; -- EJ 5

select title, rating from movies order by rating ASC; -- EJ 6

select title from movies LIMIT 3; -- EJ 7

select title, rating FROM movies order by rating DESC LIMIT 5; -- EJ 8

select first_name as nombre, last_name as apellido, rating from actors LIMIT 10; -- EJ 9

select title, rating from movies where title like "%Toy Story%"; -- EJ 10

select first_name as nombre, last_name as apellido, rating from actors 
where first_name like "Sam%"; -- EJ 11

select title from movies where release_date between "20040101" and "20081231"; -- EJ 12

select title from movies where rating > 3 and awards >1 and year(release_date) between 1998 and 2009 order by rating; -- EJ 13
 

