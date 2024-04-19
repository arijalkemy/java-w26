package com.example.personajesstarwars.services;

import com.example.personajesstarwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> buscarPorNombre(String nombre);
}
