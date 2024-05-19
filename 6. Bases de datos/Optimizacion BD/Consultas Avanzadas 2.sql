-- Agregar una película a la tabla movies.
INSERT INTO `movies_db`.`movies`
(`id`,
`created_at`,
`updated_at`,
`title`,
`rating`,
`awards`,
`release_date`,
`length`,
`genre_id`)
VALUES
(null,
null,
null,
"Madagascar",
9.1,
6,
"1990-07-06",
130,
null);

-- Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres`
(`id`,
`created_at`,
`updated_at`,
`name`,
`ranking`,
`active`)
VALUES
(null,
null,
null,
"Caricatura",
13,
1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name like "Caricatura")
WHERE id IN (SELECT mid FROM (SELECT id as mid FROM movies WHERE title like "Madagascar") AS subquery);

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
set favorite_movie_id = (SELECT id FROM movies WHERE title like "Madagascar")
where id = 3;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table movies_copy
select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from movies_copy
where awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select g.name, count(*) as cant_movies
from genres g
inner join movies m on m.genre_id = g.id
group by g.name
having cant_movies >= 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.first_name, a.last_name, m.awards
from actors a
inner join movies m on m.id = a.favorite_movie_id
where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
create index movies_title_index
on movies (title);

-- Chequee que el índice fue creado correctamente.
show index from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si existiria una mejora considerable ya que una consulta usual seria consultar las movies por titulo, y esto hace que dicha
-- consulta sea mucho mas rapida.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearia indice en la tabla series, en su columna title bajo el mismo criterio que en la tabla movies. Tambien agregaria en la tabla 
-- episodes en su atributo title, en la tabla season en su atributo title, y en la tabla actors en sus atributos nombre y apellido
-- ya que considero que estas tablas son candidatas a ser consultadas bajo esos criterios, pero todo dependerá del dominio