package com.example.edad.serviceImpl;

import com.example.edad.service.IEdad;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadImpl implements IEdad {


    @Override
    public int calcularEdad(int dia, int mes, int año) {

        try{
            LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            Period diferencia = Period.between(fechaNacimiento, fechaActual);
            return diferencia.getYears();
        } catch (DateTimeException e){
            return -1;
        }


    }
}
