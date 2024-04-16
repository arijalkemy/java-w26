package com.Bootcamp.SpringP1ejercicioNumerosRomanos.controller;

import com.Bootcamp.SpringP1ejercicioNumerosRomanos.service.ItraducirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traductor")
public class TraducirController {

    @Autowired
    ItraducirService traducirService;
    @GetMapping("/traducirMorse/{texto}")
    public String traducirMorse(@PathVariable String texto){
        return traducirService.traducirMorse(texto);
    }

    @GetMapping("/traducirEspanol/{texto}")
    public String traducirEspanol(@PathVariable String texto){
        return traducirService.traducirEspanol(texto);
    }
}
