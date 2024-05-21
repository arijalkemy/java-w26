package com.example.movies_db.controller;

import com.example.movies_db.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {
    private final IActorService actorService;

    @GetMapping
    public ResponseEntity<?> getAllActors()
    {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getAllActors());
    }
}
