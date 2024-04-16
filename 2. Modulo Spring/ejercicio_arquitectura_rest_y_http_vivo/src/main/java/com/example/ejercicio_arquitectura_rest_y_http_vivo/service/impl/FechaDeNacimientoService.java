package com.example.ejercicio_arquitectura_rest_y_http_vivo.service.impl;

import com.example.ejercicio_arquitectura_rest_y_http_vivo.service.IFechaDeNacimientoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class FechaDeNacimientoService implements IFechaDeNacimientoService {
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaHoy = LocalDate.now();

        return Period.between(fechaDeNacimiento, fechaHoy).getYears();
    }
}
