package com.example.numerosRomanos.controller;

import com.example.numerosRomanos.service.INumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @Autowired
    private INumerosRomanosService numerosRomanosService;

    @GetMapping("/convert/{decimal}")
    public String convertToRoman(@PathVariable int decimal) {
        return numerosRomanosService.convertToRoman(decimal);
    }
}
