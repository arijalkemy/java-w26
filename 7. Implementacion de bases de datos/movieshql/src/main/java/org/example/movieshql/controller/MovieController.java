package org.example.movieshql.controller;

import org.example.movieshql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/actors")
    ResponseEntity<?> retrieveMoviesByActorRating(@RequestParam Double rating){
        return ResponseEntity.ok(movieService.getMoviesByActorRating(rating));
    }

    @GetMapping("/genre/{genre}")
    ResponseEntity<?> retrieveMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }
}
