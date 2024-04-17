package com.javabootcamp.apiedad.controller;

import com.javabootcamp.apiedad.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class AgeController {

    @Autowired
    private AgeService ageService;

    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public String calcEdad(@PathVariable int dia,@PathVariable int mes, @PathVariable int anio) throws ParseException {
        return "Tienes: "+ ageService.calculateAge(dia,mes,anio)+" años";
    }
}
