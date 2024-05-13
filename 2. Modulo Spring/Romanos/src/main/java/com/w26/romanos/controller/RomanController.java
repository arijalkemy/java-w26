package com.w26.romanos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.romanos.service.IRomanConversionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/conversor")
public class RomanController {

    @Autowired
    private IRomanConversionService romanConversionService;

    @GetMapping("/decimal_to_roman/{decimal_number}")
    public ResponseEntity<?> getDecimalToRoman(@PathVariable("decimal_number") Integer decimalNumber) {
        return ResponseEntity.ok().body(romanConversionService.decimalToRoman(decimalNumber));
    }

    @GetMapping("/roman_to_decimal/{roman_number}")
    public ResponseEntity<?> getRomanToDecimal(@PathVariable("roman_number") String romanNumber) {
        return ResponseEntity.ok().body(romanConversionService.romanToDecimal(romanNumber));
    }
}
