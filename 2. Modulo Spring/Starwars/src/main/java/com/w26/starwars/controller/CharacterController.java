package com.w26.starwars.controller;

import com.w26.starwars.dto.CharacterDTO;
import com.w26.starwars.service.IFindCharacterService;
import com.w26.starwars.util.StarWarsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class CharacterController {

    private IFindCharacterService serviceFinder;

    public CharacterController(IFindCharacterService serviceFinder) {
        this.serviceFinder = serviceFinder;
    }

    @GetMapping("/findCharacters/{nameCharacter}")
    public List<CharacterDTO> getCharacter(@PathVariable String nameCharacter)
    {
        return serviceFinder.findCharacters(nameCharacter);
    }
}
