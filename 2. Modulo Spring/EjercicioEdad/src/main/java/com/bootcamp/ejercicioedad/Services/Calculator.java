package com.bootcamp.ejercicioedad.Services;

import com.bootcamp.ejercicioedad.Interfaces.ICalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class Calculator  implements ICalculator {
    @Override
    public String calcularEdad(int dia, int mes, int anio) {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        return  String.valueOf(Period.between(fecha, LocalDate.now()).getYears());
    }
}
