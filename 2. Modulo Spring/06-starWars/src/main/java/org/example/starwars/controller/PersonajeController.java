package org.example.starwars.controller;

import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.model.Personaje;
import org.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(@PathVariable String name) {
        ResponseEntity<List<PersonajeDTO>> response;
        try {
            List<PersonajeDTO> personajeDTO = personajeService.buscarPersonajes(name);
            if (personajeDTO.isEmpty()) {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                response = ResponseEntity.ok(personajeDTO);
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

}
