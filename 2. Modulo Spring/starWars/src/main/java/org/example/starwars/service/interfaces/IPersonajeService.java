package org.example.starwars.service.interfaces;

import org.example.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> getPersonaje(String personaje);
}
