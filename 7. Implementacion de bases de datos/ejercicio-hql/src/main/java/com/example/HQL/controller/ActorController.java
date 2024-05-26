package com.example.HQL.controller;

import com.example.HQL.dto.response.ActorResponseDto;
import com.example.HQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping("/has-favorite-movie")
    public ResponseEntity<List<ActorResponseDto>> getAllActorsThatHaveFavoriteMovie() {
        return new ResponseEntity<>(
            actorService.searchAllThatHaveFavoriteMovie(),
            HttpStatus.OK
        );
    }

    @GetMapping("/rating-above/{rating}")
    public ResponseEntity<List<ActorResponseDto>> getAllActorsWithRatingAbove(
        @PathVariable Integer rating
    ) {
        return new ResponseEntity<>(
            actorService.searchAllWithRatingAbove(rating),
            HttpStatus.OK
        );
    }

    @GetMapping("/working-in-movie/{title}")
    public ResponseEntity<List<ActorResponseDto>> getAllActorsWorkingInMovie(
        @PathVariable String title
    ) {
        return new ResponseEntity<>(
            actorService.searchAllWorkingInMovie(title),
            HttpStatus.OK
        );
    }
}
