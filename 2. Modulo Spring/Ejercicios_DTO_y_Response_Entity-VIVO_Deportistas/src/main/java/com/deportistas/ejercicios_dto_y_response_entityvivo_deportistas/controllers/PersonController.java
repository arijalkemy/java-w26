package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.controllers;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.dto.PersonDTO;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.IPersonService;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.sportimpl.PersonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personSport")
public class PersonController {

    @Autowired
    IPersonService person;

    @GetMapping
    public PersonDTO getPersonSport(){
        return person.getPersonSport();
    }
}
