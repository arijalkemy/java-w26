package org.ggomezr.obteneredadpersona.controller;

import org.ggomezr.obteneredadpersona.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("{day}/{month}/{year}")
    public String calculateAge(@PathVariable int day,
                            @PathVariable int month,
                            @PathVariable int year){

        return personService.calculateAge(day, month, year);
    }
}
