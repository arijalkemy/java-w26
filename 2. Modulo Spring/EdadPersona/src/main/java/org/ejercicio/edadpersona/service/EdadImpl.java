package org.ejercicio.edadpersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadImpl implements IEdad{
    @Override
    public int obtenerAnios(int dia, int mes, int anio) {
        LocalDate date = LocalDate.of(anio, mes, dia);
        int anios = (int) ChronoUnit.YEARS.between(date,LocalDate.now());
        return anios;
    }
}
