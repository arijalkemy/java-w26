package org.example.movieshql.controller;

import org.example.movieshql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    IActorService actorService;

    @GetMapping("/favorite-movie")
    ResponseEntity<?> retrieveActorsWithFavoriteMovie(){
        return ResponseEntity.ok(actorService.getActorsWithFavoriteMovie());
    }

    @GetMapping("/rating/{rating}")
    ResponseEntity<?> retrieveActorsWithFavoriteMovie(@PathVariable Double rating){
        return ResponseEntity.ok(actorService.getActorsByHigherRating(rating));
    }

    @GetMapping("/movie/{movie}")
    ResponseEntity<?> retrieveActorsByMovie(@PathVariable String movie){
        return ResponseEntity.ok(actorService.getActorsByMovie(movie));
    }

}
