package com.example.numerosromanos.controllers;

import com.example.numerosromanos.service.serviceimp.INumerosRomanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NumerosRomanosController {
    @Autowired
    INumerosRomanos numerosRomanosService;

    @GetMapping("/{decimal}")
    public String convertirDecimalARomanos(@PathVariable int decimal) {
        return numerosRomanosService.convertirDecimalARomanos(decimal);
    }
}
