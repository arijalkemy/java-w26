package org.ggomezr.movies.application.controller;

import org.ggomezr.movies.application.service.interfaces.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actor-rating/{rating}")
    public ResponseEntity<?> findAllMoviesWhoseActorsRatingIsGreaterThan(@PathVariable Float rating) {
        return ResponseEntity.ok(movieService.getAllMoviesWhoseActorsRatingIsGreaterThan(rating));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<?> findAllMoviesWithGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getAllMoviesWithGenre(genre));
    }
}
