package com.example.edadPersona.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public interface EdadService {

    public int edadPorFecha(String anio, String mes, String dia);

    default boolean verificacionFecha(String anio, String mes, String dia){
        try {
            DateTimeFormatter formatoFecha = DateTimeFormatter.BASIC_ISO_DATE;
            LocalDate.parse(anio + mes + dia, formatoFecha);
            if(LocalDate.parse(anio + mes + dia, formatoFecha).isAfter(LocalDate.now()))
                throw new DateTimeException("Fecha despues de la actual");
        }catch (DateTimeException e){
            return false;
        }
        return true;
    }
}
