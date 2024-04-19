package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.model.Personaje;
import com.example.starwars.service.IPersonajeService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/starwars")
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;


    @GetMapping("/personaje/{nombre}")
    public ResponseEntity obtenerPersonaje(@PathVariable String nombre){
        PersonajeDto personajeDto = personajeService.obtenerPersonaje(nombre);

        if( personajeDto == null ){
            return new ResponseEntity("No se encontró", HttpStatus.OK);
        }

        return new ResponseEntity(personajeDto, HttpStatus.OK);
    }

    @PostMapping("/personaje")
    public void crearPersonajes(@RequestBody List<Personaje> personajes) {
        personajeService.crearPersonajes(personajes);

    }

}
