package com.example.ejercicionumerosromanos.controller;

import com.example.ejercicionumerosromanos.service.IRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roman")
public class RomanosController {

    @Autowired
    IRomanosService romanosService;

    @GetMapping("/convert/{number}")
    public String convert(@PathVariable String number ){
        return "Romano: " + number + " Decimal: " + romanosService.convertToDecimal(number);
    }
}
