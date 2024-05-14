INSERT INTO movies
(created_at, updated_at, title, rating, awards, release_date, `length`)
VALUES(CURRENT_DATE ,null,'Codigo Enigma', 5.4, 4, '2023-04-04', 120);

-- Agregar un género a la tabla genres.
INSERT INTO movies_db.genres
( created_at, updated_at, name, ranking, active)
VALUES (CURRENT_DATE, null, 'Epoca', (select max(g.ranking) + 1 from genres g), 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = (select max(g.id) from genres g)
WHERE id = 23 ;

select * from genres;
select * from movies;

update movies
set genre_id = 13
where title = 'Codigo Enigma';

update actors a
set a.favorite_movie_id = (select m.id from movies m where m.title = 'Codigo Enigma')
where a.id = 2;

create temporary table movies_copy
    select * from movies;

delete from movies_copy
where awards < 5;

select * from movies_copy;

select distinct
    genres.*
from genres
inner join movies m on genres.id = m.genre_id;

select distinct
    a.*
from actors a join movies m on a.favorite_movie_id = m.id
where awards > 3;


drop index movies_idx on movies;
create index movies_idx on movies(title);

show index from movies;

explain select * from movies where movies.title like 'Codigo Enigma';

drop index movies_idx on movies;

explain select * from movies where movies.title like 'Codigo Enigma';

#11
# si existe porque filtra por menos filas, se podria valorar crear
# un indice por rating

##12
## crearia en la tabla series por el titulo tambien
