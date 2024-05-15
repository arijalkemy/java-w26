package com.restaurante.calorias.controller;

import com.restaurante.calorias.service.ICalorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calorias")
public class CaloriasController {

    @Autowired
    ICalorias calorias;

    @GetMapping("/calcular/{nombreComida}")
    public String calcularCalorias (@PathVariable String nombreComida) {
        return calorias.calcular(nombreComida);
    }
}
