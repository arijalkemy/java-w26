package com.starwars.personajes.controller;

import com.starwars.personajes.dto.CharacterDTO;
import com.starwars.personajes.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/findCharacters/{name}")
    public List<CharacterDTO> getCharactersByName(@PathVariable String name) {
        return characterService.getCharactersByName(name);
    }
}
