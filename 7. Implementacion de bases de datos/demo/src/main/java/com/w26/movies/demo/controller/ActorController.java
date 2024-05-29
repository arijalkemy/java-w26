package com.w26.movies.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.movies.demo.service.interfaces.IActorService;


@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    IActorService actorService;

    @GetMapping("/with_favorite_movie")
    public ResponseEntity<?> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok().body(actorService.findActorsByNotNullFavoriteMoview());
    }

    @GetMapping("")
    public ResponseEntity<?> getAllActors() {
        return ResponseEntity.ok().body(actorService.findAll());
    }

    @GetMapping("/with_superior_rating/{rating}")
    public ResponseEntity<?> getSuperiorRating(@PathVariable BigDecimal rating) {
        return ResponseEntity.ok().body(actorService.findBySuperiorRatingThan(rating));
    }
    
}
