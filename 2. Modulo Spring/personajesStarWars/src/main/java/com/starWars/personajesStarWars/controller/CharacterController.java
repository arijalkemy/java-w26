package com.starWars.personajesStarWars.controller;

import com.starWars.personajesStarWars.dto.CharacterDTO;
import com.starWars.personajesStarWars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private ICharacterService service;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }
}
