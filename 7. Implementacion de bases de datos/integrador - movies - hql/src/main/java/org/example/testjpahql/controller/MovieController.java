package org.example.testjpahql.controller;


import lombok.RequiredArgsConstructor;
import org.example.testjpahql.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService movieService;

    @GetMapping("/rating/{rating}")
    @ResponseBody
    public ResponseEntity<?> getMoviesWithActorRating(@PathVariable BigDecimal rating){
        return ResponseEntity.ok(movieService.getMovieWithActorRating(rating));
    }

    @GetMapping("/genre/{genre}")
    @ResponseBody
    public ResponseEntity<?> getMoviesWithActorRating(@PathVariable String genre){
        return ResponseEntity.ok(movieService.getMovieWithGenre(genre));
    }

}
