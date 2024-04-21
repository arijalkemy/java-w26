package com.example.Sports.controllers;

import com.example.Sports.dto.PersonDTO;
import com.example.Sports.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    private IPerson personService;

    @GetMapping("/findPeople")
    public ResponseEntity<List<PersonDTO>> getPeople() {
        return ResponseEntity.ok(personService.getPeople());
    }

}
