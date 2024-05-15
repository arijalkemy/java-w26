package com.restaurante.calorias.service;

import org.springframework.stereotype.Service;

@Service
public class CaloriasImpl implements ICalorias{

    @Override
    public String calcular(String nombreComida) {
        return "El nombre de la comida es: " + nombreComida;
    }
}
