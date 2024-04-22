package com.spring.numerosromanos.controller;

import com.spring.numerosromanos.service.INumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @Autowired
    INumerosRomanosService numerosRomanosService;

    @GetMapping("/{decimal}")
    public String numerosRomanos(@PathVariable int decimal) {
        return this.numerosRomanosService.decimalToRoman(decimal);
    }

}
