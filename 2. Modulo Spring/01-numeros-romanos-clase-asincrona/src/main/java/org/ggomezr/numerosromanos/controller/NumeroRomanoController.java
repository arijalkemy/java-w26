package org.ggomezr.numerosromanos.controller;

import org.ggomezr.numerosromanos.service.impl.NumeroRomanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertir")
public class NumeroRomanoController {

    @Autowired
    private NumeroRomanoService numeroRomanoService;

    @GetMapping("/{numero}")
    public String convertirANumeroRomano(@PathVariable int numero){
        return numeroRomanoService.convertirANumeroRomano(numero);
    }
}
