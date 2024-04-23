package com.mercadolibre.DeportistasAPI.controller;

import com.mercadolibre.DeportistasAPI.DTO.PersonaDTO;
import com.mercadolibre.DeportistasAPI.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/personas")
public class PersonaController {
    @Autowired
    IPersonaService personaService;
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> visualizarDeportistas() {
        List<PersonaDTO> deportistas = personaService.visualizarDeportistas();
        return ResponseEntity.status(HttpStatus.OK).body(deportistas);
    }
}
