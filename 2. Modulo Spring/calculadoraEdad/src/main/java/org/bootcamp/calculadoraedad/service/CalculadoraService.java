package org.bootcamp.calculadoraedad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalculadoraService {
    public long calcularEdad(int dia, int mes, int ano){
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        long diferenciaDeAnios = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        return diferenciaDeAnios;
    }
}
