package org.mercadolibre.covid.service;

import org.mercadolibre.covid.dto.PersonaDTO;
import org.mercadolibre.covid.entity.Sintoma;

import java.util.List;

public interface ISaludService {

    public List<Sintoma> getSintomas();
    public int getGravedadDeSintoma(String nombreSintoma);
    public List<PersonaDTO> getPersonasDeRiesgo();
}
