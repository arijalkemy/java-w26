package com.mercadolibre.CharacterStarWarsAPI.controller;

import com.mercadolibre.CharacterStarWarsAPI.dto.CharacterDTO;
import com.mercadolibre.CharacterStarWarsAPI.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWars/v1")
public class CharacterController {
    @Autowired
    private ICharacterService characterService;

    @GetMapping("/{name}")
    public List<CharacterDTO> getAllCharacters(@PathVariable String name){
        return characterService.findAllByNameContains(name);
    }
}
