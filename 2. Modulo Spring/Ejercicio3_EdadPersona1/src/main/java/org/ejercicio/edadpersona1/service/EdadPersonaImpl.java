package org.ejercicio.edadpersona1.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadPersonaImpl implements  IEdadPersona {
    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate date = LocalDate.of(anio, mes, dia);
        int edad = (int) ChronoUnit.YEARS.between(date,LocalDate.now());
        return edad;
    }
}
