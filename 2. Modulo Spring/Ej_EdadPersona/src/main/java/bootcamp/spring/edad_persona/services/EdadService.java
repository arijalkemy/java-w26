package bootcamp.spring.edad_persona.services;

import org.springframework.stereotype.Service;

import bootcamp.spring.edad_persona.utils.CalculadorEdad;

@Service
/**
 * EdadService
 */
public class EdadService {

  public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
    return CalculadorEdad.calcularEdadPorFecha(dia, mes, anio);
  }
}
