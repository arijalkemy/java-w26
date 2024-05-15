create temporary table twd
select episodes.*, seasons.number as season_number
from episodes 
inner join seasons on episodes.season_id = seasons.id
inner join series on series.id = seasons.serie_id
where series.title = 'The Walking Dead';

select * from twd where season_number = 1;

-- Se creó un índice sobre la columna title de la tabla Series
-- El mismo fue creado porque es una comlumna de consultas frecuentes,
-- ya que siempre se realizan búsquedas por el titulo de la serie.


-- Consultas SQL Avanzadas 2

-- Agregar una película a la tabla movies.
insert into movies (title, rating, awards, release_date, length, genre_id)
values ("El Padrino", 5, 3, "1972-03-24", 175, 1);

-- Agregar un género a la tabla genres.
insert into genres (created_at, updated_at, name, ranking, active)
values (now(), null, "Musical", 14, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies
set genre_id = 13
where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors
set favorite_movie_id = 22
where id = 16;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table movies_temp 
select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from movies_temp where awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select g.name from genres g
inner join movies m on g.id = m.genre_id
group by g.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.*, m.awards from actors a
inner join movies m on m.id = a.favorite_movie_id
where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
-- Chequee que el índice fue creado correctamente.
explain select * from movies where title = 'La Guerra de las galaxias: Episodio VII';

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si existiría una mejora notable, mas que nada al crecer el tamaño de la tabla.
-- Esta es una columna en la que es correcto aplicar un índice, debido a que las búsquedas siempre se realizan por nombre.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearía un índice en la columna first_name y last_name de la tabla actors, porque es una columna que tambien va a recibir muchas consultas.
