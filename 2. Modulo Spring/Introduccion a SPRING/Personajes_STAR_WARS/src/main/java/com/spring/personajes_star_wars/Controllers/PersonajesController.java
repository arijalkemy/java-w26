package com.spring.personajes_star_wars.Controllers;

import com.spring.personajes_star_wars.Dtos.PersonajeDto;
import com.spring.personajes_star_wars.Models.Personaje;
import com.spring.personajes_star_wars.Services.PersonajeService.IPersonajesService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajesController {

    @Autowired
    private IPersonajesService personajesService;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDto>> findPersonajes(@PathVariable String nombre){
        List<PersonajeDto> personajeDtos = personajesService.findPersonajes(nombre);
        return new ResponseEntity<>(personajeDtos, HttpStatus.OK);
    }
}
