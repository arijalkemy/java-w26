package com.meli.calcularedad_vivo.services.imp;
import com.meli.calcularedad_vivo.services.ICalcularEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalcularEdadImp implements ICalcularEdad {
    @Override
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        System.out.println("Calculando edad..."+dia+"/"+mes+"/"+anio);
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
