package org.example.star_wars.controller;

import org.example.star_wars.dto.CharacterDTO;
import org.example.star_wars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CharacterController {
    @Autowired
    ICharacterService characterService;

    @GetMapping("character/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharactersByName(@PathVariable String name){
        return ResponseEntity.ok(characterService.findByName(name));
    }
    @GetMapping("characters/")
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(){
        return ResponseEntity.ok(characterService.findAll());
    }

}
