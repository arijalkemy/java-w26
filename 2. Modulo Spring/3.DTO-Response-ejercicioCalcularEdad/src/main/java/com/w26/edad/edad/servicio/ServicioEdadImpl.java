package com.w26.edad.edad.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ServicioEdadImpl implements IServicioEdad {

    @Override
    public int calcularEdad(int dia, int mes, int ano) {
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
        LocalDate tiempoActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, tiempoActual);
        return periodo.getYears();
    }
}
