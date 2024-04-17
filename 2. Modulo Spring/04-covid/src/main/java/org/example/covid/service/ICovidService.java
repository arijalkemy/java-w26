package org.example.covid.service;

import org.example.covid.model.PersonaSintomaDTO;
import org.example.covid.model.SintomaDTO;

import java.util.List;

public interface ICovidService {
    List<SintomaDTO> verSintomas();
    SintomaDTO verSintoma(String nombre);
    List<PersonaSintomaDTO> verPersonasDeRiesgo();

}
