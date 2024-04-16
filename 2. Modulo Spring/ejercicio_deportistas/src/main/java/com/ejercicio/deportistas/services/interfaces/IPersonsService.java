package com.ejercicio.deportistas.services.interfaces;

import com.ejercicio.deportistas.DTOs.SportsPersonsDTO;

import java.util.List;

public interface IPersonsService {
    public List<SportsPersonsDTO> getSportsPersons();
}
