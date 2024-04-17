package com.example.deportista.controller;

import com.example.deportista.dto.PersonaDTO;
import com.example.deportista.service.persona.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    IPersonaService personaService;
    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getPersonas(){
        return personaService.getPersonas();
    }
}
