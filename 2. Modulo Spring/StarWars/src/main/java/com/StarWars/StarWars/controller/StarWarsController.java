package com.StarWars.StarWars.controller;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.StarWars.StarWars.entity.Personaje;
import com.StarWars.StarWars.services.IStarWarsService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    private IStarWarsService _starWarsService;

    @GetMapping("")
    ResponseEntity<?> obtenerPersonajes() {
        try {
            List<PersonajeDTO> listPersonajes = _starWarsService.obtenerPersonajes();
            return new ResponseEntity<>(listPersonajes, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{nombre}")
    ResponseEntity<?> buscarPersonajes(@PathVariable String nombre)
    {
        List<Personaje> listaPersonaje = _starWarsService.buscarPersonajes(nombre);
        return  new ResponseEntity<>(listaPersonaje,HttpStatus.OK);
    }
}
