package org.example.personajesdestarwars.controller;

import org.example.personajesdestarwars.dto.CharacterDTO;
import org.example.personajesdestarwars.service.ICharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersController {
    @Autowired
    ICharactersService charactersService;

    @GetMapping("/{name}")
    ResponseEntity<List<CharacterDTO>> findCharacters(@PathVariable String name) throws IOException {
        return new ResponseEntity<>(charactersService.getCharactersByPartOfTheirName(name),HttpStatus.OK);
    }
}
