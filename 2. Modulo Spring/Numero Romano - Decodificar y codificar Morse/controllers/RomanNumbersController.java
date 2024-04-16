package org.example.apitest.controllers;

import org.example.apitest.services.IRomanNumber;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/roman")
public class RomanNumbersController {
    private final IRomanNumber romanNumber;

    public RomanNumbersController(@Qualifier("romanNumberImpl") IRomanNumber romanNumber) {
        this.romanNumber = romanNumber;
    }

    @GetMapping("/{number}")
    public Map<String, Object> RomanNumbersConvert(@PathVariable Integer number) {
        return Map.of("decimal", number, "roman", romanNumber.convertDecimalToRoman(number));
    }
}
