package org.mercadolibre.multicapatemplate.controller;

import jakarta.websocket.server.PathParam;
import org.mercadolibre.multicapatemplate.dto.CharacterResponseDTO;
import org.mercadolibre.multicapatemplate.service.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    final ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<List<CharacterResponseDTO>> findAll(){
        return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{partialName}")
    public ResponseEntity<List<CharacterResponseDTO>> findAll(@PathVariable String partialName){
        return new ResponseEntity<>(characterService.findAllWith(partialName), HttpStatus.OK);
    }
}
