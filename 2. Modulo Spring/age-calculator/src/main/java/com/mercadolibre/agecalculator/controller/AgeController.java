package com.mercadolibre.agecalculator.controller;

import com.mercadolibre.agecalculator.service.IAgeService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {

    @Autowired
    IAgeService ageService;

    @GetMapping(path = "{day}/{month}/{year}")
    public Integer age(
            @PathVariable @Positive int day,
            @PathVariable @Positive int month,
            @PathVariable @Positive int year
    ) {

        return this.ageService.calculateAge(day, month, year);
    }
}
