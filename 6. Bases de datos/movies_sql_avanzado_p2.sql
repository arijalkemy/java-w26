
use movies_db;
#1
insert into movies (title, awards, rating, release_date)
values ("Blade Runner 2049", 10, 0.7,str_to_date("05-10-2017","%d-%m-%Y"));
select * from movies;

#2
insert into genres (name, ranking, active)
values("Thriller", 13, 1);
select * from genres;

#3

update movies m 
set m.genre_id = (select id from genres where name = "Thriller")
where m.id = 22;

select * from movies m
where m.id = 22;

#4
update actors a
set a.favorite_movie_id = 22
where a.id = 3;
select * from actors;

#5

create temporary table movies_tempo(
select * from movies
);
select * from movies_tempo;
select * from movies;

#6



with 
	ids as 			  (select id from movies where movies.awards < 5)
delete from movies_tempo
where movies_tempo.id <> 0 and movies_tempo.id in (select * from ids)
limit 1000;

select * from movies_tempo;
select * from movies;