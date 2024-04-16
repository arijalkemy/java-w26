package com.ejerciciosdto.ejerciciocovid.controller;

import com.ejerciciosdto.ejerciciocovid.dto.PersonaDTO;
import com.ejerciciosdto.ejerciciocovid.servicio.ServicioPersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    ServicioPersonaImpl servicioPersona ;
    @GetMapping(path= "/personasEnRiesgo")
    @ResponseBody
    public List<PersonaDTO> getPersonaEnRiesgo(){
        return servicioPersona.getPersonaEnRiesgo();
    }
}
