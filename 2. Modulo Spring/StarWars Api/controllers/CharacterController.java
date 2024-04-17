package org.example.starwars.controllers;

import org.example.starwars.dto.CharacterDto;
import org.example.starwars.services.ICharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class            CharacterController {
    private final ICharacter iCharacter;

    public CharacterController(@Autowired ICharacter iCharacter) {
        this.iCharacter = iCharacter;
    }

    @GetMapping("/")
    public ResponseEntity<List<CharacterDto>> getListCharacter(@RequestParam(defaultValue = "") String search) {
        return ResponseEntity.ok(this.iCharacter.getCharacters(search));
    }
}