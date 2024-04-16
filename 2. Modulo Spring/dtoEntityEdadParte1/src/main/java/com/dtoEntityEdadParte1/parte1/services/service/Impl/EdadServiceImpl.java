package com.dtoEntityEdadParte1.parte1.services.service.Impl;

import com.dtoEntityEdadParte1.parte1.services.interfaces.IEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadServiceImpl implements IEdadService {
    @Override
    public int calcularEdad(String dia, String mes, String anio) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dia+"/"+mes+"/"+anio, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        System.out.println(periodo.getYears());
        return periodo.getYears();
    }
}
