package org.example.covid.service;

import org.example.covid.dto.GravedadSintomaDTO;
import org.example.covid.dto.PersonaNombresDTO;
import org.example.covid.model.Sintoma;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISintomaService {
    public ResponseEntity<List<Sintoma>> getSintomas();
    public ResponseEntity<GravedadSintomaDTO> getGravedadSintoma(String sintoma);
    ResponseEntity<List<PersonaNombresDTO>> getPersonasDeRiesgo();
}
