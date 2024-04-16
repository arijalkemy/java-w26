package com.melibootcamp.java.ejercicios1604.serviceImp;

import com.melibootcamp.java.ejercicios1604.service.EdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadSeriveImp implements EdadService {
    @Override
    public int obtenerAnios(int dia, int mes, int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
