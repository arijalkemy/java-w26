package com.meli.calcularedadejerciciopractico.Service.ServiceImpl;
import com.meli.calcularedadejerciciopractico.Service.ICalcularEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalcularEdadService implements  ICalcularEdad{
    @Override
    public String calcularEdad(LocalDate fechaNacimiento) {

        try {
            if (fechaNacimiento.isAfter(LocalDate.now()))
                throw new IllegalArgumentException("Fecha de nacimiento no puede ser mayor a la fecha actual");

            return Integer.toString (LocalDate.now().getYear() - fechaNacimiento.getYear());
        }catch (IllegalArgumentException e){
            return "Error: " +e.getMessage();
        }

    }
}
