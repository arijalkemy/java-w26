CREATE TEMPORARY TABLE twd
SELECT ser.title AS serie_title, sea.title AS season_title, ep.*
FROM series ser
INNER JOIN seasons sea ON ser.id = sea.serie_id
INNER JOIN episodes ep ON sea.id = ep.season_id
WHERE ser.title = 'The Walking Dead';

SELECT * FROM twd WHERE season_title = "Primer Temporada"; 