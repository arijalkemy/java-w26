package org.miprimerproyecto.starwarsvivo.controller;

import org.miprimerproyecto.starwarsvivo.dto.PersonaDTO;
import org.miprimerproyecto.starwarsvivo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping (path="/person/{name}")
    @ResponseBody
    public List<PersonaDTO> getPersona (@PathVariable String name) {
        return this.personaService.findAll(name);
    }
}
