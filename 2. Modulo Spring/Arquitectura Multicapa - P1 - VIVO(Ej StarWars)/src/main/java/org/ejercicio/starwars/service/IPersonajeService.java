package org.ejercicio.starwars.service;

import org.ejercicio.starwars.dto.PersonajeDTO;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> mostrarPersonajes(String name) throws IOException;

}
