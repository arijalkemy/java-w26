package com.bootcamp.numeroromanos.controller;

import com.bootcamp.numeroromanos.service.INumeroRomanoService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "numero-romano")

public class NumeroRomanoController {

    @Autowired
    private INumeroRomanoService numeroRomanoService;

    @GetMapping(path = "{numero}")
    public String decimalARomano(@Positive @Max(value = 3999) @PathVariable Integer numero) {
        return numeroRomanoService.convertirARomano(numero);
    }


}
