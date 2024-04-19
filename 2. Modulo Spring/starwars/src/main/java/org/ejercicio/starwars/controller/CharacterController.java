package org.ejercicio.starwars.controller;

import org.ejercicio.starwars.dto.CharacterDTO;
import org.ejercicio.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    ICharacterService characterService;

    @GetMapping("{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacters(@PathVariable String name) {
        List<CharacterDTO> characterDTOS = characterService.findAllCharactersByName(name);
        if(characterDTOS.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(characterDTOS, HttpStatus.OK);
    }
}
