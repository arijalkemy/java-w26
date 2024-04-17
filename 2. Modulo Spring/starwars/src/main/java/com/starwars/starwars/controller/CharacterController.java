package com.starwars.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.starwars.dto.CharacterResponseDto;
import com.starwars.starwars.service.ICharacterService;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    ICharacterService characterService;

    @GetMapping("/{name}") 
    public ResponseEntity<List<CharacterResponseDto>> findByName(@PathVariable String name){
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }
    
}