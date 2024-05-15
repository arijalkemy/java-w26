package com.api_rest.calcular_edad.controllers;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EdadImpl implements IEdad {

    @Override
    public String calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDateTime now = LocalDateTime.now();
        Integer edad = now.getYear() - anio;
        if(now.getMonthValue() < mes){
            edad--;
        }
        if(now.getMonthValue() == mes){
            if(now.getDayOfMonth() < dia){
                edad--;
            }
        }
        return "Según la fecha de nacimiento ingresada, la edad es: " + edad;
    }
}
