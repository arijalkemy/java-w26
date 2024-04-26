package org.example.personajesdestarwars.controller;

import org.example.personajesdestarwars.dto.CharacterDTO;
import org.example.personajesdestarwars.service.ICharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersController {
    @Autowired
    ICharactersService charactersService;

    @GetMapping
    ResponseEntity<List<CharacterDTO>> findCharacters(@RequestParam String name) throws IOException {
        return new ResponseEntity<>(charactersService.getCharactersByPartOfTheirName(name),HttpStatus.OK);
    }
}
