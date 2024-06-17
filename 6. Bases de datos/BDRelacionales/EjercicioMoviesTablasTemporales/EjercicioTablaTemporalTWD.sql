-- tabla temporal
create temporary table TWD as
select e.* from episodes e join seasons s ON e.season_id = s.id join series se ON s.serie_id = se.id where se.title = 'The Walking Dead';
-- consulta
select * from TWD; 
