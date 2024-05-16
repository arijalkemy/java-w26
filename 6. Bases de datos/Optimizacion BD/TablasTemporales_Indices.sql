-- Ejercicio 1
create temporary table twd
select e.*
from episodes e
inner join seasons s on s.id = e.season_id
inner join series ser on ser.id = s.serie_id
where ser.title like "The Walking Dead";

select *
from twd
where season_id in (select id
					from seasons 
                    where title like "Primer Temporada");
                    
-- Ejercicio 2
alter table series
add index index_title_series (title);

show index from series;
-- elegí esta columna ya que es consultada frecuentemente y su busqueda deberia ser rapida