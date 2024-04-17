package com.covi.covid_19.Services;

import com.covi.covid_19.Classes.Persona;
import com.covi.covid_19.Classes.Sintoma;
import com.covi.covid_19.DTO.PersonaSistemaDTO;

import java.util.ArrayList;
import java.util.List;

public interface ISistemaService {
    List<Sintoma> sintoma = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    void agregarSintoma(Sintoma sintoma);
    String conseguirSintomaPorNombre(String nombre);
    List<Sintoma> conseguirTodosLosSintomas();

    void agregarPersona(Persona persona) throws Exception;
    List<Persona> conseguirTodasLasPersonas();

    List<PersonaSistemaDTO> conseguirTodasLasPersonasDTO();

    PersonaSistemaDTO convertirDTO(Persona persona);
}
