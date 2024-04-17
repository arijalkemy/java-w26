package com.example.starwars_vivo.controllers;

import com.example.starwars_vivo.dto.CharacterDTO;
import com.example.starwars_vivo.service.ICharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    ICharacter characterService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CharacterDTO>> getAll(){
        return new ResponseEntity<>(characterService.getAllCharacters(), HttpStatus.OK);
    }
    @GetMapping("/getCharacterByName/{name}")
    public  ResponseEntity<List<CharacterDTO>> getCharacterByName(@PathVariable String name){
        List<CharacterDTO> result = characterService.getCharacterByName(name);
        if(result.size()==0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
