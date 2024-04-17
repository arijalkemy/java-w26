package org.ggomezr.starwars.application.controller;

import org.ggomezr.starwars.application.service.impl.CharacterService;
import org.ggomezr.starwars.domain.dto.CharacterDTO;
import org.ggomezr.starwars.domain.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/getAllCharacters")
    public ResponseEntity<List<Character>> getAllCharacters() throws IOException {
        List<Character> characters = characterService.getAllCharacters();
        if(!characters.isEmpty()) return new ResponseEntity<>(characters, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getCharactersByName/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharactersByName(@PathVariable String name) throws IOException {
        List<CharacterDTO> characters = characterService.getCharactersByName(name);
        if(!characters.isEmpty()) return new ResponseEntity<>(characters, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
