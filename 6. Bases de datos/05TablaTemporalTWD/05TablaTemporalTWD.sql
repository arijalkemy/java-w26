CREATE TEMPORARY TABLE TWD (
	id int NOT NULL PRIMARY KEY,
    created_at timestamp,
    updated_at timestamp,
    title varchar(500),
    number int NOT NULL,
    release_date datetime,
    rating decimal(3,1),
    season_id int NOT NULL
);

INSERT INTO TWD (
	SELECT e.*
	FROM episodes e
	INNER JOIN seasons t ON e.season_id = t.id
	INNER JOIN series s ON t.serie_id = s.id
	WHERE s.title = 'The Walking Dead'
);

EXPLAIN SELECT *
FROM TWD
WHERE title = 1;

/* 
SELECT e.*
FROM episodes e
INNER JOIN seasons t ON e.season_id = t.id
INNER JOIN series s ON t.serie_id = s.id
WHERE s.title = 'The Walking Dead';
*/