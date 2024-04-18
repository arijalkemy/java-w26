package com.solution.exerciseromannumbers.controllers;

import com.solution.exerciseromannumbers.services.IDecimalToRomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberSystemTranslator {

    @Autowired
    IDecimalToRomanService decimalToRomanService;

    @GetMapping("/{decimalNumber}")
    public String toRomanFromDecimal(@PathVariable Integer decimalNumber) {
        return decimalToRomanService.convertDecimalToRoman(decimalNumber);
    }
}
