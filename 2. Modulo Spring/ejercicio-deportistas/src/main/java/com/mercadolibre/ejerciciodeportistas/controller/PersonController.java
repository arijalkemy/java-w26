package com.mercadolibre.ejerciciodeportistas.controller;

import com.mercadolibre.ejerciciodeportistas.model.dto.SportPersonDTO;
import com.mercadolibre.ejerciciodeportistas.service.IPersonService;
import com.mercadolibre.ejerciciodeportistas.service.imp.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping(path = "findSportsPersons")
    private ResponseEntity<List<SportPersonDTO>> findSportsPersons() {
        return ResponseEntity.ok(personService.findAll());
    }
}
