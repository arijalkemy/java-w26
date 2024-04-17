package com.practicaSpring.starWars.controller;

import com.practicaSpring.starWars.dto.CharacterDTO;
import com.practicaSpring.starWars.service.CharacterServiceImpl;
import com.practicaSpring.starWars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private ICharacterService personajeService;

    @GetMapping("/find")
    public ResponseEntity<List<CharacterDTO>> getCharactersWithMatchingNames(@RequestParam String name){
        List<CharacterDTO> resp = personajeService.matchName(name);
        if(resp != null){
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.internalServerError().build();
    }
}