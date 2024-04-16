package com.ej1p1.personage.controllers;

import com.ej1p1.personage.services.IAgeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PersonAgeController {

    @Autowired
    public IAgeCalculator ageCalculatorService;

    @GetMapping("/{day}/{month}/{year}")
    public int GetAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return ageCalculatorService.calculateAge(day, month, year);
    }
}
