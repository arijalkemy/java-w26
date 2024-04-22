package com.bootcamp.DTO.y.Response.Entity.Edad.de.una.Persona.controllers;

import com.bootcamp.DTO.y.Response.Entity.Edad.de.una.Persona.services.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Persona {
    @Autowired
    IPersona persona;

    @GetMapping("/edad/{day}/{month}/{year}")
    public int calculateAge(
        @PathVariable Integer day,
        @PathVariable Integer month,
        @PathVariable Integer year
    ) {
        try {
            return persona.calculateAge(day, month, year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
