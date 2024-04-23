package org.bootcamp.starwars.controller;

import org.bootcamp.starwars.dto.CharacterDTO;
import org.bootcamp.starwars.service.IFindCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    IFindCharacterService findCharacterService;

    @GetMapping("/starwars")
    public String getStarWars() {
        return "Star Wars";
    }

    @GetMapping("/starwars/{query}")
    public List<CharacterDTO> getStarWarsCharacters(@PathVariable String query) {
        return findCharacterService.findCharactersByContains(query);
    }
}
