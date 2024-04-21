package com.example.Sintomas.controller;

import com.example.Sintomas.dto.PersonAndSymptom;
import com.example.Sintomas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/getPeople")
    public ResponseEntity<List<PersonAndSymptom>> getPeopleGreatterThan60() {
        return ResponseEntity.ok(personService.getPeopleGreatterThan60());
    }

}
