package com.spring.deportistas.Services.Interfaces;

import com.spring.deportistas.Models.Persona;
import com.spring.deportistas.Models.dtos.PersonaDto;

import java.util.List;

public interface IPersonaService {
    List<PersonaDto> getAllWithDeportes();
}
