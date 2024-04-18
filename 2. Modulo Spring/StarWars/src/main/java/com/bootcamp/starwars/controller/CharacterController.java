package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.Service.Interfaces.ICharacterService;
import com.bootcamp.starwars.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    ICharacterService characterService;

    @GetMapping("/{name}")
    public List<CharacterDTO> getCharacterByName(@PathVariable String name){
        return characterService.getCharacterByName(name);
    }

}
