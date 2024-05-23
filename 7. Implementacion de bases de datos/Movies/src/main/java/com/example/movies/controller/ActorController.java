package com.example.movies.controller;

import com.example.movies.dto.ActorDTO;
import com.example.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping("/favorite-movie")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavoriteMovie(){
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getAutorsWithFavoriteMovie());
    }

    @GetMapping("/rating")
    public ResponseEntity<List<ActorDTO>> getActorWithRatingAfterThan(@RequestParam Double rating){
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getAutorsWithRatingAfterThan(rating));
    }

    @GetMapping("/movie")
    public ResponseEntity<List<ActorDTO>> getActorByMovie(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getActorActorByMovie(name));
    }
}
