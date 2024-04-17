package com.example.personajesStarWars.service;

import com.example.personajesStarWars.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {

    public List<PersonaDTO> buscarPersonajes(String nombre);
}
