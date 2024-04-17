package com.example.personajesStarWars.controller;


import com.example.personajesStarWars.dto.PersonaDTO;
import com.example.personajesStarWars.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personajes/v1/")
public class PersonaController {


    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("buscar")
    public List<PersonaDTO> buscarPersonaje(@RequestParam String nombre){
        return iPersonaService.buscarPersonajes(nombre);
    }
}
