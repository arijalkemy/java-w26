package com.mercadolibre.moviesHQL.controller;

import com.mercadolibre.moviesHQL.model.entity.Actor;
import com.mercadolibre.moviesHQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping("/favorite")
    public ResponseEntity<List<Actor>> findAllByWorkingInMovie() {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.findAllByFavorite_movie_idIsNotEmpty());
    }

    @GetMapping("/movie/{number}")
    public ResponseEntity<List<Actor>> findAllByWorkingInMovie(@PathVariable Integer number) {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.findAllByWorkingInMovie(number));
    }

    @GetMapping("/rating/{number}")
    public ResponseEntity<List<Actor>> findAllByRatingGreaterThan(@PathVariable Double number) {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.findAllByRatingGreaterThan(number));
    }
}
