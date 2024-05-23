package com.demospring.practicahql.controller;

import com.demospring.practicahql.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private final IMovieService movieService;

    @GetMapping("/actorRating/{rating}")
    public ResponseEntity<?> getMoviesByActorRatingOver(@PathVariable double rating) {
        return new ResponseEntity<>(movieService.findMoviesByActorRatingOver(rating), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> getMoviesByActorRatingOver(@PathVariable String genre) {
        return new ResponseEntity<>(movieService.findMoviesByGenre(genre), HttpStatus.OK);
    }
}
