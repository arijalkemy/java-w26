package org.bootcamp.starwars.controller;

import org.bootcamp.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/")
    private ResponseEntity<?> getAllCharacters(){
        return ResponseEntity.ok(characterService.getAll());
    }

    @GetMapping("/{name}")
    private ResponseEntity<?> getByName(@PathVariable String name){
        return ResponseEntity.ok(characterService.getFindByName(name));
    }

}
