package org.example.edadpersona.service.impl;

import org.example.edadpersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadPersonaServiceImpl implements IEdadPersonaService {
    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate hoy = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, hoy);

        return periodo.getYears();
    }
}
