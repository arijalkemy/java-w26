select * from movies;

select first_name, last_name, rating from actors;

select title AS Titulo from series;

select first_name, last_name from actors where rating>7.5;

select title, rating, awards from movies where rating >7.5 and awards >2;

select title, rating from movies order by rating asc;

select title from movies limit 3;

select title as peliculas, rating from movies order by rating desc limit 5;

select first_name, last_name from actors limit 10;

select title, rating from movies where title like '%Toy story%';

select first_name, last_name from actors where first_name like 'Sam%';

select title from movies where year(release_date) between 2004 and 2008;

select title from movies where rating>3 and awards >1 and year(release_date) between 1988 and 2009 order by rating;