package com.bootcamp.starwars.Controller;

import com.bootcamp.starwars.DTO.PersonajeDTO;
import com.bootcamp.starwars.Service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeRestController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajes(@PathVariable String nombre) {
        return ResponseEntity.ok(personajeService.buscarPorNombre(nombre));
    }


}
