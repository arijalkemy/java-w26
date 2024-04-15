package org.example.numerosromanos.controller;

import org.example.numerosromanos.services.IConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversor")
public class ConversorController {

    @Autowired
    IConversorService conversorService;

    @GetMapping("/{num}")
    public String convertirDecimalARomano(@PathVariable int num) {
        String resultado;
        if (num < 1 || num > 3999) {
            resultado = "No se puede convertir " + num + " en numero romano";
        } else {
            resultado = "El decimal " + num + " en numeros romanos es " + conversorService.convertirARomano(num);
        }
        return resultado;
    }

}
