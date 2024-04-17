package com.example.EjercicioDeporte.controller;

import com.example.EjercicioDeporte.dto.PersonaDTO;
import com.example.EjercicioDeporte.service.IPersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/deportistas")
    public ResponseEntity<List<PersonaDTO>> buscarPersonasDeportistas() {

        return ResponseEntity.ok(personaService.buscarPersonasDeportistas());
    }
}
