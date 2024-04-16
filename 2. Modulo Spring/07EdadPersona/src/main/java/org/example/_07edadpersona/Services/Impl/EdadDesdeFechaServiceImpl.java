package org.example._07edadpersona.Services.Impl;

import org.example._07edadpersona.Services.IEdadDesdeFechaService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadDesdeFechaServiceImpl implements IEdadDesdeFechaService {

    public int calcular(int dia, int mes, int anio) {
        LocalDate fechaHoy = LocalDate.now();
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 0 || anio > fechaHoy.getYear()) {
            return -1;
        }
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        return Period.between(fechaNacimiento, fechaHoy).getYears();
    }
}
