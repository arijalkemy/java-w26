package com.spring.calcularedad.Services.CalculatorService.Impl;

import com.spring.calcularedad.Services.CalculatorService.ICalculatorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {

        // fecha en este momento
        LocalDate fechaHoy = LocalDate.now();

        // fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        // comparacion y calculo
        return Period.between(fechaNacimiento, fechaHoy).getYears();
    }

}
