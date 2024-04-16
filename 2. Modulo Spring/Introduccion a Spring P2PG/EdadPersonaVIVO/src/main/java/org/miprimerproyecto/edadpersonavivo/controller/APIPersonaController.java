package org.miprimerproyecto.edadpersonavivo.controller;

import org.miprimerproyecto.edadpersonavivo.services.AgeCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIPersonaController {

    @GetMapping(path = "{day}/{month}/{year}")
    public String getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return "Hola humano, tu tienes "+ AgeCalculator.calculateAge(day, month, year) +" años";
    }

}
