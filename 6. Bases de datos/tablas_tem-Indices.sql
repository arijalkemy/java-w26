USE movies_db;

DROP TABLE TWD;

CREATE TEMPORARY TABLE TWD (
	episodeId INTEGER, 
    episodieTitle VARCHAR(500), 
    episodieRating INTEGER,
    episodieNumber INTEGER, 
    seasonNumber INTEGER, 
    seasonTitle VARCHAR(500)
);

INSERT INTO TWD SELECT e.id, e.title, e.rating, e.number, s.number, s.title
FROM episodes e INNER JOIN seasons s ON e.season_id = s.id
				INNER JOIN series se ON se.id= s.serie_id
WHERE se.title = 'The Walking Dead';

SELECT * 
FROM TWD
WHERE seasonNumber=1;

SELECT episodeId,
    episodieTitle, 
    episodieRating ,
    episodieNumber , 
    seasonNumber , 
    seasonTitle
FROM TWD
WHERE episodieRating>5;

CREATE INDEX relase_dateIdx ON movies(release_date);

SHOW INDEX FROM movies;