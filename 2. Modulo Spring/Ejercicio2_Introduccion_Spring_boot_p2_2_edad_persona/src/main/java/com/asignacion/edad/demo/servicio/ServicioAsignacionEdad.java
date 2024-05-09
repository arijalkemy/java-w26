package com.asignacion.edad.demo.servicio;

import com.asignacion.edad.demo.modelo.AsignacionEdad;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;


@Service
public class ServicioAsignacionEdad implements IAsignacionEdad{
    //Atributos
    private AsignacionEdad miAsignacionEdad;

    //Asigna las variables de la fecha de nacimiento de una persona
    @Override
    public void calcularEdad(Integer dia, Integer mes, Integer agno) {
        miAsignacionEdad = new AsignacionEdad(dia, mes, agno);
        // Fecha actual
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(agno, mes, dia);
        // Calcular la edad
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();
        miAsignacionEdad.setEdad(edad);
    }

    @Override
    public Integer asignarEdad() {
        return miAsignacionEdad.getEdad();
    }
}
