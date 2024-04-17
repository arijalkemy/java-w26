package com.example._06_starwars.service;

import com.example._06_starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> obtenerPersonajes();
    public List<PersonajeDTO> obtenerPersonajesPorNombre(String nombre);

}
