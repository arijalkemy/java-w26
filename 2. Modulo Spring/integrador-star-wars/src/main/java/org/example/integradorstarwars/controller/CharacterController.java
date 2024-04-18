package org.example.integradorstarwars.controller;

import org.example.integradorstarwars.dto.CharacterDTO;
import org.example.integradorstarwars.service.impl.CharacterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final CharacterServiceImp characterServiceImp;

   @Autowired
   public CharacterController(CharacterServiceImp characterServiceImp){
        this.characterServiceImp = characterServiceImp;
   }

    @GetMapping("/star/findByName/{name}")
    @ResponseBody
    public ResponseEntity<List<CharacterDTO>> findByName(@PathVariable String name) throws IOException {

        return new ResponseEntity<>(characterServiceImp.findByName(name), HttpStatus.OK);
    }

}
