
/* Ejercicio 1 */
CREATE TEMPORARY TABLE TWD (title varchar(500), seasonsTitle varchar(500), number int unsigned, rating decimal(3,1));

insert into twd select episodes.title, seasons.title, episodes.number, episodes.rating from episodes
inner join seasons on seasons.id = episodes.season_id
inner join series on series.id = seasons.serie_id
where series.title like 'The Walking Dead';

/*capitulos primer temporada*/
select * from twd
where seasonsTitle = 'Primer Temporada';


/*Ejercicio 2*/
/* crear un indice y explicar el porque */

ALTER TABLE `movies_db`.`seasons` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;

explain select title from seasons
where title = 'Primer Temporada';

/*  Se decidio indexar la columna title de la tabla seasons porque se estaba realizando muchas consultas sobre la misma.
y al ver que cada consulta ocupaba 46 iteraciones, klogramos una mejora de 40 iteraciones menos cada vez que se realiza esa consulta.*/
