package com.ejercicio.deportistas.services.interfaces;

import com.ejercicio.deportistas.DTOs.SportPersonResponseDTO;

import java.util.List;

public interface IPersonsService {
    public List<SportPersonResponseDTO> getSportsPersons();
}
