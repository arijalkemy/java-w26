package com.obteniendo.edad.service.impl;

import com.obteniendo.edad.service.IEdadService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadServiceImpl implements IEdadService {

    LocalDate fechaActual = LocalDate.now();

    @Override
    public int convertirEdad(Integer dia, Integer mes, Integer años) {
        if (dia == null || mes == null || años == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        LocalDate fechaNacimiento = LocalDate.of(años,mes,dia);
        Period period = Period.between(fechaNacimiento,fechaActual);
        int edad = period.getYears();
        return edad;
    }
}
