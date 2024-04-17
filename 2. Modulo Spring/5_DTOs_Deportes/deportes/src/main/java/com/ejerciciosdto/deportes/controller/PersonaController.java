package com.ejerciciosdto.deportes.controller;


import com.ejerciciosdto.deportes.dto.PersonaDTO;
import com.ejerciciosdto.deportes.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    IPersona servicepersona;
    @GetMapping(path = "/findSportPersons")
    @ResponseBody
    public List<PersonaDTO> findSportPersons() {
        return servicepersona.getPersonsAndSports();
    }
}
