package org.ggomezr.covid19.application.controller;

import org.ggomezr.covid19.application.service.impl.PersonaService;
import org.ggomezr.covid19.domain.dto.PersonaRiesgoDTO;
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

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDTO>> findRiskPerson(){
        List<PersonaRiesgoDTO> personaRiesgo = personaService.findRiskPerson();
        if(!personaRiesgo.isEmpty()) return new ResponseEntity<>(personaRiesgo, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
