package org.mercadolibre.edaddeunapersona.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraEdadServiceImpl implements ICalculadoraEdadService {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
