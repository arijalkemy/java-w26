package com.demospring.practicahql.controller;

import com.demospring.practicahql.model.Actor;
import com.demospring.practicahql.service.IActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/actor")
@AllArgsConstructor
public class ActorCotroller {
    private final IActorService actorService;

    @GetMapping
    public ResponseEntity<?> getAllActorsWithOneFavoriteMovie() {
        return new ResponseEntity<>(actorService.findActorsWithOneFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getAllActorsByRatingOver(@PathVariable double rating) {
        return new ResponseEntity<>(actorService.findActorsByRatingOver(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<?> getAllActorsByMovieName(@PathVariable String title) {
        return new ResponseEntity<>(actorService.findActorsByMovieName(title), HttpStatus.OK);
    }
}
