
create temporary table TWD
    select e.*, s2.title as temporada from series s
    join Seasons s2 on s.id = s2.serie_id
    join episodes e on s2.id = e.season_id
    where s.title like 'The Walking Dead%';

select * from TWD
where temporada like 'Primer Temporada';

## nombre, apellido de los actores y aparaciones
## de los actores que aparecen en the walking dead
## mas de 4 veces

select distinct
    a.first_name,
    a.last_name,
    count(a.id) as apariciones
from TWD t join actor_episode at on t.id= at.episode_id
    inner join actors a on at.actor_id = a.id
group by a.id
having apariciones > 4;

## el titulo tiene mucha concurrencia

create index movies_idx on movies(title);
