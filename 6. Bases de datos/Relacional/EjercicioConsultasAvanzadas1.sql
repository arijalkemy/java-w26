-- 1
SELECT mo.title, gen.name FROM movies mo 
INNER JOIN genres gen 
ON mo.genre_id = gen.id;

-- 2
SELECT ep.title, ac.first_name, ac.last_name FROM episodes ep 
INNER JOIN actor_episode ac_ep 
INNER JOIN actors ac 
ON ep.id = ac_ep.episode_id AND ac_ep.actor_id = ac.id;

-- 3
SELECT ser.title, COUNT(DISTINCT ep.season_id) as NumberOfSeasons FROM series ser
INNER JOIN episodes ep
INNER JOIN seasons sea
ON sea.serie_id = ser.id AND ep.season_id = sea.id
GROUP BY ser.title;

-- 4
SELECT name, COUNT(*) as NumberOfFilmsWithGenre FROM genres gen
INNER JOIN movies mo
ON mo.genre_id = gen.id
GROUP BY gen.id
HAVING NumberOfFilmsWithGenre >= 3;

-- 5
SELECT act.FIRST_NAME, act.LAST_NAME FROM actors act
INNER JOIN actor_movie am
INNER JOIN movies mo
ON act.id = am.actor_id AND am.movie_id = mo.id
WHERE mo.title LIKE 'La Guerra de las galaxias%'
GROUP BY act.FIRST_NAME, act.LAST_NAME
HAVING COUNT(*) = (SELECT COUNT(*) FROM movies WHERE title LIKE 'La Guerra de las galaxias%');