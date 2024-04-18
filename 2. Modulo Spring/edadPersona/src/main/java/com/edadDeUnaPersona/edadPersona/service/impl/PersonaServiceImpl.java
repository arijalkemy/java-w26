package com.edadDeUnaPersona.edadPersona.service.impl;

import com.edadDeUnaPersona.edadPersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonaServiceImpl implements IEdadPersonaService {

    public int obtenerEdad(int dia, int mes, int anio) {

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        Period period = Period.between(fechaNacimiento, fechaActual);
        return period.getYears();
    }

}
