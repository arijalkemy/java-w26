package org.example.ArabicToRomanConverter.controllers;

import org.example.ArabicToRomanConverter.services.IromanConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class RomanConverterController {

    @Autowired
    IromanConverterService romanConverter;

    @GetMapping("/{number}")
    public String convertToRoman(@PathVariable Integer number){
        return  romanConverter.convertToRoman(number);
    }

}
