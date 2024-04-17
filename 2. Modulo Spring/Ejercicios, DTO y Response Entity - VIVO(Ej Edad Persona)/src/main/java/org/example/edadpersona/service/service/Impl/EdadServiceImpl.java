package org.example.edadpersona.service.service.Impl;

import org.example.edadpersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadServiceImpl implements IEdadPersonaService {
    @Override
    public int calcularEdad(int anioNacimiento, int mesNacimiento, int diaNacimiento) {

        LocalDate fechaNac = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());

        return periodo.getYears();
    }
}
