package org.ggomezr.movies.application.controller;

import org.ggomezr.movies.application.service.interfaces.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/favorite-movie")
    public ResponseEntity<?> getAllActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.getAllActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating-greater-than/{rating}")
    public ResponseEntity<?> findAllActorsWithRatingGreaterThan(@PathVariable Float rating) {
        return new ResponseEntity<>(actorService.findAllActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/work-in-movie/{movieTitle}")
    public ResponseEntity<?> findAllActorsWhoWorkInTheMovie(@PathVariable String movieTitle) {
        return new ResponseEntity<>(actorService.findAllActorsWhoWorkInTheMovie(movieTitle), HttpStatus.OK);
    }
}
