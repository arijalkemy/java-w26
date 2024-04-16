package com.ejercicio.edadpersona.controllers;

import com.ejercicio.edadpersona.services.interfaces.IPersonAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAgeController {

    @Autowired
    IPersonAgeService personAgeService;

    @GetMapping("/{day}/{month}/{year}")
    public int calculateAge(@PathVariable int day,
                            @PathVariable int month,
                            @PathVariable int year) {

        return personAgeService.calculateAge(day, month, year);
    }
}
