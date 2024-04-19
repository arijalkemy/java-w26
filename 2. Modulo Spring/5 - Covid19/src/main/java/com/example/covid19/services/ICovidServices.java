package com.example.covid19.services;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.models.Sintoma;

import java.util.List;

public interface ICovidServices {
    public List<Sintoma> listarSintomas();
    String consultarSintoma(String nombreSintoma);
    public List<PersonaDTO> buscarPersonasDeRiesgo();
}
