package com.demospring.apiedad.services.impl;

import com.demospring.apiedad.services.IEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class Edad implements IEdad {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        return Period.between(LocalDate.parse(dia + "/" + mes + "/" + anio, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now()).getYears();
    }
}
