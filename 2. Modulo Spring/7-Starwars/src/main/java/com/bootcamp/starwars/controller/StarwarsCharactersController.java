package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.StarWarsCharacterDTO;
import com.bootcamp.starwars.service.ICharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWarsCharacters")
public class StarwarsCharactersController {
    @Autowired
    ICharactersService charactersService;

    @GetMapping
    public List<StarWarsCharacterDTO> findCharacterByText(@RequestParam String searchText) {
        return charactersService.findCharacter(searchText);
    }
}
