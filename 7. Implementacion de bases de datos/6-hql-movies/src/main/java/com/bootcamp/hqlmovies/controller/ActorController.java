package com.bootcamp.hqlmovies.controller;

import com.bootcamp.hqlmovies.model.dto.ActorDTO;
import com.bootcamp.hqlmovies.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }
    // Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/withFavoriteMovie")
    // To do: Replace with ResponseDTO
    public ResponseEntity<List<ActorDTO>> getAllActorsWithAFavoriteMovie() {
        List<ActorDTO> actors = actorService.getAllActorsWithAFavoriteMovie();
        return ResponseEntity.ok(actors);
    }

    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/withRatingGt")
    public ResponseEntity<List<ActorDTO>> getAllActorsWithRatingGreaterThan(@RequestParam Double value){
        List<ActorDTO> actors = actorService.getAllActorsWithRatingGreaterThan(value);
        return ResponseEntity.ok(actors);
    }

    // Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/inMovie")
    public ResponseEntity<List<ActorDTO>> getAllActorsInMovie(@RequestParam String title){
        List<ActorDTO> actors = actorService.getAllActorsInMovie(title);
        return ResponseEntity.ok(actors);
    }
}
