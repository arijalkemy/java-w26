package com.bootcamp.numerosromanos.controller;

import com.bootcamp.numerosromanos.service.INumeroRomanoService;
import com.bootcamp.numerosromanos.service.implementation.NumeroRomanoService;
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

    private INumeroRomanoService numeroRomanoService;

    @GetMapping(path = "{nro}")
    public String decimalARomano(@Positive @Max(value = 3999) @PathVariable Integer nro) {
        return numeroRomanoService.convertirARomano(nro);
    }
}
