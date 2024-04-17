package com.deportistas.excercise.service;

import com.deportistas.excercise.dto.PersonaDTO;
import com.deportistas.excercise.model.Deporte;
import com.deportistas.excercise.model.Persona;

import java.util.List;

public interface IDeportesService {

    List<Deporte> getDeportes();

    Deporte getDeporteByName(String nombre);

    List<PersonaDTO> getPersonasDeportistas();

}
