package com.EjercicioSpring.Ejercicio5_EdadPersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

@Service
public class CalculadoraEdadImpl implements ICalculadoraEdadService {
    @Override
    public String getEdad(int dia, int mes, int anio) {
        if (dia <= 31 && dia >= 1 && mes >= 1 && mes <= 12 && anio <= LocalDate.now().getYear()) {
            if (Month.of(mes).length(true) >= dia) {// el true en el lenght permite tener en cuenta si es bisiesto
                LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
                Period edad = Period.between(fechaNacimiento, LocalDate.now());
                return edad.getYears() + "";
            } else {
                return "Los días no corresponden al mes descrito";
            }
        } else {
            return "Los valores están fuera del rango";
        }
    }
}
