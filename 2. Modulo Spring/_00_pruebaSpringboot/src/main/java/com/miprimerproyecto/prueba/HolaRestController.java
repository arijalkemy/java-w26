package com.miprimerproyecto.prueba;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Saludo/{nombre}")
public class HolaRestController {
    @GetMapping
    public String saludar(@PathVariable String nombre){
        return "Hola " + nombre;
    }
}
