package org.example.deportistas.controllers;

import org.example.deportistas.models.Deportes;
import org.example.deportistas.models.dtos.DeportistasResponseDTO;
import org.example.deportistas.services.IDeportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DeporteController {
    @Autowired
    IDeportes deportesService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deportes>> findSports() {
        return ResponseEntity.ok().body(deportesService.findSports());
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deportes> findSport(@PathVariable String name) {
        return ResponseEntity.ok().body(deportesService.findSport(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistasResponseDTO>> findSportsPersons(){
        return ResponseEntity.ok().body(deportesService.findSportsPerson());
    }


}
