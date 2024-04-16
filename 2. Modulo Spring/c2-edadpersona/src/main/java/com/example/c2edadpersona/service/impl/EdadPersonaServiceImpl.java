package com.example.c2edadpersona.service.impl;

import com.example.c2edadpersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadPersonaServiceImpl implements IEdadPersonaService {
    @Override
    public Integer edadPersona(int dia, int mes, int anio) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dia+"/"+mes+"/"+anio, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        return periodo.getYears();
    }
}
