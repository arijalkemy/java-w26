package com.example._05_covid19.controller;

import com.example._05_covid19.model.DTO.PersonaConSintomaDTO;
import com.example._05_covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public ResponseEntity<List<PersonaConSintomaDTO>> obtenerPersonasConSintomas(){
        List<PersonaConSintomaDTO> personasDeRiesgo = iPersonaService.obtenerGrupoDeRiesgo();

        if(personasDeRiesgo.size()==0)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(personasDeRiesgo, HttpStatus.OK);
    }

}
