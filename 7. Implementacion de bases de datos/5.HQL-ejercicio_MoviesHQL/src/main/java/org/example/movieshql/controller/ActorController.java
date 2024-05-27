package org.example.movieshql.controller;

import org.example.movieshql.services.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping
    public ResponseEntity<?> getAllActorsWithFavoriteMovie(){
        return ResponseEntity.status(HttpStatus.OK).body(actorService.allActorsWithFavoriteMovie());
    }

    @GetMapping("/movieName/{movie_name}")
    public ResponseEntity<?> getallActorsByMovie(@PathVariable String movie_name){
        return ResponseEntity.status(HttpStatus.OK).body(actorService.allActorsByMovie(movie_name));
    }

    @GetMapping("/actorRating/{rating}")
    public ResponseEntity<?> getallallActorsWithRatingMostOf(@PathVariable double rating){
        return ResponseEntity.status(HttpStatus.OK).body(actorService.allActorsWithRatingMostOf(rating));
    }

}
