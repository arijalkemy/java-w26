package com.datecalculator.exerciseage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.datecalculator.exerciseage.services.IDateCalculatorService;

@RestController
public class DateCalculatorController {
    @Autowired
    IDateCalculatorService dateCalculatorService;

    @GetMapping("/{day}/{month}/{year}")
    public Integer calculateAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return dateCalculatorService.calculateAge(day, month, year);
    }
}
