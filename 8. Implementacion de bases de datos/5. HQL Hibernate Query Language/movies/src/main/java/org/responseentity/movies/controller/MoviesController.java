package org.responseentity.movies.controller;

import jakarta.websocket.server.PathParam;
import org.responseentity.movies.model.Movie;
import org.responseentity.movies.service.ActorService;
import org.responseentity.movies.service.EpisodeService;
import org.responseentity.movies.service.MovieService;
import org.responseentity.movies.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class MoviesController {
    ActorService actorService;
    MovieService movieService;
    SerieService serieService;
    EpisodeService episodeService;

    public MoviesController(
            @Autowired ActorService actorService,
            @Autowired MovieService movieService,
            @Autowired SerieService serieService,
            @Autowired EpisodeService episodeService
            )
    {
        this.actorService = actorService;
        this.movieService = movieService;
        this.serieService = serieService;
        this.episodeService = episodeService;
    }

    /** 1. Listar todos los actores que tengan declarada una película favorita. */
    @GetMapping("/actor/byfavoriteMovie")
    public ResponseEntity<?> actorsWithFavoriteMovie(){
        return new ResponseEntity(actorService.listAllActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    /* 2.Listar todos los actores que tengan rating superior a <valor recibido por parámetro>  */
    @GetMapping("/actor/byRating")
    public ResponseEntity<?> actorsWithRating(@PathParam("rating") Long rating){
        return new ResponseEntity<>(actorService.listAllActorsWithRating(rating), HttpStatus.OK);
    }

    /* 3. Listar todos los actores que trabajan en la <película recibida por parámetro> */
    @GetMapping("/actor/byMovie")
    public ResponseEntity<?> actorsByMovie(@PathParam("movie") String movie){
        return new ResponseEntity<>(actorService.listAllActorsByMovie(movie), HttpStatus.OK);
    }

    /* 4. Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro> */
    @GetMapping("/movie/ByActorRating")
    public ResponseEntity<?> moviesByActorRating(@PathParam("rating") Long rating){
        return new ResponseEntity<>(actorService.listMoviesByActorsRating(rating), HttpStatus.OK);
    }

    /* 5. Listar todas las películas que pertenezcan al <género recibido por parámetro> */
    @GetMapping("/movie/byGenre")
    public ResponseEntity<?> moviesByGenre(@PathParam("genre") String genre){
        return new ResponseEntity<>(movieService.listMoviesByGenre(genre), HttpStatus.OK);
    }

    /* 6. Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro> */
    @GetMapping("/series/byNumberOfSeasons")
    public ResponseEntity<?> seriesByNumbersOfSeasons(@PathParam("numberOfSeasons") Integer numberOfSeasons){
        return new ResponseEntity<>(serieService.listSeriesByNumberOfSeasons(numberOfSeasons), HttpStatus.OK);
    }

    /* 7. Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro> */
    @GetMapping("/episodes/byActors")
    public ResponseEntity<?> episodesByActors(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){
        return new ResponseEntity<>(episodeService.listAllEpisodesByActor(firstName, lastName), HttpStatus.OK);
    }

}