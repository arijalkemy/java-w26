package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class CharacterController {

    @Autowired
    ICharacterService characterService;

    @GetMapping("{substring}")
    public ResponseEntity<List<CharacterDTO>> getCharacterByName(@PathVariable String substring) {
        return new ResponseEntity<>(characterService.getCharacterByName(substring), HttpStatus.OK);
    }

}
