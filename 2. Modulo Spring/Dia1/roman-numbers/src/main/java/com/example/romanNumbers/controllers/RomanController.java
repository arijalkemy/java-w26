package com.example.romanNumbers.controllers;

import com.example.romanNumbers.services.implementations.DecimalToRomanConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {

    @Autowired
    private DecimalToRomanConverterImpl converter;

    @GetMapping("/convert/roman/{number}")
    public String convertToRoman(@PathVariable int number) {
        return converter.convertToRoman(number);
    }
}
