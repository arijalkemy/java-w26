package org.bootcamp.edadpersona.controller;

import org.springframework.web.bind.annotation.RestController;

import org.bootcamp.edadpersona.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AgeController {
    @Autowired private IAgeService ageService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String getAge(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return "La edad es: " + ageService.calculateAge(dia, mes, anio);
    }
}
