package com.example.demo.controller;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starWars")
public class StarWarsController {

    private final IStarWarsService starWarsService;

    @Autowired
    public StarWarsController(IStarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/personaje/{nombre}")
    public List<PersonajeDTO> buscarPersonajes(@PathVariable("nombre") String nombre) {
        return starWarsService.buscarPersonajesPorNombre(nombre);
    }

}
