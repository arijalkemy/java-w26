package com.example.demo.controller;

import com.example.demo.service.interfaces.ISaludarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @Autowired
    ISaludarService saludarService;

    @GetMapping("/saludar/{name}")
    public String saludar(@PathVariable String name) {
        return saludarService.saludar(name);
    }
}
