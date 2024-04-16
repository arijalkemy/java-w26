package com.spring.deportistas_dto_ej.Services;

import com.spring.deportistas_dto_ej.Dtos.PersonaDto;
import com.spring.deportistas_dto_ej.Models.Deporte;

import java.util.List;
import java.util.Optional;

public interface ISportsService {
    List<Deporte> findSports();
    Optional<Deporte> findSport(String name);
    List<PersonaDto> findSportsPersons();
}
