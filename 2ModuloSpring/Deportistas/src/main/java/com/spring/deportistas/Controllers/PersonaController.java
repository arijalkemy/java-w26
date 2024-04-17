package com.spring.deportistas.Controllers;

import com.spring.deportistas.Models.dtos.PersonaDto;
import com.spring.deportistas.Services.Interfaces.IPersonaService;
import com.spring.deportistas.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    IPersonaService personaService;

    @GetMapping("/findSportPersons")
    public ResponseEntity<List<PersonaDto>> findSportsPersons(){
        return new ResponseEntity<>(personaService.getAllWithDeportes(), HttpStatus.OK);
    }



}
