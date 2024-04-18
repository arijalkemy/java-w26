package org.covid19.covid19.controladores;

import org.covid19.covid19.dto.PersonaDto;
import org.covid19.covid19.entidades.Persona;
import org.covid19.covid19.servicios.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findRiskPerson")
public class PersonaController {

    @Autowired
    IPersonaServicio personaServicio;

    @GetMapping
    public ResponseEntity<List<PersonaDto>> getPersonasDeRiesgo(){
       return ResponseEntity.ok(personaServicio.obtenerPersonasDeRiesgo());
    }
}
