package com.Ejercicio.StarWars.Controller;


import com.Ejercicio.StarWars.DTO.CharacterDTO;
import com.Ejercicio.StarWars.Entity.Character;
import com.Ejercicio.StarWars.Service.ICharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CharacterController {

    private final ICharacterService iCharacterService;

    @PostMapping(path = "save")
    public void saveCharacters(@RequestBody List<Character> requestCharactersList) {
        iCharacterService.saveCharacters(requestCharactersList);
    }

    @GetMapping(path = "getCharacters")
    public List<Character> getCharacters() {
        return iCharacterService.searchCharacters();
    }

    @GetMapping(path = "getCharacterBy")
    public Optional<?> getCharacterBy(@RequestParam String name){
        return Optional.ofNullable(iCharacterService.searchCharacterBy(name));
    }


}
