package org.example.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.starwars.dto.PersonajeDTO;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> buscarPersonajes(String nombre) throws IOException;
}
