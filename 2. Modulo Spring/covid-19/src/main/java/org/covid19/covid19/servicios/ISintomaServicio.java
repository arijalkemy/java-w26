package org.covid19.covid19.servicios;

import org.covid19.covid19.dto.SintomaDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISintomaServicio {
     List<SintomaDto> obtenerTodosLosSintomas();
     public List<SintomaDto> obtenerSintomaPorNombre(String nombre);
}
