package com.EdadDeUnaPersona.EdadDeUnaPersona.services.servicesImpl;

import com.EdadDeUnaPersona.EdadDeUnaPersona.services.interfaces.IPersonaService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Override
    public Integer mapEdadPersona(Integer dia, Integer mes, Integer anio) {

        LocalDate hoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, hoy);
        return periodo.getYears();
    }
}
