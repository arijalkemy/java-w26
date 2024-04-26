package com.Ejercicio.Deportistas.Controller;

import com.Ejercicio.Deportistas.Entity.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/PersonController")
public class PersonController {

    @Autowired
    IPerson iPerson;

    @GetMapping(path = "/getPersons")
    public List<PersonDTO> getPersons() {
        return iPerson.getPersons();
    }
}
