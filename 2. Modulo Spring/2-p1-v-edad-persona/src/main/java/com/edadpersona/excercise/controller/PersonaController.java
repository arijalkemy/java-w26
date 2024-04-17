package com.edadpersona.excercise.controller;

import com.edadpersona.excercise.service.impl.IPersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaServiceImpl personaServiceImpl;

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public ResponseEntity<String> getEdadPersona(@PathVariable Integer dia,
                                                 @PathVariable Integer mes,
                                                 @PathVariable Integer anio) {

        Integer edad;

        try {
            edad = personaServiceImpl.obtenerEdadDePersona(anio, dia, mes);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(edad.toString(), HttpStatus.OK);
    }
}
