package org.ggomezr.deportistas.application.controller;

import org.ggomezr.deportistas.application.service.impl.PersonaService;
import org.ggomezr.deportistas.domain.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons(){
        List<PersonaDTO> deportistas = personaService.findSportsPersons();
        if(!deportistas.isEmpty()) return new ResponseEntity<>(deportistas, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
