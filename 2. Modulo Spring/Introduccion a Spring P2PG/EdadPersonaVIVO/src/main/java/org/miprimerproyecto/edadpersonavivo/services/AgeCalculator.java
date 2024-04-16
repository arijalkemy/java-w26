package org.miprimerproyecto.edadpersonavivo.services;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static int calculateAge(int day, int month, int year) {
        int age=0;
        LocalDate fechaNacimiento= LocalDate.of(year, month, day);
        LocalDate fechaActual= LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        age= periodo.getYears();
        return age;
    }
}
