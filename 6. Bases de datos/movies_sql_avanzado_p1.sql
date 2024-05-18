/*
use movies_db;

EXPLAIN SELECT m.title, g.name FROM movies m
JOIN genres g ON g.id = m.genre_id
WHERE g.name = 'Drama';


select id from movies
where awards > 5;

delete from movies a where a.id in (select m.id from movies m
where m.awards > 5);

delete from movies where id = 2;
*/

#1
use movies_db;
drop table if exists TWD;
create temporary table TWD(
select s1.id as Id, s1.title as Serie, s2.title as Temporada, e.title as Episodio 
from series s1
	inner join seasons s2 on s1.id = s2.serie_id
    inner join episodes e on s2.id = e.season_id
where s1.title like "The walking%"
);

select TWD.Episodio from TWD
where TWD.Temporada like "Primer Temporada%";

#2

#Query esperada a ser optimizada
explain select * #By Movies
from movies
	inner join genres on movies.genre_id = genres.id
where genres.name = "Aventuras";

explain select * #By Genre
from genres
	inner join movies on genres.id = movies.genre_id
where genres.name = "Aventuras";

select * #By Movies
from movies
	inner join genres on movies.genre_id = genres.id
where genres.name = "Aventuras";

select * #By Genre
from genres
	inner join movies on genres.id = movies.genre_id
where genres.name = "Aventuras";

show index from movies;
show index from genres;

#Creación de indice en nombre
create index indice_srch_name on genres(name); #Podría dar error si ya esta creado el indice

#Query esperada a ser optimizada
explain select * #By Movies
from movies
	inner join genres on movies.genre_id = genres.id
where genres.name = "Aventuras";

explain select * #By Genre
from genres
	inner join movies on genres.id = movies.genre_id
where genres.name = "Aventuras";

select * #By Movies
from movies
	inner join genres on movies.genre_id = genres.id
where genres.name = "Aventuras";

select * #By Genre
from genres
	inner join movies on genres.id = movies.genre_id
where genres.name = "Aventuras";

# Se selecciono la columna nombre de genres por 2 razones
# 1. La frecuencia de inserción de un genero a un sistema de peliculas es baja teniendo en cuenta los generos
# 2. Es común o frecuente buscar peliculas por genero
# Nota: Debido a que la query de busqueda depende de un join con (Genres o Movies) es pertinente la creación del indice adicionalmente a lo anterior.



