package com.bootcamp.arqrestvivo.services;

import com.bootcamp.arqrestvivo.services.interfaces.IEdadService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class EdadServiceImpl implements IEdadService {
    @Override
    public int calcularEdad(int dia, int mes, int año) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(año,mes,dia);

        if(fechaNacimiento.isAfter(fechaActual)) throw new RuntimeException("La fecha de nacimiento es posterior a la fecha actual");

        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
