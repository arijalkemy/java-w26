package org.example.movies.controller;

import org.example.movies.model.dto.ActorResponseDTO;
import org.example.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    IMovieService service;

    @GetMapping("/actors/with_favorite_movie")
    ResponseEntity<List<ActorResponseDTO>> findActorsWithFavoriteMovie() {
        return ResponseEntity.ok(service.findActorsWithFavoriteMovie());
    }

    @GetMapping("/actors/rating/greater_than/{rating}")
    ResponseEntity<List<ActorResponseDTO>> findActorsWithRatingGreaterThan(@PathVariable Double rating) {
        return ResponseEntity.ok(service.findActorsWithRatingGreaterThan(rating));
    }

    @GetMapping("/actors/movie/{movie}")
    ResponseEntity<List<ActorResponseDTO>> findActorsByTitleMovie(@PathVariable String movie) {
        return ResponseEntity.ok(service.findActorsByTitleMovie(movie));
    }

}
