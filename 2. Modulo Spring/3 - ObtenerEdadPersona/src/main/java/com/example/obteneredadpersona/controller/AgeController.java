package com.example.obteneredadpersona.controller;

import com.example.obteneredadpersona.services.IAgeCalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    @Autowired
    IAgeCalculatorServices ageCalculatorServices;

    @GetMapping(path = "{day}/{month}/{year}")
    public String calculateAge(@PathVariable int day,
                               @PathVariable int month,
                               @PathVariable int year) {

        String edad = ageCalculatorServices.calculateAge(day, month, year);
        return edad;
    }
}
