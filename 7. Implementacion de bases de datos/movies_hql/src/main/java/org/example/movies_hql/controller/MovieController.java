package org.example.movies_hql.controller;

import lombok.RequiredArgsConstructor;
import org.example.movies_hql.model.Movie;
import org.example.movies_hql.service.interfaces.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final IMovieService service;

    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> getMoviesByGenre(
            @PathVariable String genre
    ) {
        return null;
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Movie>> getMovieByRating(
            @PathVariable Double rating
    ){
        return null;
    }
}
