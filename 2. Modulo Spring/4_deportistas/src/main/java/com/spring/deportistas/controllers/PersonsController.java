package com.spring.deportistas.controllers;

import com.spring.deportistas.models.dto.PersonSportDTO;
import com.spring.deportistas.services.IPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {

    private final IPersonsService personsService;

    @Autowired
    public PersonsController(IPersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/findSportsPersons")
    public List<PersonSportDTO> getAllSportsPersons() {
        return personsService.getAllPersonsSports();
    }

}
