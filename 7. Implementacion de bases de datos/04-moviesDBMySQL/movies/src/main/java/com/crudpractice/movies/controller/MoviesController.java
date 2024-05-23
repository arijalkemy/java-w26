package com.crudpractice.movies.controller;

import com.crudpractice.movies.dto.ActorDTO;
import com.crudpractice.movies.dto.EpisodeDTO;
import com.crudpractice.movies.dto.MovieDTO;
import com.crudpractice.movies.dto.SerieDTO;
import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Genre;
import com.crudpractice.movies.service.IMoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MoviesController {
    private final IMoviesService moviesService;

    @GetMapping("/actors-with-fav-movies")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavMovies(){
        List<ActorDTO> actors = moviesService.showActorsWithFavMovies();
        return ResponseEntity.ok().body(actors);
    }

    @GetMapping("/actors-with-rating-greater-than")
    public ResponseEntity<List<ActorDTO>> getActorsWithRating(@RequestParam Double rating){
        List<ActorDTO> actors = moviesService.showActorsWithRatingGreaterThan(rating);
        return ResponseEntity.ok().body(actors);
    }

    @GetMapping("/actors-in")
    public ResponseEntity<List<ActorDTO>> getActorsInSpecificMovie(@RequestParam String movie){
        List<ActorDTO> actors = moviesService.showActorsThatAppearInMovie(movie);
        return ResponseEntity.ok().body(actors);
    }

    @GetMapping("/movies-with-actors-rating-greater-than")
    public ResponseEntity<List<MovieDTO>> getMoviesWithActorsWithRating(@RequestParam Double rating){
        List<MovieDTO> movies = moviesService.showMoviesByActorRating(rating);
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/movies-of")
    public ResponseEntity<List<MovieDTO>> getMoviesOfGenre(@RequestParam String genre){
        List<MovieDTO> movies = moviesService.showMoviesByGenre(genre);
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/series-with-more-seasons-than")
    public ResponseEntity<List<SerieDTO>> getSeriesWithMoreSeasons(@RequestParam Integer seasons){
        List<SerieDTO> series = moviesService.showSeriesBySeasons(seasons);
        return ResponseEntity.ok().body(series);
    }

    @GetMapping("/episodes-where-actor-appears")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesWithActor(@RequestParam String actor){
        List<EpisodeDTO> episodes = moviesService.showEpisodesByActors(actor);
        return ResponseEntity.ok().body(episodes);
    }
}
