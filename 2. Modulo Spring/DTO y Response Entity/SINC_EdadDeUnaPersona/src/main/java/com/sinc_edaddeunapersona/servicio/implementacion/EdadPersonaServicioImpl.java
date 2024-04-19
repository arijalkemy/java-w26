package com.sinc_edaddeunapersona.servicio.implementacion;

import com.sinc_edaddeunapersona.servicio.IEdadPersonaServicio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadPersonaServicioImpl implements IEdadPersonaServicio {
    @Override
    public Integer calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaRecibida = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaRecibida,LocalDate.now());

        return periodo.getYears();
    }
}
