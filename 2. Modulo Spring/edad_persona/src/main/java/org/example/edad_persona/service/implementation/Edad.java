package org.example.edad_persona.service.implementation;


import org.example.edad_persona.service.IEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class Edad  implements IEdad {
    @Override
    public int calcularEdad(int ano, int mes, int dia) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);

        if (fechaNacimiento.isAfter(fechaActual)) return -1;

        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
