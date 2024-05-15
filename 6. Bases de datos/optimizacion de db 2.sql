
/* consultas optimiozacion parte 2 */

insert into movies values (22, null, null, 'Star Wars 7', 8.2, 2, '2010-10-04', 200, 5);

insert into genres values (13, null, null, 'Espacial', 13, 1);

update movies set genre_id = 13 where id = 22;

update actors set favorite_movie_id = 22 where id = 4;

CREATE TEMPORARY TABLE temp_movies (id int, created_at timestamp, updated_at timestamp, title varchar(500), rating decimal(3,1), awards int, release_date datetime, length int, genre_id int);
