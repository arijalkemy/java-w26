package org.example.starwars.controller;

import org.example.starwars.dto.StarWarCharacterDTO;
import org.example.starwars.service.IStarWarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    IStarWarService starWarServiceImp;
    @GetMapping
    ResponseEntity<List<StarWarCharacterDTO>>getAllCharacters(){
        return starWarServiceImp.getAllPersonajes();
    }
}
