package org.edadpersona.service.serviceImpl;

import org.edadpersona.service.EdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadPersonaServiceImpl implements EdadPersonaService {
    @Override
    public Integer calcularEdadPersona(Integer dia, Integer mes, Integer year) {

        LocalDate fechaNacimiento= LocalDate.of(year, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
