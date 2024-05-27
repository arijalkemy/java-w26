package org.example.movieshql.controller;

import org.example.movieshql.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/genre/{genre}")
    ResponseEntity<?> getallMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.allMoviesByGenre(genre));
    }

    @GetMapping("/rating/{rating}")
    ResponseEntity<?> getallMoviesByGenre(@PathVariable double rating){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.listMoviesWithActorsAboveRating(rating));
    }
}
