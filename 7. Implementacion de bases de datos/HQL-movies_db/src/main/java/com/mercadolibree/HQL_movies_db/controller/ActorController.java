package com.mercadolibree.HQL_movies_db.controller;

import com.mercadolibree.HQL_movies_db.dto.ActorsResponseDto;
import com.mercadolibree.HQL_movies_db.service.actor.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    IActorService actorService;

    ActorController(IActorService _actorService)
    {
        actorService = _actorService;
    }


    @GetMapping("/get/favorite-movie")
    public ResponseEntity<?> getActors()
    {
        return new ResponseEntity<>(
                actorService.getAllActors(),
                HttpStatus.OK
        );
    }

    @GetMapping("/get/rating/{rating}")
    public ResponseEntity<List<ActorsResponseDto>> getActorsByAwardsNumber(@PathVariable Double rating)
    {
        return new ResponseEntity<>(
                actorService.getActorsByAwardsNumber(rating),
                HttpStatus.OK
        );
    }

    @GetMapping("/get/movie/{movie}")
    public ResponseEntity<List<ActorsResponseDto>> getActorsByMovie(@PathVariable String movie)
    {
        return new ResponseEntity<>(
                actorService.getActorsByMovie(movie),
                HttpStatus.OK
        );
    }

}
