package com.ejercicio.deportistas.services.interfaces;

import com.ejercicio.deportistas.DTOs.SportsPersonsResponseDTO;

import java.util.List;

public interface IPersonsService {
    public List<SportsPersonsResponseDTO> getSportsPersons();
}
