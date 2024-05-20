-- Mostrar el título y el nombre del género de todas las series.
SELECT M.title AS titulo, G.name AS genero
FROM movies M
INNER JOIN genres G
	ON M.genre_id = G.id;


-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT E.title, actors_info.first_name, actors_info.last_name
FROM episodes E
INNER JOIN (
	SELECT AE.id, A.first_name, A.last_name
    FROM actors A 
    INNER JOIN actor_episode AE 
		ON A.id = AE.actor_id
	) AS actors_info
    ON E.id = actors_info.id;


-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT S.title, COUNT(SS.id) AS totalTemporadas
FROM series S 
INNER JOIN seasons SS
	ON S.id = SS.serie_id
GROUP BY S.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT G.name, COUNT(M.id) AS total_movies
FROM genres G 
INNER JOIN movies M 
	ON G.id = M.genre_id
GROUP BY G.name
HAVING total_movies > 2;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT A.first_name, A.last_name
FROM actors A
INNER JOIN (
    SELECT AM.actor_id
    FROM actor_movie AM
    INNER JOIN movies M 
		ON M.id = AM.movie_id
    WHERE M.title LIKE 'La Guerra de las Galaxias%'
    GROUP BY AM.actor_id
) AS SW_actors
	ON A.id = SW_actors.actor_id;


SELECT A.first_name, A.last_name
FROM actors A
INNER JOIN (
    SELECT AM.actor_id
    FROM actor_movie AM
    INNER JOIN movies M 
		ON M.id = AM.movie_id
    WHERE M.title LIKE 'La Guerra de las Galaxias%'
    GROUP BY AM.actor_id
    HAVING COUNT(DISTINCT M.id) = (	SELECT COUNT(*) 
									FROM movies 
                                    WHERE title LIKE 'La Guerra de las Galaxias%'
									)
) AS SW_actors
	ON A.id = SW_actors.actor_id;

