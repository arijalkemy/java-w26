use movies_db;

select * from movies;

/* punto 2*/
select a.first_name, a.last_name, a.rating
from actors a;

/*punto 3*/
select s.title as titulo
from series s;

/*punto4*/
select a.first_name nombre , a.last_name apellido
from actors a
where a.rating > 7.5;

/*punto 5*/
select m.title titulo, m.rating , m.awards premios
from movies m
where m.rating > 7.5 and m.awards > 2;

/*punto 6*/
select m.title titulo, m.rating
from movies m
order by m.rating asc;

/*punto 7*/
select m.title
from movies m
limit 0,3;

/*punto 8*/
select m.title, m.rating
from movies m
order by m.rating desc
limit 0,5;

/*punto 9*/
select a.id, a.first_name, a.last_name, a.rating, a.favorite_movie_id
from actors a
limit 0,10;

/*punto 10*/
select m.title,m.rating
from movies m
where m.title = "Toy Story";

/*punto 11*/
select  a.id, a.first_name, a.last_name, a.rating, a.favorite_movie_id
from actors a
where a.first_name like "sam%";

/*punto 12*/
select m.title, m.release_date
from movies m
where year(release_date) between 2004 and 2008;

/*punto 13*/
select m.title
from movies m
where m.rating > 3 and m.awards > 1 and year(release_date) between 1988 and 2009
order by m.rating;