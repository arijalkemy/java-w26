package com.example.starWars.service;

import com.example.starWars.dto.PersonajeDto;
import com.example.starWars.model.Personaje;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {

    List<PersonajeDto> findAll();
    PersonajeDto findByName(String name);
}
