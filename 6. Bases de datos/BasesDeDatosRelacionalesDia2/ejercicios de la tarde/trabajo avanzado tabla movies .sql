
#Agregar una película a la tabla movies
INSERT INTO movies VALUES  (null,null,null,'Taxi Driver',7.5,3,'2020-01-01 00:00:00', null, null );
#Agregar un género a la tabla genres.
insert into genres VALUES (null, null, null, 'anime',13, 0);
#Asociar a la película del punto 1. genre el género creado en el punto 2.
#sabiendo el id del genero
UPDATE movies SET genre_id=13 where id =27;
#sin saber el id del genero
Update movies SET genre_id=(SELECT id from genres where name like "anime"); #(tira error por configuracion pero trae correctamente el id)

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
 UPDATE actors set favorite_movie_id = 27 where id =1;
 update actors set favorite_movie_id = (SELECT id from movie where title LIKE "Taxi Driver");
#Crear una tabla temporal copia de la tabla movies.
CREATE temporary table moviesTemp SELECT * from movies;
select * from movieTemp;
#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE from moviesTemp where awards <5;
#Obtener la lista de todos los géneros que tengan al menos una película.
#en este caso no hace falta el having ya que el join solo
#traera el registro en caso de que haya una peli en el genero
select COUNT(*) as number_of_movies, g.* from genres g JOIN movies m ON m.genre_id= g.id group by g.id ;
#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.*, m.awards from (actors a join movies m on a.favorite_movie_id = m.id) where m.awards>3;
#Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD index NameIndex (title);
#Chequee que el índice fue creado correctamente.
show index from movies;
#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

#.  en este caso no tanto ya que es una base d edtaos chica por elñ momento y hasta que no crezca
#.  considerablemnete no podremos notar una mejora en la busqueda

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# crearia uno en series por nombre ya que creo que sera una forma muy seguida de consultar los registros.
