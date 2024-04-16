package com.meli.Covid19.service;

import com.meli.Covid19.models.Sintoma;
import com.meli.Covid19.dto.PersonaDeRiesgoDTO;

import java.util.List;

public interface ISintomaService {
    List<Sintoma> buscarSintomas();
    String buscarNivelDeGravedad(String nombre);
    List<PersonaDeRiesgoDTO> buscarPersonasDeRiesgo();
}
