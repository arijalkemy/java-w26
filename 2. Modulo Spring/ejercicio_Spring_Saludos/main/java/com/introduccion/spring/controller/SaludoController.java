package com.introduccion.spring.controller;

import com.introduccion.spring.service.ISaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludos")
public class SaludoController {
    @Autowired
    ISaludoService saludar;

    @GetMapping("/{name}")
    public String SayHello(@PathVariable String name){
        return "Hello World: " + name;
    }
}
