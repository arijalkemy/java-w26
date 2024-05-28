package org.example.movies_hql.controller;

import lombok.RequiredArgsConstructor;
import org.example.movies_hql.model.ActorsEntity;
import org.example.movies_hql.service.interfaces.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {
    private final IActorService service;

    @GetMapping("/has-favorite")
    public ResponseEntity<List<ActorsEntity>> getActorsWithFavoriteMovies() {
        return null;
    }

    @GetMapping("/by-rating")
    public ResponseEntity<List<ActorsEntity>> getActorsByRatingGT(
            @PathVariable Double rating
    ) {
        return null;
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<ActorsEntity>> getActorsByMovie(
            @PathVariable String movie
    ) {
        return null;
    }
}
