package com.ejercicios.fechanacimiento.service.impl;

import com.ejercicios.fechanacimiento.service.EdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadServiceImpl implements EdadService {
    @Override
    public Integer calcularEdad(Integer anio, Integer mes, Integer dia) {
        anio = validarInteger(anio);
        mes = validarInteger(mes);
        dia = validarInteger(dia);

        return Period.between(
                LocalDate.of(anio, mes, dia), LocalDate.now()).getYears();
    }

    private Integer validarInteger(Integer valor) {
        if (valor == null || valor < 1) {
            return 1;
        }

        return valor;
    }
}
