package com.example.moviesHQL.controller;

import com.example.moviesHQL.dto.ActorDTO;
import com.example.moviesHQL.dto.ActorResponseDTO;
import com.example.moviesHQL.model.Actor;
import com.example.moviesHQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    IActorService actorService;

    @GetMapping("/movies")
    public ResponseEntity<List<ActorResponseDTO>> getAllActors(){
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @PostMapping("/movies")
    public ResponseEntity<String> createActor(@RequestBody ActorDTO actor){
        actorService.saveActor(actor);
        return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
    }
}
