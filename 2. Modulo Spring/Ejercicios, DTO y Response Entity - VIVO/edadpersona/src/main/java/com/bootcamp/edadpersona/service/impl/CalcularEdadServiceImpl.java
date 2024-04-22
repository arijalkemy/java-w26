package com.bootcamp.edadpersona.service.impl;

import com.bootcamp.edadpersona.service.ICalcularEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalcularEdadServiceImpl implements ICalcularEdadService {
    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate birthDate = LocalDate.of(anio, mes, dia);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}
