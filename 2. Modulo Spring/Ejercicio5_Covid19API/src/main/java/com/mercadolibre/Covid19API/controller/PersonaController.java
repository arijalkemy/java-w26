package com.mercadolibre.Covid19API.controller;

import com.mercadolibre.Covid19API.DTO.PersonaDTO;
import com.mercadolibre.Covid19API.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/person")
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> visualizarGrupoDeRiesgo(){
        List<PersonaDTO> grupo = personaService.visualizarPersonasGrupoDeRiesgo();
        return ResponseEntity.status(HttpStatus.OK).body(grupo);
    }
}
