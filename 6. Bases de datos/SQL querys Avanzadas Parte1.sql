SELECT * FROM movies_db.movies;
 
SELECT first_name as Nombre, last_name as Apellido, rating as Puntuacion FROM movies_db.actors;

SELECT title  as Titulo FROM movies_db.series;

SELECT first_name as Nombre, last_name as Apellido FROM movies_db.actors a WHERE rating > 7.5;

SELECT title as Titulo, rating as Puntuacion, awards as Premios FROM movies_db.movies m WHERE rating > 7.5 AND awards > 2;

SELECT title as Titulo, rating as Puntuacion FROM movies_db.movies ORDER BY rating;

SELECT title as Titulo FROM movies_db.movies m LIMIT 3;

SELECT title as Titulo, rating as Puntuacion FROM movies_db.movies ORDER BY rating DESC LIMIT 5;

SELECT first_name as Nombre FROM movies_db.actors a  LIMIT 10;

SELECT title as Titulo, rating as Puntuacion FROM movies_db.movies m WHERE title LIKE  "Toy Story%";

SELECT first_name as Nombre, last_name as Apellido FROM movies_db.actors a WHERE first_name LIKE "Sam%";

SELECT title AS Titulo, rating AS Puntuacion FROM movies_db.movies 
WHERE rating > 3 AND awards > 1 AND  release_date BETWEEN '2004-01-01' AND '2008-12-31'
ORDER  BY rating;


-------------------------------

SELECT title as titulo, name as Genero From movies_db.movies m JOIN movies_db.genres g on m.genre_id = g.id ;

SELECT title, first_name, last_name FROM movies_db.episodes e JOIN movies_db.actor_episode ae on e.id = ae.episode_id
JOIN movies_db.actors a ON ae.actor_id = a.id;

SELECT s.title, COUNT(s2.`number`) AS season_count
FROM movies_db.series s
JOIN movies_db.seasons s2 ON s.id = s2.serie_id
GROUP BY s.title;


SELECT name,COUNT(m.title) as Conteo FROM movies_db.genres g JOIN movies_db.movies m ON m.genre_id = g.id GROUP BY g.name; 

SELECT name,COUNT(m.title) as Conteo FROM movies_db.genres g JOIN movies_db.movies m ON m.genre_id = g.id GROUP BY g.name HAVING Conteo > 3; 

SELECT DISTINCT first_name, last_name FROM movies_db.actors a 
JOIN movies_db.actor_movie am ON a.id = am.actor_id 
JOIN movies_db.movies m ON am.movie_id = m.id 
WHERE m.title LIKE 'La Guerra de las galaxias%';


