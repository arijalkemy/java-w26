package com.example._06_starwars.controller;

import com.example._06_starwars.dto.PersonajeDTO;
import com.example._06_starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    IPersonajeService iPersonajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajes(){
        List<PersonajeDTO> personajeDTOS = iPersonajeService.obtenerPersonajes();

        if(personajeDTOS.size() == 0)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(personajeDTOS, HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajes(@PathVariable String nombre){
        List<PersonajeDTO> personajeDTOS = iPersonajeService.obtenerPersonajesPorNombre(nombre);

        if(personajeDTOS.size() == 0)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(personajeDTOS, HttpStatus.OK);
    }

}
