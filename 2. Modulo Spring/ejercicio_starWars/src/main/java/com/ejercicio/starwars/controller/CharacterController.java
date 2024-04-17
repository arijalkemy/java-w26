package com.ejercicio.starwars.controller;

import com.ejercicio.starwars.DTO.CharactersResponseDTO;
import com.ejercicio.starwars.entity.Character;
import com.ejercicio.starwars.service.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ICharacterService characterService;

    @GetMapping("/{nameSubstring}")
    public ResponseEntity<?> findCharactersByName(@PathVariable String nameSubstring) {
        List<CharactersResponseDTO> result = characterService.findCharactersByName(nameSubstring);

        if(result.size() > 0) return ResponseEntity.status(200).body(result);
        else return ResponseEntity
                    .status(400)
                    .body("No se encontraron resultados para el nombre ingresado.");
    }
}
