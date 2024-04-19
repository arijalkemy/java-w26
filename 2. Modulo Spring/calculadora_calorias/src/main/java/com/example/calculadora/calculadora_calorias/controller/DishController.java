package com.example.calculadora.calculadora_calorias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {
    @GetMapping
    public String ping(){
        return "pong";
    }
}
