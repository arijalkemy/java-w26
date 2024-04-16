package com.example.calcularedad.service;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalcularEdad implements ICalcularEdad{

    @Override
    public int calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaCumple = LocalDate.of(anio, mes, dia);

        int anioActual = fechaActual.getYear();
        int diaActual = fechaActual.getDayOfYear();

        int diaCumple = fechaCumple.getDayOfYear();

        int cumpleanio = anioActual - anio;
        if (diaActual < diaCumple){
            cumpleanio--;
        }
        return cumpleanio;
    }
}
