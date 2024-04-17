package com.edadpersona.excercise.service.impl;

import com.edadpersona.excercise.service.IPersonaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class IPersonaServiceImpl implements IPersonaService {

        @Override
        public Integer obtenerEdadDePersona(Integer anio, Integer mes, Integer dia) {

            if (anio < 0 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
                throw new IllegalArgumentException("La fecha proporcionada es inválida.");
            }

            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaParametro = LocalDate.of(anio, mes, dia);

            if (fechaParametro.isAfter(fechaActual)) {
                throw new IllegalArgumentException("La fecha proporcionada es en el futuro.");
            }

            int diferenciaEnAnios = Period.between(fechaParametro, fechaActual).getYears();

            return diferenciaEnAnios;
        }
}
