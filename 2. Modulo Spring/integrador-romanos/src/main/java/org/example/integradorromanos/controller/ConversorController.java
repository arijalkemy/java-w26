package org.example.integradorromanos.controller;

import org.example.integradorromanos.service.ConversorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversorController {

    @Autowired
    ConversorServiceImp conversorServiceImp;

    @GetMapping("/roman/{decimal}")
    public String convertToRoman(@PathVariable int decimal){
        return conversorServiceImp.convertToRoman(decimal);
    }

}
