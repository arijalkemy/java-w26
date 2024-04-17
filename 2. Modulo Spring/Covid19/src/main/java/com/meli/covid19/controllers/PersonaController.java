package com.meli.covid19.controllers;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.services.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    IPersona personaService;

    @GetMapping("/obtenerperonasconriedgo")
    public ResponseEntity<List<PersonaDTO>> obtenerPeronasConRiedgo(){
        List<PersonaDTO> result = personaService.personasEnRiesgo();
        if(result.size()==0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
