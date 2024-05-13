#1
select movies.title, genres.name 
from movies 
inner join genres on movies.genre_id = genres.id
limit 10 offset 0;

#2

select episodes.title, actors.first_name, actors.last_name
from actor_episode
	inner join actors on actor_episode.actor_id = actors.id
    inner join episodes on actor_episode.episode_id = episodes.id;
    
#3

select series.title, count(series.id) 
from series
	inner join seasons on series.id = seasons.serie_id
group by series.id;

#4

select genres.name, count(genres.id) as "cantidad_peliculas"
from genres
		inner join movies on genres.id = movies.genre_id
group by genres.id
having cantidad_peliculas >= 3; #Alternativamente se puede usar count(genres.id)

#5

select actors.id, actors.first_name, actors.last_name 
from actors
	right join actor_movie on actors.id = actor_movie.actor_id
	right join movies on actor_movie.movie_id = movies.id
where movies.title like "La Guerra de las galaxias: %"
group by id;

