package org.miprimerproyecto.practicahql.controller;

import org.miprimerproyecto.practicahql.service.imp.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class movieController {

    @Autowired
    private movieService movieService;

    @GetMapping("/list/{rating}")
    public ResponseEntity<?> findAll(@PathVariable Double rating) {
        return ResponseEntity.ok(movieService.findMoviesWithActorsRatingGreaterThan(rating));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<?> findMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.findMoviesByGenre(genre));
    }
}
