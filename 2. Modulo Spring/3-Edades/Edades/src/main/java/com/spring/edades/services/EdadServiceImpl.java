package com.spring.edades.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadServiceImpl implements IEdadService{
    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period period = Period.between(fechaNacimiento, LocalDate.now());
        return period.getYears();
    }
}
