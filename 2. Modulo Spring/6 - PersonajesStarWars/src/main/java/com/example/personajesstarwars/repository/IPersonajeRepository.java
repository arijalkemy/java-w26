package com.example.personajesstarwars.repository;

import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> obtenerNombres();
}
