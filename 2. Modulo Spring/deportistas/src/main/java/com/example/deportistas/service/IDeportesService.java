package com.example.deportistas.service;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.model.Deporte;

import java.util.List;

public interface IDeportesService {

    public List<Deporte> findSports();
    public DeporteDTO findSport(String nombre);
    public List<PersonaDTO> findSportsByPersons();
}
