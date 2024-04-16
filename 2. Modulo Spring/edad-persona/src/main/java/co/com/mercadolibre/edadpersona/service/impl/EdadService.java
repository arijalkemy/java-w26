package co.com.mercadolibre.edadpersona.service.impl;

import co.com.mercadolibre.edadpersona.service.IEdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService implements IEdadService {

    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaDeNacimiento, LocalDate.now());
        return periodo.getYears();
    }
}
