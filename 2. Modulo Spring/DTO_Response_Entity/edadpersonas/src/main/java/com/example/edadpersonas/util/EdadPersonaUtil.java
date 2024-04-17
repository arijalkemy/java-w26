package com.example.edadpersonas.util;

import java.time.LocalDate;
import java.time.Period;

public class EdadPersonaUtil {
    public static int getEdadPersona(int dia, int mes, int ano) {
        // Obtener la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);

        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcular la diferencia de años entre la fecha actual y la fecha de nacimiento
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears();
    }
}
