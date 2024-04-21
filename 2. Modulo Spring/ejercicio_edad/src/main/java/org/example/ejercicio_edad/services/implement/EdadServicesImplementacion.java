package org.example.ejercicio_edad.services.implement;

import org.example.ejercicio_edad.services.IEdadServices;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class EdadServicesImplementacion implements IEdadServices {

    @Override
    public Long calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        if(LocalDate.now().isAfter(fecha)) throw new IllegalArgumentException("La fecha no puede ser posterior a la fecha actual");
        return ChronoUnit.YEARS.between(fecha, LocalDate.now());
    }
}
