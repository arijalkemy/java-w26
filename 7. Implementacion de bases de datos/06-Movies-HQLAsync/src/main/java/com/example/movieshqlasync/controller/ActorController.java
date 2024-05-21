package com.example.movieshqlasync.controller;

import com.example.movieshqlasync.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    IActorService iActorService;

    @GetMapping()
    public ResponseEntity<?> getActorsWithFavoriteMovie(){
        return new ResponseEntity<>(iActorService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getActorsWithHighRating(@PathVariable Double rating){
        return new ResponseEntity<>(iActorService.getActorsWithHighRating(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getActorsByMovieTheyWorked(@PathVariable Integer movieId){
        return new ResponseEntity<>(iActorService.getActorsByMovie(movieId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActorById(@PathVariable Integer id){
        return new ResponseEntity<>(iActorService.getActorById(id), HttpStatus.OK);
    }

}
