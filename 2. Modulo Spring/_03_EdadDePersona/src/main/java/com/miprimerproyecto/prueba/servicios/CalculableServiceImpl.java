package com.miprimerproyecto.prueba.servicios;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculableServiceImpl implements ICalculable {


    @Override
    public int obtenerEdad(int dia, int mes, int anio) {
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
