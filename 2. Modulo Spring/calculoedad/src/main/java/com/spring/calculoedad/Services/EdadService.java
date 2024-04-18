package com.spring.calculoedad.Services;

import com.spring.calculoedad.Interfaces.IEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService implements IEdad {


    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = LocalDate.of(anio,mes,dia);
        return Period.between(fechaNac, fechaActual).getYears();
    }
}

