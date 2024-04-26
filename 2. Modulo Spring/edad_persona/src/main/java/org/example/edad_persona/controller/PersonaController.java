package org.example.edad_persona.controller;


import org.example.edad_persona.service.IEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IEdad edad;

    @GetMapping("/v1/{dia}/{mes}/{ano}")
    private String calcularEdad(@PathVariable int ano, @PathVariable int mes, @PathVariable int dia){
        if(edad.calcularEdad(ano,mes,dia) < 0) return "La fecha no es valida";

        return String.valueOf(edad.calcularEdad(ano, mes, dia));
    }
}
