package com.example.age.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class EdadServiceImpl implements IEdadService {

    @Override
    public int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaPersona = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.compareTo(fechaPersona);
    }
}
