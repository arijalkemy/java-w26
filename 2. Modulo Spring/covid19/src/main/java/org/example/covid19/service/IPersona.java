package org.example.covid19.service;

import org.example.covid19.dto.PersonaDto;
import org.example.covid19.model.Sintoma;

import java.util.List;

public interface IPersona {
    List<Sintoma> getAllSintomas();

    Sintoma getSymptomByName(String nombre);

    List<PersonaDto> getRiskPersons();
}
