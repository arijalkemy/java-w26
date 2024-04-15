package com.example.codigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class morseCodeController {
    @GetMapping("/{code}")
    public String translateCode(@PathVariable String code){
       String[] list =  code.split("{3}");
       return code;
    }
}
