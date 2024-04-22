package com.bootcamp.romanos.controller;

import com.bootcamp.romanos.Service.IConvertidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanos")
public class RomanosController {

    @Autowired
    IConvertidorService convertidorService;

    @GetMapping("/{numero}")
    public String convertirANumerosRomanos(@PathVariable int numero) {
        if(numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("El convertidor funciona para valores entre 1 y 3999");
        }
        return convertidorService.convertirANumerosRomanos(numero);
    }

}
