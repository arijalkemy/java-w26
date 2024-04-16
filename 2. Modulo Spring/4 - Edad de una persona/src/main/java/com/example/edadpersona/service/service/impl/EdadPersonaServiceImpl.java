package com.example.edadpersona.service.service.impl;

import com.example.edadpersona.service.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Service
public class EdadPersonaServiceImpl implements IEdadPersonaService {
    @Override
    public int calcularEdad( int dia, int mes, int anio ) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anioActual  = localDate.getYear();
        int mesActual = localDate.getMonthValue();
        int diaActual   = localDate.getDayOfMonth();

        int diferenciaAnios = anioActual - anio;

        if( ( mes > mesActual ) || (mes == mesActual && dia > diaActual) ){
            diferenciaAnios--;
        }
        return diferenciaAnios;
    }
}
