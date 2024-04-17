package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.INumbersService;

@RestController
@RequestMapping("/")
public class numbersController {

    @Autowired
    INumbersService numbersService;

    @GetMapping("/{decimalNumber}")
    public String convertion(@PathVariable int decimalNumber){
        return numbersService.convertToRoman(decimalNumber);
    }
}
