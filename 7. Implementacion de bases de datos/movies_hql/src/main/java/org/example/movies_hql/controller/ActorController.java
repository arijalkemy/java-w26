package org.example.movies_hql.controller;

import lombok.RequiredArgsConstructor;
import org.example.movies_hql.model.Actor;
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
    public ResponseEntity<List<Actor>> getActorsWithFavoriteMovies() {
        return null;
    }

    @GetMapping("/by-rating")
    public ResponseEntity<List<Actor>> getActorsByRatingGT(
            @PathVariable Double rating
    ) {
        return null;
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<Actor>> getActorsByMovie(
            @PathVariable String movie
    ) {
        return null;
    }
}
