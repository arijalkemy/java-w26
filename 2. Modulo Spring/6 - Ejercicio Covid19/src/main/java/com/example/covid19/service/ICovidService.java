package com.example.covid19.service;

import com.example.covid19.clases.Sintoma;
import com.example.covid19.dto.PersonaDto;

import java.util.List;

public interface ICovidService {

    public List<Sintoma> obtenerSintomas();

    public int nivelGravedad( String nombre );

    public List<PersonaDto> buscarPersonasDeRiesgo();
}
