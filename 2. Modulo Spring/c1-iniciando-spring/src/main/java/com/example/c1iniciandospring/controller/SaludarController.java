package com.example.c1iniciandospring.controller;

import com.example.c1iniciandospring.service.ISaludarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludarController {
    @Autowired
    ISaludarService saludarService;
    @GetMapping("/saludar/{nombre}")
    public String saludar(@PathVariable String nombre){
        return saludarService.saludar(nombre);
    }
}
