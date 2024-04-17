package com.example.edadPersona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService implements IEdadService{

    @Override
    public Integer calcularEdad(int dia, int mes, int anio) {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fecha, LocalDate.now());
        return periodo.getYears();
    }
}
