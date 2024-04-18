package com.deportistas.deportistademo.controller;

import com.deportistas.deportistademo.dto.ResponsePersonDto;
import com.deportistas.deportistademo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<ResponsePersonDto>> getAllDeportist(){
        List<ResponsePersonDto> response = personService.getDeportist();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
