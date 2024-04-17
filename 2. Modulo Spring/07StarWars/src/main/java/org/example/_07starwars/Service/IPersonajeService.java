package org.example._07starwars.Service;

import org.example._07starwars.DTO.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> buscarPorNombre(String nombre);
}
