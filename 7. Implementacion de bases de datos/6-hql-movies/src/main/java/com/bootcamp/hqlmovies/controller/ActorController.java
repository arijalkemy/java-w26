package com.bootcamp.hqlmovies.controller;

import com.bootcamp.hqlmovies.model.dto.ActorDTO;
import com.bootcamp.hqlmovies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private IActorService actorService;

    @GetMapping("/withAFavoriteMovie")
    // To do: Replace with ResponseDTO
    public ResponseEntity<List<ActorDTO>> getAllActorsWithAFavoriteMovie() {
        return ResponseEntity.ok(actorService.getAllActorsWithAFavoriteMovie());
    }
}
