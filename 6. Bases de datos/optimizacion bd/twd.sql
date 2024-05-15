CREATE TEMPORARY TABLE TWD (
	id int NOT NULL,
    title varchar(500),
    number int,
    season_id int
);

INSERT INTO TWD (id, title, number, season_id)
SELECT e.id, e.title, e.number, e.season_id
FROM episodes e
JOIN seasons s ON s.id = e.season_id
JOIN series se ON se.id = s.serie_id
WHERE se.title LIKE '%The Walking Dead%';

SELECT * FROM TWD
WHERE number = 1;

#Veo iteraciones antes de crear el indice
EXPLAIN SELECT release_date FROM episodes
WHERE release_date > '2010-01-01';

CREATE INDEX episode_release ON episodes(release_date);

#Veo iteraciones luego de crear el indice
EXPLAIN SELECT release_date FROM episodes
WHERE release_date > '2010-01-01';

