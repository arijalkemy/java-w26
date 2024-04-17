package com.spring.starwars.controller;

import com.spring.starwars.dto.StarWarsCharacterDTO;
import com.spring.starwars.service.StarWarsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController() {
        this.starWarsService = new StarWarsService();
    }

    @GetMapping("/{name}")
    public List<StarWarsCharacterDTO> searchStarWarsCharacter(@PathVariable String name) {
        return starWarsService.searchStarWarsCharacter(name);
    }

}
