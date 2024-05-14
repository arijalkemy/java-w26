## La suboconsulta rompe si devuelve mas de un valor
SELECT m.title, m.awards
FROM movies m
WHERE awards = (select m2.title, m2.awards from movies m2 WHERE title like 'Big');

insert into movies
    (created_at, updated_at, title, rating, awards, release_date, length, genre_id )
values
    (now(), now(), 'big', 8.3, 3, '1995-11-22', 81, 1);
