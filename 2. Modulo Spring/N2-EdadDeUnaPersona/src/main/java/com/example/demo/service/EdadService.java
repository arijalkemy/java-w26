package com.example.demo.service;

import com.example.demo.service.impl.IEdadServicio;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService implements IEdadServicio {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        // Obtengo la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Creo la fecha de nacimiento a partir de los parámetros
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        // Calculo la edad
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}