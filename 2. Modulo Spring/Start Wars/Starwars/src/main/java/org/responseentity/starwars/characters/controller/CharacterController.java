package org.responseentity.starwars.characters.controller;

import org.responseentity.starwars.characters.dto.CharacterDTO;
import org.responseentity.starwars.characters.service.CharacterService;
import org.responseentity.starwars.characters.service.CharacterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/{characterName}")
    public ResponseEntity<List<CharacterDTO>> findCharacterByName(@PathVariable("characterName") String characterName){
        return new ResponseEntity<>(characterService.findCharacterByName(characterName), HttpStatus.OK);
    }
}
