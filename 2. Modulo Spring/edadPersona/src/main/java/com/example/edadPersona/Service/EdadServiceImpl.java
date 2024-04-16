package com.example.edadPersona.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadServiceImpl implements EdadService{


    @Override
    public int edadPorFecha(String anio, String mes, String dia) {
        if(!verificacionFecha(anio, mes, dia))
            return -1;
        LocalDate ahora = LocalDate.now();
        return Math.abs(Period.between(ahora,
                LocalDate.parse(anio + mes + dia, DateTimeFormatter.BASIC_ISO_DATE))
                .getYears());
    }
}
