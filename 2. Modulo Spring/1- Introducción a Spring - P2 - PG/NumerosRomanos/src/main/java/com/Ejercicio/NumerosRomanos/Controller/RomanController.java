package com.Ejercicio.NumerosRomanos.Controller;

import com.Ejercicio.NumerosRomanos.Interface.RomanNumeralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {
    @Autowired
    RomanNumeralService romanNumeralService;

    @GetMapping("/convert/{number}")
    public String converToRoman(@PathVariable int number){
        return romanNumeralService.convertToRoman(number);
    }
}
