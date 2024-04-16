package com.demospring.covid19.controllers;

import com.demospring.covid19.dtos.PersonaConSintomaDTO;
import com.demospring.covid19.models.Sintoma;
import com.demospring.covid19.services.ISanatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SanatorioController {
    @Autowired
    ISanatorio sanatorioServices;

    @GetMapping(path = "/findSymptom")
    @ResponseBody
    public List<Sintoma> findSymptom() {
        return sanatorioServices.getSintomas();
    }

    @GetMapping(path = "/findSymptom/{codigo}")
    @ResponseBody
    public Sintoma findSymptom(@PathVariable int codigo) {
        return sanatorioServices.getSintoma(codigo);
    }

    @GetMapping(path = "/findRiskPerson")
    @ResponseBody
    public List<PersonaConSintomaDTO> findRiskPerson() {
        return sanatorioServices.getPersonasConSintomas();
    }
}
