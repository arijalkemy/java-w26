package com.covi.covid_19.Controllers;

import com.covi.covid_19.Classes.Persona;
import com.covi.covid_19.DTO.PersonaSistemaDTO;
import com.covi.covid_19.Services.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final SistemaService sistemaService;

    @Autowired
    public PersonController(SistemaService sistemaService) {
        this.sistemaService = sistemaService;
    }

    @PostMapping("/addPerson")
    public ResponseEntity<String> agregarPersona(@RequestBody Persona persona) {
        try {
            sistemaService.agregarPersona(persona);
            return ResponseEntity.ok("Persona añadida correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findPersons")
    public List<Persona> conseguirTodasLasPersonas() {
        return sistemaService.conseguirTodasLasPersonas();
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaSistemaDTO> conseguirPersonasDeRiesgo() {
        return sistemaService.conseguirTodasLasPersonasDTO();
    }

}
