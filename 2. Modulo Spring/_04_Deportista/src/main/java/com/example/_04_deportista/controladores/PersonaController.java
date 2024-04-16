package com.example._04_deportista.controladores;

import com.example._04_deportista.model.DTO.PersonaDeportistaDTO;
import com.example._04_deportista.model.Persona;
import com.example._04_deportista.servicios.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    IPersonaService iPersona;

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public ResponseEntity<List<PersonaDeportistaDTO>> obtenerPersonas(){
        List<PersonaDeportistaDTO> personaDeportistaDTOS = iPersona.obtenerPersonas();

        if(personaDeportistaDTOS.size() == 0)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(personaDeportistaDTOS, HttpStatus.OK);
    }

}
