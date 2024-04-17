package org.example.starwars.service;

import org.example.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> buscarTodos();
    List<PersonajeDTO> buscarPorNombre(String nombre);
}
