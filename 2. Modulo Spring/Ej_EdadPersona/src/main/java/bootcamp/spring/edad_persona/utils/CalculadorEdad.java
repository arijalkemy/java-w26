package bootcamp.spring.edad_persona.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * CalculadorEdad
 */
public class CalculadorEdad {

  public static Integer calcularEdadPorFecha(Integer dia, Integer mes, Integer anio) {

    LocalDate nacimientoPersona = LocalDate.of(anio, mes, dia);
    LocalDate fechaActual = LocalDate.now();
    return Period.between(nacimientoPersona, fechaActual).getYears();
  }
}
