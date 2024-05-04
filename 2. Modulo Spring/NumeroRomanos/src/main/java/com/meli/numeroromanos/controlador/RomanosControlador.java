package com.meli.numeroromanos.controlador;

import com.meli.numeroromanos.services.INumerosRomanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosControlador {
    @Autowired
    INumerosRomanos nr;

    @GetMapping("/encode/{numero}")
    public String encode(@PathVariable int numero) {
       return "El número " + numero + " en número romano es: " + nr.encode(numero);
    }
}
