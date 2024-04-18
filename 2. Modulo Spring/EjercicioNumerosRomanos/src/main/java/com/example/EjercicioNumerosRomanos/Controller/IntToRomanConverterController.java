package com.example.EjercicioNumerosRomanos.Controller;

import com.example.EjercicioNumerosRomanos.Service.IntToRomanConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntToRomanConverterController {

    @Autowired
    private IntToRomanConverterService intToRomanConverterService;

    @GetMapping("convert/{num}")
    public String convertIntToRoman(@PathVariable int num) {
        return intToRomanConverterService.convertIntToRoman(num);
    }

}
