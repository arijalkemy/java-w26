package com.example.numerosromanos.controller;

import com.example.numerosromanos.service.ServicioRomano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRomano {

    @Autowired
    private ServicioRomano servicioRomano;

    @GetMapping("/romano/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        if (numero < 1 || numero > 3999) {
            return "Número inválido (debe ser entre 1 y 3999)";
        }
        else{
            return "El número " +numero+" luce de esta forma: "+ servicioRomano.convertirARomano(numero);
        }
    }
}
