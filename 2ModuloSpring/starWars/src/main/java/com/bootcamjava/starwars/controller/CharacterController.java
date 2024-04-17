package com.bootcamjava.starwars.controller;

import com.bootcamjava.starwars.dto.CharacterDTO;
import com.bootcamjava.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    ICharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getByName(@PathVariable String name){
        return ResponseEntity.ok(characterService.findCharacterByName(name));
    }
}
