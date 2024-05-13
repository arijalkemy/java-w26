use movies_db;
#select * from movies; #1
#select first_name, last_name, rating from actors; #2
#select title as Titulo from series; #3
/* #3
select first_name, last_name from actors
where rating > 7.5;
*/

#4
select title, rating, awards from movies
where rating > 7.5 and awards > 2
;
#5
select title, rating from movies
order by rating;

#6
select title from movies limit 3;

#7
select title, rating from movies
order by rating desc limit 5;

#8
select first_name, last_name from actors limit 10;

#9
select title, rating from movies
where title like "%Toy Story%"; #Para consultar (Qué otras formas hay?)

#10
select first_name, last_name from actors
where first_name like "Sam%"; #Comodines de like

#11
select title, release_date from movies
where release_date between "2004-01-01 00:00:00" and "2008-12-31 00:00:00"; #Se podra con simbolos con >, <, >=

#12
select title, rating, release_date from movies 
where
rating > 3
and awards > 1
and release_date between "1988-01-01 00:00:00" and "2009-12-31 00:00:00"
order by rating desc;

