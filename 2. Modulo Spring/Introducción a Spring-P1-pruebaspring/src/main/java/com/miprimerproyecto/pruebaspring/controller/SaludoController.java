package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.ISaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class SaludoController {

    @Autowired
    ISaludoService saludoService;

    @RequestMapping("/{name}")
    public String saludar(@PathVariable String name) {
        return saludoService.saludar(name);
    }

}
