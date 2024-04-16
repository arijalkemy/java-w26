package com.obteneredad.edadpersona.service;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;


@Service
public class CalcularEdad implements IEdad{

    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer ano) {
        try {
            //se obtiene la fecha actual
            LocalDate fechaActual = LocalDate.now();

            //se obtiene la fecha de naciemento en LocalDate
            LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);

            Period diferencia = Period.between(fechaNacimiento, fechaActual);

            return diferencia.getYears();
        } catch (DateTimeException exception){
            return -1;
        }
    }
}
