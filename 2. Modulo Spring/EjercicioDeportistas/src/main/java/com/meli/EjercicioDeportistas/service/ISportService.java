package com.meli.EjercicioDeportistas.service;

import com.meli.EjercicioDeportistas.models.Sport;
import com.meli.EjercicioDeportistas.dto.SportPersonDTO;

import java.util.List;
import java.util.Optional;

public interface ISportService {
    List<Sport> getAll();

    Optional<Sport> getByName(String sportName);

    List<SportPersonDTO> getSportsPersons();
}
