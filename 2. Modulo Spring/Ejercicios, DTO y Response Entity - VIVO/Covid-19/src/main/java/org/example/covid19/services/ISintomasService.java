package org.example.covid19.services;

import org.example.covid19.dto.PersonaDTO;
import org.example.covid19.dto.SintomaDto;

import java.util.List;

public interface ISintomasService {
    List<SintomaDto> obtenerListaDeSintomas();
    SintomaDto obtenerSintomaPorNombre(String nombre);

}
